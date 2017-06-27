Boolean, char, byte, short, int, long, float, double, void.
Java中所有数值类型都有正负号。即为有符号类型。
Boolean类型所占存储空间的大小没有明确规定，仅定义为能够取字面值true和false。
上面的基本类型不在堆中而是在栈中创建，而要在堆中创建则需使用基本类型的包装器类。

java的8种基本数据类型和void类型都有自己的class类。 如void有Java.lang.Void类，
它是一个不能被实例化的占位符，保存了一个void的class对象的引用。

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


Java特殊关键字： strictfp: strict float point 精确浮点。

Java中分基本类型和引用类型：
引用类型又分为:类类型和接口类型。泛型类类型和泛型接口类型。
类类型数组和接口类型数组是存在的，泛型数组是没有的。

字节码文件只区分类和接口，所以枚举和注解都是最终被解释成接口的，只是特殊接口而已。








