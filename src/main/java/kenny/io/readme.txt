计算机的IO接口： 键盘鼠标和显示器:标准IO（System.in, System.out） 硬盘：file 网络：socket。

java.io和java.nio分别对应stream和channel的概念。

普通壶---立等； //同步阻塞 //普通IO，效率低
普通壶---不立等；//同步非阻塞 //实用（netty）
响水壶---立等； //异步阻塞 //无用
响水壶---不立等。 //异步非阻塞 //最有用，效率高

同步和异步的区别：主动查询，被动通知；
阻塞和非阻塞的区别：不立即返回和立即返回。


IO模型有5种： 1.blocking； 2.non-blocking; 3.i/o multiplexing; 4.signal-driven i/o; 5.AIO.
前面4种都是同步的。
Java i/o属于第1种模型；
Java nio种默认为blocking的为第1种模型，也可以配置成non-blocking的， 即第2种模型，若使用selector则实现了第3种模型，底层使用poll和epoll来实现。
第4种nio中没有实现，而AIO是有实现的。？？？


对于网络IO，一般都是非阻塞的，netty是提供了比Java nio更好的接口和其他功能。
netty本质就是同步非阻塞IO，而最有用的AIO则没有实现。Linux的epoll貌似是实现了AIO。待查证。


Java.nio中包含3中channel：pipe, file 和socket。 Java.nio中的selector对应于Linux中的select。
三种IO都可以获得InputStream接口： System.in本身就是inputstream； FileInputStream(File file); Socket.getInputStream()。
另外inputstream还存在于内存操作中，如： pipedInputStream，ByteArrayInputStream和StringBufferInputStream。


基于Inputstream字节流实现字符流的处理：reader


java.nio中除了引入了FileChannel外，还引入了mappedByteBuffer.因为现代操作系统都支持 虚拟内存映射，
这样可以把内核虚拟内存和用户虚拟内存映射到同一物理地址，减少数据的拷贝。

nio的三种框架：mina（Apache）, netty(Jboss), grizzly(Oracle Sun)。

Java的流对象在方法区。

NIO读写数据：
从ByteBuffer去读数据时，position的位置为最大可读个数，所以读之前需要flip一下；
往ByteBuffer中写数据时，position表示当前写的位置，所以写之前需要clear一下。
PS: buffer的rewind()用于将position设为0； mark()和reset()：前者将当前position位置保存到mark中，reset的时候便回到mark的位置。

RMI是建立在网络IO之上的通信协议，和http一样是应用协议。
首先需要理解2个概念，skeleton和stub: skeleton和stub都是在服务端产生的，而生存的stub（class对象）被传递到客户端，
通过skeleton和stub间的socket 通信完成方法参数和结果的传递。

































