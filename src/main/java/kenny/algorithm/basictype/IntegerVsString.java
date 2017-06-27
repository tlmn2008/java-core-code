package kenny.algorithm.basictype;

public interface IntegerVsString {
    // 1. Integer
    // Integer(int value)
    // Integer(String s)
    String toString(int i, int radix);
    String toHexString(int i);
    int parseInt(String s, int radix);
    int parseInt(String s);
    Integer valueOf(String s, int radix);
    Integer valueOf(String s);
    byte byteValue();
    int intValue();
    float floatValue();
    int highestOneBit(int i);
    int lowestOneBit(int i);
    int numberOfLeadingZeros(int i);
    int numberOfTrailingZeros(int i);
    int rotateLeft(int i, int distance);
    int rotateRight(int i, int distance);

    // 2. String
    // String(StringBuffer buffer)
    // String(StringBuilder builder)
    String format(String format, Object... args);
    int codePointAt(int index);
    boolean equalsIgnoreCase(String anotherString);
    boolean startsWith(String prefix);
    boolean endsWith(String suffix);
    int indexOf(String str);
    int lastIndexOf(String str);
    boolean matches(String regex);
    String replaceFirst(String regex, String replacement);
    String[] split(String regex, int limit);
    String toLowerCase();
    String toUpperCase();
    String valueOf(int i);
    String valueOf(float f);
    char[] toCharArray();
    String trim();

}
