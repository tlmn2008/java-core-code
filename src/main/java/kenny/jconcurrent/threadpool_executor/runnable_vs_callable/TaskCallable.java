package kenny.jconcurrent.threadpool_executor.runnable_vs_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("thread name: "+Thread.currentThread().getName()+" start");

        //一个模拟耗时的操作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread name: "+Thread.currentThread().getName()+" stop");
        return "result string: "+Thread.currentThread().getName();
    }
}

class testCallable {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<>();

        //提交3个任务并执行
        for (int i = 0; i < 3; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskCallable());
            //将任务执行结果存储到List中
            futureList.add(future);
        }

        //提交完了任务就关闭掉服务，task继续执行
        executorService.shutdown();

        //遍历任务的结果
        System.out.println("begin to check!");
        for (Future<String> future : futureList) {
            try {
                // 下面的的get也可以用 V get(long timeout, TimeUnit unit) 来限时get
                System.out.println("result string: "+ future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}

//        thread name: pool-1-thread-1 start
//        begin to check!
//        thread name: pool-1-thread-2 start
//        thread name: pool-1-thread-3 start
//        thread name: pool-1-thread-1 stop
//        result string: result string: pool-1-thread-1
//        thread name: pool-1-thread-2 stop
//        result string: result string: pool-1-thread-2
//        thread name: pool-1-thread-3 stop
//        result string: result string: pool-1-thread-3
//
// 从上面的结果可以看出，future.get()应该是阻塞的