package kenny.algorithm.innerclass.separatecode;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printPersonInfo() {
        System.out.println("name = "+name+", age = "+age);
    }


    // 下面的代码会产生一个名为 Person$Test.class 的文件
    // 实现了测试代码在class级别的分离。
    // 跟JUNIT的区别是，此方法可以实现代码和测试代码在同一个源文件
    public static class Test {

        public static void main(String[] args) {
            Person outter  = new Person("kenny", 30);
            outter.printPersonInfo();
        }
    }
}
