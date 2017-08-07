package kenny.jvm.reflect.reflection_class_usage;

import sun.reflect.Reflection;

public class People {

    public void function1(){
        System.out.println(Reflection.getCallerClass(-1));
        System.out.println(Reflection.getCallerClass(0));
        System.out.println(Reflection.getCallerClass(1));
        System.out.println(Reflection.getCallerClass(2));
        System.out.println(Reflection.getCallerClass(3));
        System.out.println(Reflection.getCallerClass(4));
        System.out.println(Reflection.getCallerClass(5));
    }

    public void function2(){
        function1();
    }

}
