
1.重点：同步 = 可见性 + 原子操作


2.
对于基本数据类型的加减操作，用voletile和cas来保证同步，
对对象来说，函数或代码块肯定是非原子操作，所以需要锁来保证同步。


3.
静态同步方法和非静态同步方法没有关系。
前者同步在Class对象，而后者同步在实例对象。
但是非静态同步方法也可以通过显示使用synchronized(xxx.class){}来同步在Class对象。

