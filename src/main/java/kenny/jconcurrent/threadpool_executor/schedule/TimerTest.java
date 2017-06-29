package kenny.jconcurrent.threadpool_executor.schedule;

import java.util.Timer;

public class TimerTest {

    public static Timer timer = new Timer();

    public static void main(String[] args){

        OKTask okTask = new OKTask();
        ErrorTask errorTask = new ErrorTask();

        int delay = 1000;
        int period = 2000;

        timer.scheduleAtFixedRate(okTask, delay, period);
        timer.scheduleAtFixedRate(errorTask, delay*2, period);

    }

}
