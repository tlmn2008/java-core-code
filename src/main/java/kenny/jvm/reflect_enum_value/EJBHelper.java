package kenny.jvm.reflect_enum_value;

import java.lang.reflect.Field;

public enum EJBHelper {

    EMBMS_DB_MANAGER("embms db manager"),
    BCC_SCHEDULER("bcc scheduler"),
    BMSC_EVENT_REPORTER("event reporter");

    private String jndi;
    private Object instance;

    EJBHelper(String jndi) {
        this.jndi = jndi;
        this.instance = lookup(jndi);
    }

    public static Object lookup(String jndiName) {
        // 省略
        return null;
    }
}

class test{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = EJBHelper.EMBMS_DB_MANAGER.getClass().getDeclaredField("instance");
        field.setAccessible(true);
        field.set(EJBHelper.EMBMS_DB_MANAGER, new Object());
    }
}
