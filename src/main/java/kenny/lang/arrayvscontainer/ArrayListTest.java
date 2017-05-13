package kenny.lang.arrayvscontainer;

public class ArrayListTest {
}


// 当往arrayList中增加一个对象的时候，Java会去检查arrayList，以确保已存在的数组中有足够的容量来存储这个新的对象。
// 如果没有足够容量的话，那么就会新建一个长度更长的数组，旧的数组就会使用Arrays.copyOf方法被复制到新的数组中去，现有的数组引用指向了新的数组。


// 当传递ArrayList到某个方法中，或者某个方法返回ArrayList，什么时候要考虑安全隐患？如何修复安全违规这个问题呢？
