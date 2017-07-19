package kenny.jconcurrent.threadlocal_variable.demo;

public class BusinessService {

    public void businessMethod() {
        Context context = MyThreadLocal.get();
        System.out.println("service["+Thread.currentThread().getName()+"]:"+context.getTransactionId());
    }
}
