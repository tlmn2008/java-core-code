package kenny.jvm.reflect.reflect_static_private_field;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {

        try {
            Field field =People.class.getDeclaredField("name");
            field.setAccessible(true);

            field.set(People.class, "kenny");

            // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
            String name = (String) field.get(null);

            System.out.println(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

