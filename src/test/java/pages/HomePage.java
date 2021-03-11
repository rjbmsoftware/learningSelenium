package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(tagName = "h1")
    private WebElement topHeading;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHeadingText() {
        return topHeading.getText();
    }
}
