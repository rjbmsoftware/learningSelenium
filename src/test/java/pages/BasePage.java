package pages;

public abstract class BasePage {
    private static final String URL = "http://localhost:4567/apps/pulp/";

    public static String getURL() {
        return URL;
    }
}
