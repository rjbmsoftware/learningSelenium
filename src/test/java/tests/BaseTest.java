package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BaseTest {
    @Test
    public void startBrowserTest() {
        String os = System.getProperty("os.name").startsWith("Mac") ? "mac" : "windows";
        String path;
        if (os.equals("mac")) {
            path = "src/test/resources/drivers/firefox/mac/geckodriver";
        } else {
            path = "src/test/resources/drivers/firefox/geckodriver.exe";
        }
        File file = new File(path);
        String absolutePathToDriver = file.getAbsolutePath();

        System.setProperty("webdriver.gecko.driver", absolutePathToDriver);
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.bbc.co.uk/");
        webDriver.close(); // 4 seconds run time :(
    }
}
