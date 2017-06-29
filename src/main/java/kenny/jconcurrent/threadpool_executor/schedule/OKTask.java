package kenny.jconcurrent.threadpool_executor.schedule;

import java.util.Date;
import java.util.TimerTask;

public class OKTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("OKTask is executed:" + new Date());
    }
}
