package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.EditAuthorPage;
import utilities.AuthService;
import utilities.AuthorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditAuthor extends BaseTest {
    @Test
    public void editAuthorChangesPersist() {
        // create author knowing id
        // create session
        driver.get("http://localhost:4567/apps/pulp/gui/reports/books/table/navigation");
        String authToken = new AuthService(driver).getAuthToken();
        AuthorService authorService = new AuthorService(authToken);
        int id = authorService.create("DR DOBBS");

        // do front end changes to author
        EditAuthorPage editAuthorPage = new EditAuthorPage(this.driver, id);
        driver.get(editAuthorPage.getUrl());
        PageFactory.initElements(this.driver, editAuthorPage);
        String updatedAuthorName = "Mr Dobbs";
        editAuthorPage.updateAuthorName(updatedAuthorName);

        // assert changes via a service
        String actualAuthorName = authorService.read(id);
        assertEquals(updatedAuthorName, actualAuthorName);
    }
}
