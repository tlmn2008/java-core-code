package kenny.jconcurrent.threadlocal_variable.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest implements Runnable{

    private static AtomicInteger ai = new AtomicInteger(0);

    @Override
    public void run() {
        Context context = new Context();
        context.setTransactionId(getName());
        MyThreadLocal.set(context);
        System.out.println("request["+Thread.currentThread().getName()+"]:"+context.getTransactionId());
        new BusinessService().businessMethod();
        MyThreadLocal.unset();
    }

    private String getName() {
        return ai.getAndIncrement()+"";
    }

    public static void main(String[] args) {
        ThreadLocalTest tld  = new ThreadLocalTest();
        new Thread(tld).start();
        new Thread(tld).start();
    }

}
