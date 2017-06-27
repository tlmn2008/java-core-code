package kenny.algorithm.date_and_time.timer;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


class PrintTask implements Runnable {

    private int taskNum;

    public PrintTask(int taskNum){
        this.taskNum = taskNum;
    }

    public void run() {
        System.out.println("task ["+taskNum+"] the time:" + new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ScheduledExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(2);
        scheduExec.schedule(new PrintTask(1), 1000, TimeUnit.MILLISECONDS);
        scheduExec.schedule(new PrintTask(2), 2000, TimeUnit.MILLISECONDS);
        scheduExec.scheduleAtFixedRate(new PrintTask(3), 1000, 1000, TimeUnit.MILLISECONDS);


    }

}
