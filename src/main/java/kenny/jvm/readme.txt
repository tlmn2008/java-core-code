
JVM:在Linux下默认的字符编码格式是UNICODE的，windows下是GBK的，可以通过Charset.default()来获取默认字符集名称。

Java class文件头四字节code是：CA FE BA BE

JVM提供4种指令来调用方法：
1.invoke static：调用静态方法；
2.invoke special：调用构造方法和私有方法；
3.invoke virtual：调用实例方法；
4.invoke interface：调用接口方法。

Java引用分：
强引用；
弱引用； //在下一次GC时被回收掉
软引用； //内存溢出时被回收掉
虚引用。 //被回收时程序会受到一个系统通知。


Java堆中的对象头包含了哈希码，GC代，锁等信息。

Java的object对象大小为4字节（存放指针），按8字节对齐则占空间为8字节。

classloader.loadclass()和class.forname()的区别是： 后者会在加载类之后在执行类的初始化。


JVM启动时会启动3个classloader:
1.bootstrap classloader //加载JRE中的lib中的class文件
2.extension classloader //加载JRE中的lib/ext中的class文件
3.applicati classloader //加载classpath中的class文件

不同的classloader加载相同class文件所产生的class对象是不一样的。
双亲委派模型的工作过程：如果一个类加载器收到了类加载器的请求.它首先不会自己去尝试加载这个类.而是把这个请求委派给父加载器去完成.每个层次的类加载器都是如此.


JRE的核心库只能由bootstrap来加载，这是JVM种限制的，所以核心库是安全的。


classpy用于查看编译生成的class文件； jd-gui用于查看反编译生成的Java文件


classloader的作用是将字节码转化成class对象，可以定义自己的classloader，举例如下：
class MyClassLoader extends ClassLoader{
  public class<?> defineMyClass(xxx){
    return super.defineclass(xxx);
  }
}

对于boolean类型，JVM并没有提供专用的字节码指令，即编译器使用int类型来替代。

Java的class文件中只有类对象和接口对象： 接口对象在栈中保存了对象方法的函数指针。

字节码文件只区分类和接口，所以枚举和注解都是最终被解释成接口的，只是特殊接口而已。



Class.forName()静态方法的目的是为了动态加载类。
在加载完成后，一般还要调用Class下的newInstance()静态方法来实例化对象以便操作。
因此，单单使用Class.forName()是动态加载类是没有用的，其最终目的是为了实例化对象。
所以new操作符就相当于调用Class.forName().newInstance().


通过反射创建新的类示例，有两种方式：
Class.newInstance()
Constructor.newInstance()
以下对两种调用方式给以比较说明：
Class.newInstance() 只能够调用无参的构造函数，即默认的构造函数；
Constructor.newInstance() 可以根据传入的参数，调用任意构造构造函数。









































