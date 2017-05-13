Java中线程的创建有两种方式
1. 通过实现Runnable接口(java.lang)，实例化Thread类；
2. 通过继承Thread类，重写Thread的run()方法，将线程运行的逻辑放在其中。

关于选择继承Thread还是实现Runnable接口？
其实Thread也是实现Runnable接口的。如果一个类继承Thread，则不适合资源共享。
但是如果实现了Runable接口的话，则很容易的实现资源共享。

重要补充：
前面两种创建线程的方式的缺陷就是：在执行完任务之后无法获取执行结果。
如果需要获取执行结果，就必须通过共享变量或者使用线程通信的方式来达到效果，这样使用起来就比较麻烦。
自从Java 1.5开始，就提供了Callable和Future，通过它们可以在任务执行完毕之后得到任务执行结果。
Callable位于java.util.concurrent包下，它是一个接口，只声明了一个方法，叫做call()；
Future类位于java.util.concurrent包下，它是一个接口，Future接口中声明了5个方法。





