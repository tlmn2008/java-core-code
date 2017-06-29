package kenny.jconcurrent.threadpool_executor.runnable_vs_callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("thread name: "+Thread.currentThread().getName()+" start");

        //一个模拟耗时的操作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread name: "+Thread.currentThread().getName()+" stop");
    }
}

class testRunnable {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            executorService.execute(new TaskRunnable());
        }
        executorService.shutdown();

    }
}
