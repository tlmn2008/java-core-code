
Java虚拟机提供了一套用于调试（JVMDI）和监视（JVMPI）的接口，
Java5之后统一为JVMTI： http://docs.oracle.com/javase/1.5.0/docs/guide/jvmti/ 。

其中JVMDI分为三个部分：JVMDI，JDWP和JDI.
http://docs.oracle.com/javase/1.4.2/docs/guide/jpda/architecture.html


                 /    |--------------|
                /     |     VM       |
    debuggee - (      |--------------|  <------- JVMTI - Java VM Tool Interface
                \     |   back-end   |
                 \    |--------------|
                 /           |
 comm channel - (            |  <--------------- JDWP - Java Debug Wire Protocol
                 \           |
                 /    |--------------|
                /     | front-end    |
    debugger - (      |--------------|  <------- JDI - Java Debug Interface
                \     |      UI      |
                 \    |--------------|



 假设我们要开发一个调试工具，那我们只需要使用front-end的JDI的API就可以完成。
 JDI的API在com.sun.jdi包下，相当于是JDI的接口规范了。除了JDK自带的实现外，我在HotSpot的SA中也发现了一个实现。
 他俩的实现分别是在com.sun.tools.jdi包下和sun.jvm.hotspot.jdi包下。


PS:
http://docs.oracle.com/javase/8/docs/technotes/guides/jpda/
http://docs.oracle.com/javase/8/docs/technotes/guides/jpda/conninv.html

https://www.ibm.com/developerworks/cn/views/java/libraryview.jsp?search_by=%E6%B7%B1%E5%85%A5+Java+%E8%B0%83%E8%AF%95%E4%BD%93%E7%B3%BB