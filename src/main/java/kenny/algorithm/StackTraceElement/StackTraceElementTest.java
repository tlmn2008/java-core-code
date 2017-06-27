package kenny.algorithm.StackTraceElement;

public class StackTraceElementTest {
    public static void main(String[] args) throws Exception {

        //这里如果是1则是定位上一级的位置， 以此类推
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[0];

        String clazzName = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();

        String location = "Error Location: Class_Name = ["+clazzName+"], Method_Name = ["+methodName+"], Line_Num = [" +lineNumber +"]";
        System.out.println(location);
        System.out.println(fileName);

    }
}
