package tests;

import org.junit.jupiter.api.Test;
import pages.CreateAuthorPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAuthorTest extends BaseTest {
    @Test
    public void createAuthor() {
        CreateAuthorPage createAuthorPage = new CreateAuthorPage(driver);
        createAuthorPage.createAuthor("Mr Bee");
        String message = "Added Author";
        assertEquals(message, createAuthorPage.getSubmitMessage(), "Author not added");
    }
}
