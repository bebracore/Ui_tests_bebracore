package config;

public class TestConfig {

    public static final String BASE_URL =
            System.getProperty("baseUrl", "https://bebra.testrail.io/");

    public static final String BROWSER =
            System.getProperty("browser", "chrome");

    public static final String BROWSER_SIZE =
            System.getProperty("browserSize", "1920x1080");
}