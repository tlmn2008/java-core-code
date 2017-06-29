package kenny.algorithm.basictype;

public class FourBytesToLongTest {

    public static long fourBytesToLong(byte[] buf) {

        int firstByte  = (0x000000FF & ((int) buf[3]));
        int secondByte = (0x000000FF & ((int) buf[2]));
        int thirdByte  = (0x000000FF & ((int) buf[1]));
        int fourthByte = (0x000000FF & ((int) buf[0]));

        long unsignedLong = ((long) (firstByte | secondByte << 8 | thirdByte << 16 | fourthByte << 24)) & 0xFFFFFFFFL;

        return unsignedLong;
    }

    public static void main(String[] args) {
        System.out.println( "JAVA_HOME = " + System.getenv("JAVA_HOME"));
    }

}
