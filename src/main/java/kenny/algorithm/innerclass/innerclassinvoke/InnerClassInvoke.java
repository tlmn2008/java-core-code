package kenny.algorithm.innerclass.innerclassinvoke;

class Outer {

    private int value;

    public class Inner {
        public void print() {
            log("AAA");
        }

        public class InnerInner{
            void print() {
                log1("BBB");
            }
        }
    }

    public void log(String str) {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        System.out.println("------INFO-----------------------------------------------------------------------------------------------");
        System.out.println("[-"+getClassName(className)+"-"+lineNumber+"-]: "+str);
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    public void log1(String str) {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        System.out.println("------ERROR----------------------------------------------------------------------------------------------");
        System.out.println("[-"+getClassName(className)+"-"+lineNumber+"-]: "+str);
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    private static String getClassName(String name) {
        String[] name_array1 = name.split("\\.");
        name = name_array1[name_array1.length-1];
        String[] name_array2 = name.split("\\$");
        if(name_array2.length>1){
            name = name_array2[0]+name_array2[1];
        } else {
            name = name_array2[0];
        }
        return name;
    }

}


public class InnerClassInvoke {

    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.Inner.InnerInner innerInner = inner.new InnerInner();


        inner.print();
        innerInner.print();
    }
}