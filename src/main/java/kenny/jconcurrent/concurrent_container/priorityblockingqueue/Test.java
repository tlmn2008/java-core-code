package kenny.jconcurrent.concurrent_container.priorityblockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String args[]) throws InterruptedException {

        PriorityBlockingQueue queue = new PriorityBlockingQueue();

        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建两个线程去往queue里面添加event操作
        executorService.execute(new EventProcessTask(queue));
        executorService.execute(new EventProcessTask(queue));

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            Event event = (Event) queue.poll();
            if(event == null){
                break;
            }
            System.out.println(event.getName());
        }
        System.out.println("end");
    }
}

// 从结果可以看到优先级值小的会先取出来
