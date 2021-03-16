package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

public class SearchPage extends BasePage {
    private static final String URL = BasePage.getURL() + "gui/reports/books/search";
    @FindBy(css = "div[name='output'] a")
    List<WebElement> searchHistory;
    @FindBy(id = "searchterminput")
    private WebElement searchInput;
    @FindBy(id = "searchbutton")
    private WebElement searchSubmitButton;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static String getURL() {
        return URL;
    }

    public SearchPage searchForText(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchSubmitButton.click();
        return this;
    }

    public List<String> getSearchHistory() {
        List<String> output = new LinkedList<>();
        boolean afterFullSearch = false;
        for (WebElement historyLink : searchHistory) {
            if (afterFullSearch) {
                output.add(historyLink.getText());
            }

            if (historyLink.getText().equals("[Full Search]")) {
                afterFullSearch = true;
            }
        }

        return output;
    }
}
