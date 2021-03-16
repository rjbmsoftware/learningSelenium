package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.AuthorDetailsPage;
import pages.AuthorListPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorListNavigationProfileTest extends BaseTest {
    @Test
    public void clickThroughToProfile() {
        int id = 7;
        String authorName = "Alan Hathway";
        AuthorListPage authorListPage = new AuthorListPage(this.driver);
        driver.get(AuthorListPage.getURL());
        PageFactory.initElements(this.driver, authorListPage);
        authorListPage.clickAuthorLink(authorName);

        AuthorDetailsPage authorDetailsPage = new AuthorDetailsPage(this.driver);
        PageFactory.initElements(this.driver, authorDetailsPage);
        assertEquals(id, authorDetailsPage.getAuthorID());
        assertEquals(authorName, authorDetailsPage.getAuthorName());
    }
}
