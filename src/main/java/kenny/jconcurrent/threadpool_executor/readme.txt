使用线程池的好处是减少在创建和销毁线程上所花的时间以及系统资源的开销，解决资
源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者
“过度切换”的问题。


线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。


PS：Executors 各个方法的弊端：
1）newFixedThreadPool 和 newSingleThreadExecutor:
主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至 OOM。
2）newCachedThreadPool 和 newScheduledThreadPool:
主要问题是线程数最大数是 Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至 OOM
