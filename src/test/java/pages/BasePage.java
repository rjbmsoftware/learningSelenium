package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    private static final String URL = "http://localhost:4567/apps/pulp/";
    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String getURL() {
        return URL;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
