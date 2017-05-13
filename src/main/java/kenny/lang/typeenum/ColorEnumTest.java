package kenny.lang.typeenum;

import java.util.HashMap;
import java.util.Map;

public class ColorEnumTest {

    public static void main(String[] args) {

        // below shows values() usage
        ColorEnum[] allCauses = ColorEnum.values();
        for(ColorEnum cause : allCauses){
            System.out.println(cause.toString());
        }

        // use name str to get enum
        ColorEnum color = ColorEnum.valueOf("COLOR_R");
    }
}

enum ColorEnum {

    COLOR_R(0xFF0000, "red"),
    COLOR_G(0x00FF00, "green"),
    COLOR_B(0x0000FF, "blue"),
    // cause unknow
    COLOR_UNKNOWN(0xFF, "unknown");

    private static final Map<Integer, ColorEnum> COLOR_CODE_MAP = new HashMap<Integer, ColorEnum>();
    static {
        for (ColorEnum color : values()) {
            COLOR_CODE_MAP.put(color.code, color);
        }
    }

    private final int code;
    private final String description;

    private ColorEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    public static ColorEnum lookup(int code) {
        ColorEnum cause = COLOR_CODE_MAP.get(code);
        if (cause == null) {
            cause = COLOR_UNKNOWN;
        }
        return cause;
    }

}
