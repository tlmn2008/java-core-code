package kenny.concurrent.concurrent_tools;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread{

    private volatile Semaphore semaphore;    // 信号量
    private int count;        // 申请信号量的大小

    public SemaphoreThread(Semaphore semaphore, int count) {
        this.semaphore = semaphore;
        this.count = count;
    }

    public void run() {
        try {
            // 从信号量中获取count个许可
            semaphore.acquire(count);

            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " acquire count="+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放给定数目的许可，将其返回到信号量。
            semaphore.release(count);
            System.out.println(Thread.currentThread().getName() + " release " + count + "");
        }
    }
}


class Test3 {
    public static void main(String[] args) throws IOException {
        Semaphore sem = new Semaphore(10);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //在线程池中执行任务
        threadPool.execute(new SemaphoreThread(sem, 5));
        threadPool.execute(new SemaphoreThread(sem, 4));
        threadPool.execute(new SemaphoreThread(sem, 7));
        //关闭池
        threadPool.shutdown();
    }
}

//pool-1-thread-1 acquire count=5
//pool-1-thread-2 acquire count=4
//pool-1-thread-1 release 5
//pool-1-thread-2 release 4
//pool-1-thread-3 acquire count=7
//pool-1-thread-3 release 7

// 信号量sem的许可总数是10个；共3个线程，分别需要获取的信号量许可数是5,4,7。
// 前面两个线程获取到信号量的许可后，sem中剩余的可用的许可数是1；
// 因此，最后一个线程必须等前两个线程释放了它们所持有的信号量许可之后，才能获取到7个信号量许可。