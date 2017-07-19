package kenny.algorithm.basictype;


public class ByteTest {

    private static void changeValue(Boolean flag){
        flag = new Boolean(true);
    }

    private static void changeValue(Object flag){
        flag = new Object();
    }

    public static void main(String[] args){

        String arpStr = "BE";
//        byte arpValue = Byte.parseByte(arpStr, 16);

        Boolean flag = null;
        changeValue(flag);
        System.out.print(flag);

        Object object = null;
        changeValue(object);
        System.out.print(object);
    }
}
