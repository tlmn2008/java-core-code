高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁；能 锁区块，就不要锁整个方法体；能用对象锁，就不要用类锁。

线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
说明：Executors 各个方法的弊端：
1）newFixedThreadPool 和 newSingleThreadExecutor:
主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM。
2）newCachedThreadPool 和 newScheduledThreadPool:
主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM

volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，
但是如果多写，同样无法解决线程安全问题。如果想取回 count++数据，使用如下类实现：
AtomicInteger count = new AtomicInteger(); count.addAndGet(1); count++操作如果是
JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观锁的重试次数）。

ThreadLocal无法解决共享对象的更新问题，ThreadLocal对象建议使用static修饰。
这个变量是针对一个线程内所有操作共有的，所以设置为静态变量，所有此类实例共享此静态
变量 ，也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只要是这
个线程内定义的)都可以操控这个变量。