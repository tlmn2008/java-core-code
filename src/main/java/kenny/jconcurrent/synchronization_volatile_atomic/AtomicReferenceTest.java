package kenny.jconcurrent.synchronization_volatile_atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    private static volatile Integer num1 = 0;
    private static AtomicReference<Integer> ar = new AtomicReference<Integer>(num1);

    public static void test1() throws InterruptedException{
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        num1=num1++;
                    }
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(num1); //something like 196599
    }

    public static void test2() throws InterruptedException{
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++)
                        while(true){
                            Integer temp=ar.get();
                            if(ar.compareAndSet(temp, temp+1))break;
                        }
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(ar.get()); //10000000
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }
}

// 从上面可以看出 integer 不是原子操作，需要使用CAS来保证原子操作
