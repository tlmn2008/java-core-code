
1.volatile可见性原理：多线程环境中对象在不同的线程中都保存有副本，但是volatile对象没有，它会立即同步到内存。
PS:
volatile的两种用法：
1.保证被修饰的变量在一个线程中被修改后，另外一个使用该变量的线程会被通知到，而去堆中重新读取。
2.函数中该变量的赋值前和赋值后的代码要保证顺序。


2.关于原子性：
boolean     char        byte    short   int     long    float   double
Boolean     Character   Byte    Short   Integer Long    Float   Double

对于除了long和double的基本类型，本身已经是原子操作，所以再加上volite即可保证同步。
PS:
在32位操作系统中，64位的long 和 double 变量由于会被JVM当作两个分离的32位来进行操作，所以不具有原子性，其他的都具有原子性。
而使用AtomicLong能让long的操作保持原子型。因为代码里面做了封装。
因为流行的微处理器还是32bit居多，因此64bit的变量需要拆分成两次，但如果是64bit处理器就能满足64bit变量的原子性操作了。

AtomicBoolean
AtomicInteger
AtomicLong
AtomicReference *
上面的几个类利用了硬件提供的CAS机制来实现同步。
PS:
JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观锁的重试次数）。

例如：AutomicReference主要是用了volatile和CAS来分别保证可见性和原子性，即同步。


3.example:
首先看两段代码，一段是Integer的，一段是AtomicInteger的，为以下：

public class Sample1 {
    private static Integer count = 0;
    synchronized public static void increment() {
        count++;
    }
}

public class Sample2 {
    private static AtomicInteger count = new AtomicInteger(0);
    public static void increment() {
        count.getAndIncrement();
    }
}




