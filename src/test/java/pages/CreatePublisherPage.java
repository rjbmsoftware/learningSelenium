package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePublisherPage extends BasePage {

    public static String URL = BasePage.getURL() + "gui/create/publisher";
    @FindBy(id = "publishername")
    WebElement publisherNameInput;
    @FindBy(id = "create")
    WebElement createButton;
    @FindBy(id = "outputmessage")
    WebElement outputText;

    public CreatePublisherPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreatePublisherPage goToPage() {
        getWebDriver().get(URL);
        PageFactory.initElements(this.getWebDriver(), this);
        return this;
    }

    public CreatePublisherPage submitPublisherName(String publisher) {
        publisherNameInput.sendKeys(publisher);
        createButton.click();
        return this;
    }

    public boolean isAuthorAdded() {
        return outputText.getText().equals("Added Publisher");
    }
}
