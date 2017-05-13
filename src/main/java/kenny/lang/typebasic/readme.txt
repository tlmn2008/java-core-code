Boolean, char, byte, short, int, long, float, double, void.
Java中所有数值类型都有正负号。即为有符号类型。
Boolean类型所占存储空间的大小没有明确规定，仅定义为能够取字面值true和false。
上面的基本类型不在堆中而是在栈中创建，而要在堆中创建则需使用基本类型的包装器类。


Java中true,false,null不是关键字，它们只是显示的常量值。



除了= == !=能操作引用外，其它都只能操作基本类型。
特别的：+ +=能操作String类型。



Integer i=127, j=127;
i==j; //成立
Integer m=128, n=128;
m!=n; //成立
造成上述现象的原因是：
i=127的时候，会调用Integer.valueof()来创建实例，
其默认会对-128到127的数进行缓存， 所以创建了i对象后，再创建j对象时只是返回i的对象，所以两者相等。




short i = 5; 则+i的操作会将i提升为int类型。



移位操作符只可用来处理int整数。Char byte short的数值进行移位处理，则自动转换为int。










