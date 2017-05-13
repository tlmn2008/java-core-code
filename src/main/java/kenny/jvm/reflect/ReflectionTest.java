package kenny.jvm.reflect;

import java.lang.reflect.*;

class People {

    private String username;
    private String password;
    private int age;
    private int[] id;

    public People(){
    }

    public People(String username, String password, int age, int[] id){
        this.username = username;
        this.password = password;
        this.age = age;
        this.id = id;
    }

    public void doValidation(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }
}


public class ReflectionTest {

    public static void testGetBasicInfo() throws ClassNotFoundException {


        Class peopleClass = People.class;
        Class people = Class.forName("kenny.jvm.reflect.People");
        //获取指定的包名
        String package01 = peopleClass.getPackage().getName();
        String package02 = people.getPackage().getName();

        System.out.println("package name = " + package01);
        System.out.println("package name = " + package02);

        //获取类的修饰符
        String modifierName = Modifier.toString(peopleClass.getModifiers());
        System.out.println("class' modifier = " + modifierName);

        //获取指定类的父类
        String superClassName = peopleClass.getSuperclass().getName();
        System.out.println("class' super class name = " + superClassName);

        //获取实现的接口
        Class[] interfaces = peopleClass.getInterfaces();
        for (Class t : interfaces) {
            System.out.println("class' interfaces = " + t.getName());
        }

        //获取指定类的成员变量
        Field[] fields = peopleClass.getDeclaredFields();
        for (Field field : fields) {

            String modifier = Modifier.toString(field.getModifiers()); //获取访问修饰符
            Class type = field.getType(); //获取字段的数据类型所对应的Class对象
            String name = field.getName(); //获取字段名

            if (type.isArray()) { //如果是数组类型则需要特别处理
                //getComponentType()的使用: 如果class对象是一个数组，则返回这个数组元素的class对象，否则返回null
                String arrType = type.getComponentType().getName() + "[]";
                System.out.println("" + modifier + " " + arrType + " " + name + ";");
            } else {
                System.out.println("" + modifier + " " + type + " " + name + ";");
            }
        }

        //获取类的构造方法
        Constructor[] constructors = peopleClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers()); //获取访问修饰符
            String name = constructor.getName(); //构造方法名
            System.out.print("[" + modifier +"]" + name + "(");

            Class[] paramTypes = constructor.getParameterTypes(); //获取构造方法中的参数
            for (int i = 0; i < paramTypes.length; i++) {

                if (i > 0) {
                    System.out.print(",");
                }

                if (paramTypes[i].isArray()) {
                    //getComponentType()的使用: 如果class对象是一个数组，则返回这个数组元素的class对象，否则返回null
                    System.out.print(paramTypes[i].getComponentType().getName()+"[]");
                } else {
                    System.out.print(paramTypes[i].getName());
                }
            }
            System.out.println(");");
        }
    }


    public static void testInvokeMethod() throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException {
        // 反射调用方法，可以通过Method类的invoke方法实现动态方法的调用
        // public Object invoke(Object obj, Object... args)
        // 第一个参数代表对象
        // 第二个参数代表执行方法上的参数
        // 若反射要调用类的某个私有方法，可以在这个私有方法对应的Method对象上先调用setAccessible(true)

        Class peopleClass = People.class;

        // *******************
        // 注意这里用到了两种方法来创建people的实例
        // People people = (People) peopleClass.newInstance(); //利用反射来创建类的对象
        Constructor Constructor = peopleClass.getDeclaredConstructor(new Class[]{String.class, String.class, int.class, int[].class});
        People people = (People) Constructor.newInstance("default", "default", 0, new int[1]); //利用反射来创建类的对象
        // *******************

        // 用户名和密码设置前
        System.out.println("username == " + people.getUsername());
        System.out.println("password == " + people.getPassword());

        // 设置用户名
        Method method = peopleClass.getDeclaredMethod("setUsername", String.class);
        method.invoke(people, "kenny");
        System.out.println("username == " + people.getUsername());
        // 设置密码
        method = peopleClass.getDeclaredMethod("setPassword", String.class);
        method.invoke(people, "kmh,.");
        System.out.println("password == " + people.getPassword());
    }

    public static void main(String[] args) throws ClassNotFoundException, SecurityException, IllegalArgumentException, InstantiationException,
    IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        System.out.println("testGetBasicInfo() =======================================");
        testGetBasicInfo();
        System.out.println("testInvokeMethod() =======================================");
        testInvokeMethod();
    }

}

//
// People people = (People) peopleClass.newInstance(); //利用反射来创建类的对象
// 在测试的过程中，如果不给People提供无参数的构造函数，那么上面这句话执行会失败。
// 原因如下：
// Class.newInstance() 只能够调用无参的构造函数，即默认的构造函数；
// Constructor.newInstance() 可以根据传入的参数，调用任意构造构造函数。
