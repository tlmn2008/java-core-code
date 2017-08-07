

1.queue相关
ArrayBlockingQueue     阻塞队列，数组实现
LinkedBlockingQueue    阻塞队列，链表实现
PriorityBlockingQueue  阻塞队列，优先级
DelayQueue             阻塞队列，延迟
SynchronousQueue       阻塞队列 同步
ConcurrentLinkedQueue  非阻塞队列，链表实现
LinkedTransferQueue    转移队列，链表实现


2.dequeue相关
LinkedBlockingDeque          阻塞双端队列，链表实现
ConcurrentLinkedDeque.class，非阻塞双端队列，链表实现


3.map相关
ConcurrentHashMap
ConcurrentNavigableMap
ConcurrentSkipListMap

4.其它
CopyOnWriteArrayList
CopyOnWriteArraySet
CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。


PS:
接口Queue有如下几个方法：
public interface Queue<E> extends Collection<E> {

  // add方法和offer方法的区别在于超出容量限制时前者抛出异常，后者返回false
  boolean add(E e);
  boolean offer(E e);

  // remove方法和poll方法都从队列中拿掉元素并返回，但是他们的区别在于空队列下操作前者抛出异常，而后者返回null
  E remove();
  E poll();

  // element方法和peek方法都返回队列顶端的元素，但是不把元素从队列中删掉，区别在于前者在空队列的时候抛出异常，后者返回null
  E element();
  E peek();
}