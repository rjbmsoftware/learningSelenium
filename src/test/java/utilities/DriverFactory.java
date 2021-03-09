package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver create() {
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
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }
}
