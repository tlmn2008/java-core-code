
普通壶---立等； //同步阻塞 //普通IO，效率低
普通壶---不立等；//同步非阻塞 //实用（netty）
响水壶---立等； //异步阻塞 //无用
响水壶---不立等。 //异步非阻塞 //最有用，效率高

同步和异步的区别：主动查询，被动通知；
阻塞和非阻塞的区别：不立即返回和立即返回。


1.同步阻塞 :blocking
2.同步非阻塞（间断查询状态）:non-blocking
3.I/O复用（select polling）(返回可读条件) :i/o multiplexing
4.信号驱动IO（SIGIO信号通知）:signal-driven i/o
5.AIO（数据完成从内核拷贝到进程时通知进程）AIO

PS:
前面4种都是同步的。
Java i/o属于第1种模型；
Java nio种默认为blocking的为第1种模型，也可以配置成non-blocking的， 即第2种模型，若使用selector则实现了第3种模型，底层使用poll和epoll来实现。
AIO和前面几种有显著的不同，不过很少有系统实现这种方式。


PS:
两种IO多路复用模式：Reactor和Proactor，并对它们进行了比较。

































