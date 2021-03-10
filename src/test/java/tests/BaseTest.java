package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverFactory.create();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
