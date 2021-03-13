package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.EditAuthorPage;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditAuthor extends BaseTest {
    @Test
    public void editAuthorChangesPersist() {
        // create author knowing id
        // create session
        driver.get("http://localhost:4567/apps/pulp/gui/reports/books/table/navigation");
        String sessionId = driver.manage().getCookieNamed("X-API-AUTH").getValue();

        String authURL = "http://localhost:4567/apps/pulp/api/session";
        given().header("X-API-AUTH", sessionId).post(authURL);
        String output = given().header("X-API-AUTH", sessionId)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body("""
                        {
                          "name": "DR DOBBS"
                        }""")
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .when()
                .post("http://localhost:4567/apps/pulp/api/authors")
                .then().extract().path("data.authors[0].id");
        int id = Integer.parseInt(output);
        // do front end changes to author
        EditAuthorPage editAuthorPage = new EditAuthorPage(this.driver, id);
        driver.get(editAuthorPage.getUrl());
        PageFactory.initElements(this.driver, editAuthorPage);
        String updatedAuthorName = "Mr Dobbs";
        editAuthorPage.updateAuthorName(updatedAuthorName);

        // assert changes via a service
        String actualAuthorName = given().header("X-API-AUTH", sessionId)
                .accept(ContentType.JSON)
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .when().get("http://localhost:4567/apps/pulp/api/authors/" + id)
                .then().extract().path("data.authors[0].name");

        assertEquals(updatedAuthorName, actualAuthorName);
    }
}
