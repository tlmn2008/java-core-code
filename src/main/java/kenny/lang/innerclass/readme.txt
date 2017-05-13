注意：内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两类。
对于一个名为outer的外部类和其内部定义的名为inner的内部类。
编译完成后出现outer.class和outer$inner.class两类。
其中在outer$inner.class中会有一个外部类的引用，即this$0
普通内部类最常用。


匿名内部类举例：
interface Shape{
void paint();
}
Shape shape = new Shape(){
  public void paint(){
  xxx
  }
};
匿名类是一种特殊的内部类。其对于的class文件名为:OutterClass$1 (用数字命名内部类)，
匿名类由接口来引用。



外部类的里面创建内部类使用：this.new 外部类的外面创建内部类使用：outer.new (outer是实例对象)

内部类访问外部类的变量：Outer.this.member