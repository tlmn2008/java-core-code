package kenny.concurrent.concurrent_tools;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread extends Thread{

    private CountDownLatch countDownLatch;

    public CountDownLatchThread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
            // 将CountDownLatch的数值减1
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test1 {
    public static void main(String[] args) throws IOException {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(5);

            // 新建5个任务
            for(int i=0; i<5; i++)
                new CountDownLatchThread(countDownLatch).start();

            // "主线程"等待线程池中5个任务的完成
            System.out.println("main await begin.");
            countDownLatch.await();
            System.out.println("main await finished.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//    main await begin.
//    Thread-0 sleep 1000ms.
//    Thread-2 sleep 1000ms.
//    Thread-1 sleep 1000ms.
//    Thread-4 sleep 1000ms.
//    Thread-3 sleep 1000ms.
//    main await finished.