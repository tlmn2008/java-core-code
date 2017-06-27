package kenny.jconcurrent.cookbook.demo2;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The FileClock has been interrupted");
                break;
            }
        }
    }
}

class Test {
    public static void main(String[] args) throws IOException {
        FileClock clock=new FileClock();
        Thread thread=new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };

        thread.interrupt();
    }
}
