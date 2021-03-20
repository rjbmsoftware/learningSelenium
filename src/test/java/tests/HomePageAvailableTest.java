package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageAvailableTest extends BaseTest {
    @Test
    public void homePageTest() {
        driver.get(HomePage.getURL());
        HomePage homePage = new HomePage(this.driver);
        PageFactory.initElements(this.driver, homePage);

        String expectedHeaderText = "Pulp App Main Menu";
        String actualHeaderText = homePage.getHeadingText();

        assertEquals(actualHeaderText, expectedHeaderText);
    }
}
