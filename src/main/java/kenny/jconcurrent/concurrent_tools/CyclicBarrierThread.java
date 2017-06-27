package kenny.jconcurrent.concurrent_tools;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

            // 将cb的参与者数量加1
            cyclicBarrier.await();

            // cb的参与者数量等于5时，才继续往后执行
            System.out.println(Thread.currentThread().getName() + " continued.");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Test2 {
    private static CyclicBarrier cyclicBarrier;
    public static void main(String[] args) throws IOException {
        // here has two ways to create cb
        // cb = new CyclicBarrier(5);
        cyclicBarrier = new CyclicBarrier(5, new Runnable () {
            public void run() {
                System.out.println("CyclicBarrier's parties is: "+ cyclicBarrier.getParties());
            }
        });

        // 新建5个任务
        for(int i=0; i<5; i++)
            new CyclicBarrierThread(cyclicBarrier).start();
    }
}

//Thread-1 wait for CyclicBarrier.
//Thread-2 wait for CyclicBarrier.
//Thread-3 wait for CyclicBarrier.
//Thread-4 wait for CyclicBarrier.
//Thread-0 wait for CyclicBarrier.
//CyclicBarrier's parties is: 5
//Thread-0 continued.
//Thread-4 continued.
//Thread-2 continued.
//Thread-3 continued.
//Thread-1 continued.