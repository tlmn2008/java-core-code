
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


给 JVM 设置-XX:+HeapDumpOnOutOfMemoryError 参数，让 JVM 碰到 OOM 场景时输出 dump 信息。






































