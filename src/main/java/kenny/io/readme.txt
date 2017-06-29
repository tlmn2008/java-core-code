计算机的IO接口： 键盘鼠标和显示器:标准IO（System.in, System.out） 硬盘：file 网络：socket。


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

































