package kenny.jconcurrent.synchronization.zzz_lock.synchronized_demo;

class SaleTask implements Runnable{

    private int tickets = 20;
    private synchronized void sale(){  
        if(tickets > 0){
            System.out.println(Thread.currentThread().getName() + " sell:" + (tickets--));
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run(){
        while(tickets > 0){
            sale();
        }
        System.out.println(Thread.currentThread().getName() + ": run to the end!");
    }
}


public class SynchronizedTest {
    public static void main(String[] args) {

        SaleTask saleTask = new SaleTask();

        // 3个线程来卖票
        Thread thread1 = new Thread(saleTask);
        Thread thread2 = new Thread(saleTask);
        Thread thread3 = new Thread(saleTask);

        thread1.start();
        thread2.start();
        thread3.start();

        System.exit(0);
    }
}
