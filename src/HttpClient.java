public class HttpClient {
    private Status status;

    public static void main(String[] args) {

        String status = "RUN";
        Status st = Status.valueOfSafe(status);
        System.out.println(st.getCode());
    }

    public void makeSomething() {
        new Request().reqId = "sdfg";
    }

    static class Request {
        private String reqId;

        public void print() {
            // System.out.println(status);
        }
    }

    enum Status {
        RUN(1),
        JUMP(2),
        SWIM(3);
        private int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Status valueOfSafe(String str) {
            try {
                return valueOf(str);
            } catch (IllegalArgumentException ex) {
                //ignore
                return null;
            }
        }
    }

}