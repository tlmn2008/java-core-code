package kenny.algorithm.basictype;


import java.util.HashMap;
import java.util.Map;

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

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<3; i++){
            builder.append("aaa,");
        }
        String temp = builder.toString();
        temp = temp.substring(0, temp.length()-1);
        System.out.print(temp);

        Map<String, Boolean> stepMap = new HashMap<>();
        stepMap.put("a", false);
        stepMap.put("b", false);

        stepMap.put("a", true);

        System.out.println(stepMap.get("a"));


    }
}
