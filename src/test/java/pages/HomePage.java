package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private final WebDriver webDriver;

    @FindBy(tagName = "h1")
    private WebElement topHeading;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getHeadingText() {
        return topHeading.getText();
    }
}
