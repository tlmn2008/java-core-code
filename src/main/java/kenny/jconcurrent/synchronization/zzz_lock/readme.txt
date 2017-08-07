

两种基本的同步机制：
1.The synchronized keyword
2.The Lock interface and its implementation classes.

PS:
线程调用同步代码时，若没有获取到对象的锁，则处于blocked的状态。


在Java对象的函数声明中加入synchronized的关键字，则函数块进入之前和之后会分别调用lock()和unlock()。
从语法上讲，Synchronized总共有三种用法：
1）修饰静态方法,2）修饰普通方法,3）修饰代码块


关于lock：
ReentrantLock
ReentrantReadWriteLock.ReadLock
ReentrantReadWriteLock.WriteLock

JUC包中的锁包括：Lock接口，ReadWriteLock接口，LockSupport阻塞原语，Condition条件，
AbstractOwnableSynchronizer/AbstractQueuedSynchronizer/AbstractQueuedLongSynchronizer三个抽象类，
ReentrantLock独占锁，
ReentrantReadWriteLock读写锁。

