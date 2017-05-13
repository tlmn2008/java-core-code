好的OOP语言都有一组容器，它们作为开发包的一部分，在C++中，容器即为STL。
Java在其标准类库中也包含有大量的容器。


当创建一个数组对象时，实际上是创建了一个引用数组，并且每个引用都自动初始化为null。
注意null是一个字面值。



泛型的类型参数一般采用T,E,K,V来表示。
Java中没有泛型数组。



C++中将模板用于类之后，针对不同的类会生成不同的模板类，是真泛型。
而Java中的类型参数信息会被擦除，所以是伪泛型。
C++中list和list是不同的类型， 而Java中list和list共享list类。



泛型容器若类型参数是?则该泛型容器只能取元素不能添加元素。



list是有序集合，分ArrayList（数组实现）和LinkedList（链表实现） set和map是无序集合（唯一性）。
set分hashset, linkedhashset, treeset;
map分hashmap, linkedhashmap, treemap.
用到了哈希表和二叉树。
hashset底层是由hashmap实现的，所以可以看成是特殊的map。



list和set的主要区别是set有比较器，可以防止元素相同。
对于set集合equals的操作笔记频繁，但是如果用key去比较，例如key为String，则可能需要比较一大串 字符串，而使用hashcode比较会效率更高。


泛型类和泛型方法

泛型的类型参数只能为引用类型，基础类型会被装箱。 泛型的类型参数可以被限制，如： 泛型的类型参数只能在非静态的变量和方法中使用。

ArrayList<Shape> shapes = new ArrayList<>();
ArrayList<Shape>即为参数化类型=泛型。


数组分基本类型数组和对象数组。举例如下：
Int[] a = int[10];
Integer[] a = new integer[10];
后者只是一个包含对象引用的数组。

















