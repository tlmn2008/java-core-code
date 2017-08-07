package kenny.jconcurrent.concurrent_container.delayqueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

public class EventProcessTask implements Runnable {

    private DelayQueue<Event> queue;

    public EventProcessTask(DelayQueue<Event> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        Date now;
        for (int i=0; i<10; i++){
            now = new Date();
            Event event=new Event("name-"+i+"-createDate-"+now, now);
            queue.add(event);
        }
    }
}
