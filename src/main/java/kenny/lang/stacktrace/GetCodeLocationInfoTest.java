package kenny.lang.stacktrace;

public class GetCodeLocationInfoTest {

    public static void main(String[] args) {

        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[0];

        String className = stackTraceElement.getClassName();
        String functName = stackTraceElement.getMethodName();

        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();

        String location1 = "Class_Name = ["+className+"], Method_Name = ["+functName+"]";
        String location2 = "File_Name = ["+fileName+"], Line_Num = [" +lineNumber+"]";


        System.out.println("current Location: " + location1);
        System.out.println("current Location: " + location2);

    }
}

// test result (7 is stackTraceElement obj create location)

// current Location: Class_Name = [kenny.lang.GetCodeLocationInfoTest], Method_Name = [main]
// current Location: File_Name = [GetCodeLocationInfoTest.java], Line_Num = [7]