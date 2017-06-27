
list是有序集合，分ArrayList（数组实现）和LinkedList（链表实现） set和map是无序集合（唯一性）。
set分hashset, linkedhashset, treeset;
map分hashmap, linkedhashmap, treemap.
用到了哈希表和二叉树。
hashset底层是由hashmap实现的，所以可以看成是特殊的map。

泛型的类型参数一般采用T,E,K,V来表示。
Java中没有泛型数组。

泛型容器若类型参数是?则该泛型容器只能取元素不能添加元素。

要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator 方式，如果并发操作，需要对 Iterator 对象加锁。
Iterator<String> it = a.iterator();
while(it.hasNext()){
    String temp = it.next();
    if(删除元素的条件){
        it.remove();
    }
}

在 JDK7 版本以上，Comparator 要满足自反性，传递性，对称性，不然 Arrays.sort，
Collections.sort 会报 IllegalArgumentException 异常。
说明：
 1） 自反性：x，y 的比较结果和 y，x 的比较结果相反。
 2） 传递性：x>y,y>z,则 x>z。
 3） 对称性：x=y,则 x,z 比较结果和 y，z 比较结果相同。
反例：下例中没有处理相等的情况，实际使用中可能会出现异常：
new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId() > o2.getId() ? 1 : -1;
    }
}












