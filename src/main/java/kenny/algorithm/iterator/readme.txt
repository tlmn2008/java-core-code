
使用ArrayList.iterator()方法返回的是Itr()内部类，所以现在我们需要关心的就是Itr()内部类的实现：
在Itr内部定义了三个int型的变量：cursor、lastRet、expectedModCount。
其中cursor表示下一个元素的索引位置，lastRet表示上一个元素的索引位置


在Itr内部类的next()方法中，调用了checkForComodification()，
其主要用来判断集合的修改次数是否合法，即用来判断遍历过程中集合是否被修改过。
modCount用于记录ArrayList集合的修改次数，初始化为0，，每当集合被修改一次（结构上面的修改，内部update不算），
如add、remove等方法，modCount + 1，所以如果modCount不变，则表示集合内容没有被修改。
该机制主要是用于实现ArrayList集合的快速失败机制，在Java的集合中，较大一部分集合是存在快速失败机制的。
要保证在遍历过程中不出错误，我们就应该保证在遍历过程中不会对集合产生结构上的修改（当然remove方法除外）。