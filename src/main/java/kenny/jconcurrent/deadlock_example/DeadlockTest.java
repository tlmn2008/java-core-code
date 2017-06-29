package kenny.jconcurrent.deadlock_example;

import java.util.concurrent.TimeUnit;


class Thread1 extends Thread {

    private Object object1;
    private Object object2;

    public Thread1(Object obj1, Object obj2){
        this.object1 = obj1;
        this.object2 = obj2;
    }

    @Override
    public void run() {
        System.out.println("Thread1 start");
        synchronized (object1){
            System.out.println("Thread1 get lock1");
            sleep();
            synchronized (object2){
                System.out.println("Thread1 get lock2");
                sleep();
            }
        }
        System.out.println("Thread1 stop");
    }

    private void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {

    private Object object1;
    private Object object2;

    public Thread2(Object obj1, Object obj2){
        this.object1 = obj1;
        this.object2 = obj2;
    }

    @Override
    public void run() {
        System.out.println("Thread2 start");
        synchronized (object2){
            System.out.println("Thread2 get lock2");
            sleep();
            synchronized (object1){
                System.out.println("Thread2 get lock1");
                sleep();
            }
        }
        System.out.println("Thread2 stop");
    }

    private void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DeadlockTest {

    private final static Object object1 = new Object();
    private final static Object object2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread1(object1, object2);
        Thread thread2 = new Thread2(object1, object2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
