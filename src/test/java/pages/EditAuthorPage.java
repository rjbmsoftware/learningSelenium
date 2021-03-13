package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAuthorPage extends BasePage {
    public static final String URL = BasePage.getURL() + "gui/amend/author?author=";
    @FindBy(id = "authorname")
    WebElement authorNameInput;
    @FindBy(css = "input[value='Update']")
    WebElement updateButton;
    private final int id;

    public EditAuthorPage(WebDriver webDriver, int id) {
        super(webDriver);
        this.id = id;
    }

    public EditAuthorPage updateAuthorName(String authorName) {
        authorNameInput.clear();
        authorNameInput.sendKeys(authorName);
        updateButton.click();
        return this;
    }

    public String getUrl() {
        return URL + this.id;
    }

}
