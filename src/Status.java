public enum Status {
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
