package kenny.jconcurrent.threadpool_executor.schedule;

import java.util.Date;
import java.util.TimerTask;

public class ErrorTask extends TimerTask {
    private int count = 3;
    @Override
    public void run() {
        count--;
        if(count > 0){
            System.out.println("ErrorTask is executed:" + new Date());
        } else {
            System.out.println("ErrorTask is executed with error:" + new Date());
            throw new RuntimeException("something wrong");
        }
        // 注意在run里面没有catch这个runtime 异常，直接抛出所以导致结束。
    }
}
