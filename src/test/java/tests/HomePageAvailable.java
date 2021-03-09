package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.HomePage;

public class HomePageAvailable extends BaseTest {
    @Test
    public void homePageTest() {
        driver.get(new HomePage().URL);
        driver.findElement(By.className("main_menu"));
    }
}
