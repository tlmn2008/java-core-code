package kenny.jconcurrent.concurrent_container.delayqueue;

import java.util.concurrent.*;

public class Test {

    public static void main(String args[]) throws InterruptedException {

        DelayQueue<Event> queue=new DelayQueue<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建两个线程去往queue里面添加event操作
        executorService.execute(new EventProcessTask(queue));
        executorService.execute(new EventProcessTask(queue));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            Event event = (Event) queue.poll();
            if(event == null){
                break;
            }
            System.out.println("getName = "+event.getName()+", getDelay = "+event.getDelay());
        }
        System.out.println("end");
    }
}

// 从结果可以看到优先级值小的会先取出来
