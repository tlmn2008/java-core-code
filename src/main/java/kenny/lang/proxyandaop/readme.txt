

代理分为两种：
静态代理：编译时生成的代理类；
动态代理：运行时生成，直接存在于内存中。
java.lang.reflect中的Proxy即是用来做动态代理的。

动态代理更实用，且有诸多框架实现，如asm, cglib, javassit等。
PS:asm是轻量级的类库，cglib底层是基于asm的，javassist完全基于Java API，简单但性能稍微差点。

为什么使用动态代理？
相对于静态代理，减少了一些代码量。
相对于静态代理，程序扩展性更好。
动态代理中，代理类的逻辑，与被代理类的逻辑，完全分离开来，耦合度降低
动态代理的优势就是实现无侵入式的代码扩展
动态代理实现了在原始类和接口未知的时候，就确定代理的代理行为，当代理类和原始类脱离直接联系后，就可以灵活的重用到不同的应用场景中




java.lang.instrument VS spring instrument:
其中spring instrument只对java.lang.instrument进行了简单的封装。
spring中有asm的class，和Java asm包里的差不多。 asm底层用到了JVM的指令。




要想将编译时不存在的类在运行时动态创建和加载，一般有两种策略：
1.动态编译Java文件；
2.动态生成class文件。
后者更实用，且有诸多框架实现，如asm, cglib, javassit等。
PS:asm是轻量级的类库，cglib底层是基于asm的，javassist完全基于Java API，简单但性能稍微差点。

关于代理的小练习：(Vehicle是接口)
ElectricCar car = new ElectricCar();
MyInvocationHandler handler = MyInvocationHandler(car);

//静态代理时
Vehicle carProxy1 = new ElectricCarProxy(handler);
carProxy1.drive();

//动态代理时
Vehicle carProxy2 = (Vehicle)Proxy.newProxyInstance(car.getClass().getClasLoader(), car.getclass().getInstances, handler)
carProxy2.drive();

上面的静态代理会生成静态代理类ElectricCarProxy，而下面的动态代理则不同。
PS:newProxyInstance底层用到了JRE的rt.jar中sun.misc包中的ProxyGenerator来生成代理类。

Java动态代理： java.lang.refect.Proxy类 java.lang.refect.InvocationHandler接口。

补充：
spring aop是基于jdk proxy和cglib实现的。
未实现接口的被代理类用jdk proxy的方式创建代理类；
实现接口的被代理类用cglib的方式创建代理类。