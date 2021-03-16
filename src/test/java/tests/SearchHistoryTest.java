package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.SearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchHistoryTest extends BaseTest {

    @Test
    public void HistoryIsListedWithEachAttempt() {
        // view search history page
        driver.get(SearchPage.getURL());
        SearchPage searchPage = new SearchPage(driver);
        PageFactory.initElements(driver, searchPage);

        // submit search two terms
        String term1 = "first";
        String term2 = "second";
        searchPage.searchForText(term1);
        searchPage.searchForText(term2);

        // check both are listed in history
        PageFactory.initElements(driver, searchPage);
        String historyFormat = "[%s]";
        String outputTerm1 = String.format(historyFormat, term1);
        String outputTerm2 = String.format(historyFormat, term2);
        List<String> history = searchPage.getSearchHistory();

        assertEquals(outputTerm1, history.get(0));
        assertEquals(outputTerm2, history.get(1));
    }
}
