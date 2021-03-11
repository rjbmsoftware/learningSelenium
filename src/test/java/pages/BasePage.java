package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private static final String URL = "http://localhost:4567/apps/pulp/";

    public WebDriver getWebDriver() {
        return webDriver;
    }

    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String getURL() {
        return URL;
    }
}
