package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAuthorPage extends BasePage {
    private final String URL = BasePage.getURL() + "gui/create/author";
    @FindBy(id = "authorname")
    private WebElement authorNameInput;
    @FindBy(id = "createauthorbutton")
    private WebElement createButton;
    @FindBy(id = "outputmessage")
    private WebElement submitMessage;

    public CreateAuthorPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(URL);
        PageFactory.initElements(webDriver, this);
    }

    public CreateAuthorPage createAuthor(String authorName) {
        authorNameInput.sendKeys(authorName);
        createButton.click();
        return this;
    }

    public String getSubmitMessage() {
        return submitMessage.getText();
    }
}
