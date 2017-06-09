package kenny.lang.timer;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    static class PrintTask extends java.util.TimerTask{
        public void run(){
            System.out.println( new Date() + "********");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Timer timer = new Timer();
        //在1秒后执行此任务,每次间隔2秒执行一次,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
        timer.schedule(new PrintTask(), 1000, 2000);
    }
}

// public abstract class TimerTask implements Runnable {
// 从上面这句话可以看到TimerTask也是一个Runnable的对象