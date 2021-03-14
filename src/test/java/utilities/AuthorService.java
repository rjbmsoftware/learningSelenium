package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class AuthorService {
    private final String AUTH_TOKEN;
    private final String AUTH_TOKEN_NAME = "X-API-AUTH";
    private final String URL = "http://localhost:4567/apps/pulp/api/authors";

    public AuthorService(String authToken) {
        this.AUTH_TOKEN = authToken;
    }

    public int create(String authorName) {
        String output = given().header(AUTH_TOKEN_NAME, AUTH_TOKEN)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(String.format("{\"name\": \"%s\"}", authorName))
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .when()
                .post(URL)
                .then()
                .extract().path("data.authors[0].id");

        return Integer.parseInt(output);
    }

    /***
     * @param id of author
     * @return author's name
     */
    public String read(int id) {
        return given().header(AUTH_TOKEN_NAME, AUTH_TOKEN)
                .accept(ContentType.JSON)
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .when().get(URL + "/" + id)
                .then().extract().path("data.authors[0].name");
    }
}
