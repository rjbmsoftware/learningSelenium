package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BaseTest {
    @Test
    public void startBrowserTest() {
        String path = "src/test/resources/drivers/firefox/geckodriver.exe";
        File file = new File(path);
        String absolutePathToDriver = file.getAbsolutePath();

        System.setProperty("webdriver.gecko.driver", absolutePathToDriver);
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.bbc.co.uk/");
        webDriver.close(); // 4 seconds run time :(
    }
}
