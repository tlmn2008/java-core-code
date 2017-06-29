Java在JDK7之后加入了并行计算的框架Fork/Join，可以解决我们系统中大数据计算的性能问题。
Fork/Join采用的是分治法，Fork是将一个大任务拆分成若干个子任务，子任务分别去计算，
而Join是获取到子任务的计算结果，然后合并，这个是递归的过程。


Fork/Join框架的核心类是ForkJoinPool，它能够接收一个ForkJoinTask，并得到计算结果。
ForkJoinTask有两个子类，RecursiveTask（有返回值）和RecursiveAction（无返回结果）。


