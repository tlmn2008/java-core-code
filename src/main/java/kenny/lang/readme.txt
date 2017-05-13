甲骨文官方手册：
http://docs.oracle.com/javase/7/docs/api/

java的8种基本数据类型和void类型都有自己的class类。 如void有Java.lang.Void类，它是一个不能被实例化的占位符，保存了一个void的class对象的引用。


class xxx{
staic{
} //编译器会将里面的代码放入<clinit>中
static int a;
static void funca(){};

{
} //编译器会将里面的代码放入<init中>
int b;
void funcb(){};
}
PS:
静态块和非静态块的区别是：前者在类加载时执行，后者在类初始化的之后执行。
如果类的多个构造函数有相同的代码，那么可以将其放入非静态块中，这样编译器会自动 将这些代码放好。
classloader装载完class文件后再调用静态块等，即完成了class对象的创建。 class对象可以创建相应的实例并调用静态构造方法。



Java特殊关键字： strictfp: strict float point 精确浮点。 transient: 跟对象序列化有关。 volatile: 跟并发编程有关。


池技术：内存池，线程池，连接池等。

实现了Serializable接口的class需要声明一个long的serialVersionUID,用来标示当前class的版本号。
标签接口：如Serialize 一个实现了标签接口的类，可以使用if(xxx instanceof Serialize)来 识别这个类是否属于某个类，所以比较实用。



C++创建拷贝对象时有两种方式：
Person p2 = p1;
Person p2(p1);
两者都会调用拷贝构造函数（特殊的构造函数）

Java中也有类型拷贝函数clone()，使用方法是：Person p2 = (Person)p1.clone();



Java中不能实用goto，但可以用break label或continue label来实现。


Java.util中有很多有用的类： Date, Random, Timer, UUID, Set, Map等。



Java中分基本类型和引用类型： 引用类型又分为:类类型和接口类型。泛型类类型和泛型接口类型。 类类型数组和接口类型数组是存在的，泛型数组是没有的。

C++允许直接操作内存，所以有指针的存在。


字节码文件只区分类和接口，所以枚举和注解都是最终被解释成接口的，只是特殊接口而已。

class都继承自Object，而Object有一个native的getClass方法返回一个class<?>对象。

Java.util.Arrays类提供了各种数组的操作工具方法。 另外System.arrayCopy()提供了快速的数组拷贝。



System.identityHashCode(obj)用于获取对象头中的hashcode，
这个值是JVM根据对象内存地址来计算的，每次运行时地址 会变，所以hashcode会变，但单次执行中是全局唯一的。
对于object其中的hashCode()返回的也就是上面的hashcode，该函数是native的即JVM的函数。
举例： Object obj = new Object(); System.identityHashCode(obj) == obj.hashCode();

需要注意的是：String对象由于其重写了hashCode()函数，所以不一样了。

class Person{ String name; int id; }
假设有两个引用：person1和person2，如果两个引用指向同一个对象，那么person1 == person2 (==实际是调用了equals()) 这是因为hashcode相等。
但是如果两个引用分别指向两个对象，hashcode不一样，所以person1 != person2 而要将逻辑上相同名字和相同ID的人看出是相同的人，则若不重些Person的equals()方法，
那么默认的 结果则是比较hashcode即不相等，所以需要重新。
如果重写了equals()，一般也会重写hashcode(),因为既然对象相等，则hashcode也应该一样。



Java编译器会把所有类变量的初始化和类初始化器收集到方法内，该方法 只能被JVM调用。
并非所有的类都有方法。 Java编译器会为每个类至少生成一个方法，所以这就是为什么有默认构造方法的存在。
如果一个类 有多个构造器，则class文件中会有多个方法。



Static是没有this的方法。Static方法具有全局函数的语义，使用static方法时，由于不存在this，所以不是通过“向对象发送消息”的方式来完成的。




每个编译单元（一个Java文件）只能有一个public类。
当编译一个Java文件时，每个类都会输出一个.class文件。所以编译少量的Java文件会产生许多.class文件。



每一个非基本类型的对象都有一个toString()方法，而且当编译器需要一个string而你却只有一个对象时，该方法便会被调用。

void方法会有一个隐式的return。所以不必在该方法中添加return语句。
一个类也有一个默认的无参构造器，如果你已经定义了一个构造器，那么编译器不会给你创建那个默认的构造器了。
构造器默认也就是个静态方法，虽然不用显示指明。
java暗自把所操作对象的引用作为第一参数传递给了成员方法。可以使用return this返回这个对象的引用。



C++中有的操作符重载在Java中由于过于复杂而没有了。
包访问权限类似C++的friendly，友元。

C++中普通成员函数加上virtual关键字就成为虚函数
Java中其实没有虚函数的概念，它的普通函数就相当于C++的虚函数，动态绑定是Java的默认行为。如果Java中不希望某个函数具有虚函数特性，可以加上final关键字变成非虚函数

C++中纯虚函数形式为：virtual void print() = 0;
Java中纯虚函数形式为：abstract void print();

C++中抽象类只需要包括纯虚函数，既是一个抽象类。如果仅仅包括虚函数，不能定义为抽象类，因为类中其实没有抽象的概念。
Java抽象类是用abstract修饰声明的类。
PS: 抽象类其实是一个半虚半实的东西，可以全部为虚，这时候变成接口。

C++中接口其实就是全虚类。
Java中接口是用interface修饰的类。
PS: 接口就是虚到极点的抽象类。


类有三种基本的关系：
1.结合关系；
2.聚合关系；
3.组合关系。




*******************************************************************************

RFC request for comments 收集了互联网相关的协议
网址：www.ietf.org/rfc

JSR: java specification requests Java技术文档
官网：https://jcp.org//en/home/index




Java和javaw运行看执行jar的区别是前者会启动console和GUI，而后者只启动GUI。

对于非GUI程序，需用Java打开，用javaw会没有console；
对于Gui程序，用Java打开会同时有console和GUI，用Java打开会只有GUI。

windows平台默认用javaw打开，可以修改注册表来用Java打开，方便调试。
HKEY_CLASS_ROOT/jarfile/shell/open/command





















