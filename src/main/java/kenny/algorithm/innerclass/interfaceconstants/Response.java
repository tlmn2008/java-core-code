package kenny.algorithm.innerclass.interfaceconstants;

public interface Response {

    public static final class StatusCode {
        public static final int CONTINUE = 100;
        public static final int OK = 200;
        public static final int CREATED = 201;
        public static final int MULTIPLE_CHOICES = 300;
        public static final int BAD_REQUEST = 400;
        public static final int NOT_FOUND = 404;
        public static final int INTERNAL_SERVER_ERROR = 500;
        public static final int NOT_IMPLEMENTED = 501;
        public static final int BAD_GATEWAY = 502;
        private StatusCode() {
        }
    }

    int getStatusCode();

}


//上面的常量最好放在一个内部嵌套类里面