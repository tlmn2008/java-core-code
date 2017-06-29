1.
class xxx{
static{
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


class都继承自Object，而Object有一个native的getClass方法返回一个class<?>对象。
这个对象就是某个类的Class对象。