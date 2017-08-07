package kenny.jconcurrent.concurrent_container.priorityblockingqueue;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class EventProcessTask implements Runnable {

    private PriorityBlockingQueue<Event> queue;

    public EventProcessTask(PriorityBlockingQueue<Event> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        Random random = new Random(47);
        int priority;
        for (int i=0; i<10; i++){
            priority = random.nextInt(10);
            Event event=new Event("name-"+i+"-priority-"+priority, priority);
            queue.add(event);
        }
    }
}
