package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthorDetailsPage extends BasePage {
    @FindBy(css = "[name='author-id']")
    WebElement authorId;

    @FindBy(css = "[name='author-name']")
    WebElement authorName;

    public AuthorDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getAuthorID() {
        String authorIdText = this.authorId.getText();
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(authorIdText);
        return matcher.find() ? Integer.parseInt(matcher.group()) : -1;
    }

    public String getAuthorName() {
        String text = authorName.getText();
        Pattern pattern = Pattern.compile("\\w+ \\w+$");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group() : "";
    }
}
