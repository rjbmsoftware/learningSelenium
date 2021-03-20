package tests;

import org.junit.jupiter.api.Test;
import pages.CreatePublisherPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePublisherTest extends BaseTest {
    @Test
    public void createPublisher() {
        boolean publisherAdded = new CreatePublisherPage(driver)
                .goToPage()
                .submitPublisherName("Rusty Shackleford")
                .isAuthorAdded();

        assertTrue(publisherAdded);
    }
}
