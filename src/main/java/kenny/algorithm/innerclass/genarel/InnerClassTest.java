package kenny.algorithm.innerclass.genarel;




class Outer {

    private int value;

    // 要注意的是，成员内部类不能含有static的变量和方法。
    // 因为成员内部类需要先创建了外部类，才能创建它自己的，
    // 了解这一点，就可以明白更多事情，在此省略更多的细节了。

    // 1 编译器自动为内部类添加一个成员变量， 这个成员变量的类型和外部类的类型相同， 这个成员变量就是指向外部类对象的引用；
    // 2 编译器自动为内部类的构造方法添加一个参数， 参数的类型是外部类的类型， 在构造方法内部使用这个参数为1中添加的成员变量赋值；
    // 3 在调用内部类的构造函数初始化内部类对象时， 会默认传入外部类的引用。

    // 普通内部类 （最常用）
    public class Inner {
        // static int a; //错误了，普通内部类不能有static数据和static属性，也不能包含嵌套类，但嵌套类可以。
        public void print(String str) {
            int value = Outer.this.value; // 内部类默认拥有对外部类对象的引用：外部类名.this
            System.out.println(str);
        }
    }

    // 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
    public Inner getInner() {
        return new Inner();
    }

}

public class InnerClassTest {

    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print("Outer.new");

        inner = outer.getInner();
        inner.print("Outer.get");

    }
}