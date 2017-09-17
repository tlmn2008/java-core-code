package kenny.jvm.load_class.getClassName;

public class Test {

    public static void main(String[] args) {

        BBB bbb = new BBB();
        bbb.print();
    }

    public static String getClassNameOfObject(Object object) {

        String name = object.getClass().getName();
        String[] name_array = name.split("\\.");
        int postion = name_array.length;
        return name_array[name_array.length-1];

    }
}
