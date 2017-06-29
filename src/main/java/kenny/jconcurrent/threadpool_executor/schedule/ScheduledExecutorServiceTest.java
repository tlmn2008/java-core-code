package kenny.jconcurrent.threadpool_executor.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// ScheduledThreadPoolExecutor
public class ScheduledExecutorServiceTest {

    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    public static void main(String[] args){

        OKTask okTask = new OKTask();
        ErrorTask errorTask = new ErrorTask();

        int delay = 1000;
        int period = 2000;

        scheduledExecutorService.scheduleAtFixedRate(okTask, delay, period, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(errorTask, delay*2, period, TimeUnit.MILLISECONDS);

    }

}
// 测试结果显示error task出问题时，不影响其他的task
// 通过对比TimerTest的结果，我理解是因为创建一个timer的时候只用了一个线程，
// 而这里是用了两个线程来做，所以相互不影响


//    延迟和周期任务推荐使用 ScheduledExecutorService