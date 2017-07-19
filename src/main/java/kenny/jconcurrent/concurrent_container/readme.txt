

String的操作其实也是 CopyOnWrite 的。

Copy-On-Write简称COW，是一种用于程序设计中的优化策略。
其基本思路是，从一开始大家都在共享同一个内容，当某个人想要修改这个内容的时候，才会真正把内容Copy出去形成一个新的内容然后再改，这是一种延时懒惰策略。
Java并发包里提供了两个使用CopyOnWrite机制实现的并发容器,
它们是CopyOnWriteArrayList和CopyOnWriteArraySet。
CopyOnWrite容器非常有用，可以在非常多的并发场景中使用到。


CopyOnWrite的缺点
即内存占用问题和数据一致性问题。所以在开发的时候需要注意一下。
如果写操作比较频繁，则内存占用问题比较严重。
CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。