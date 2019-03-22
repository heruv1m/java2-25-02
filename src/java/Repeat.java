import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Repeat {
    private static final Logger log = LoggerFactory.getLogger(Repeat.class);
    private static final String ii = "up";
    private String constructorInit;
    static String staticString;

    {
        staticString = "123";
    }

    public Repeat() {
        constructorInit = "init";
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        log.trace("debug example");
        log.debug("debug example");
        log.info("info::{} example name:{}", "something", "yayayay");
        log.warn("warn example");
        log.error("error example");

        System.out.println(ii);
        System.out.println(staticString);
        Repeat repeat = new Repeat();
        System.out.println(staticString);

    }
}
