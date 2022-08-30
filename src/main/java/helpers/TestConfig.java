package helpers;

public class TestConfig {
    public static String browser = "chrome";
    public static String headless = "0";
    public static final String PATH_TO_ERRORS_LOG = "report/errors.log";
    public static String dimension = "1920x1080";

    public static void initConfig() {
        browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "0" : System.getProperty("headless");

        dimension = System.getProperty("dimension");
        if(dimension == null) {
            dimension = "1920x1080";
        }
    }

    public static boolean isHeadless() {
        return headless.contains("1");
    }
}
