package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuthorListPage extends BasePage {
    public static String getURL() {
        return URL;
    }

    private static final String URL = "http://localhost:4567/apps/pulp/gui/reports/authors/list/navigation";

    @FindBy(css = "#Authors-list > li > :first-child > a")
    private List<WebElement> authors;

    public AuthorListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AuthorListPage clickAuthorLink(String name) {
        for (WebElement author : authors) {
            if (author.getText().equals(name)) {
                author.click();
                break;
            }
        }
        return this;
    }
}
