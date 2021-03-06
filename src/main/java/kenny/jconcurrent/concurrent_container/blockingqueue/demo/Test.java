package kenny.jconcurrent.concurrent_container.blockingqueue.demo;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {

        int capacity = 5;
        ArrayBlockingQueue<Bread> queue = new ArrayBlockingQueue<>(capacity);

        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();

        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
