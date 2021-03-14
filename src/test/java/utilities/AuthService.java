package utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class AuthService {
    private final String authTokenName = "X-API-AUTH";
    private String authToken = null;

    /***
     * If auth token is not available in cookies navigates to known
     * page to set auth token
     * @param driver used to get cookies and nav if needed
     */
    public AuthService(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(authTokenName)) {
                authToken = cookie.getValue();
                break;
            }
        }

        if (authToken == null) {
            driver.get("http://localhost:4567/apps/pulp/gui/reports/books/table/navigation");
        }

        authToken = driver.manage().getCookieNamed(authTokenName).getValue();
    }

    public String getAuthToken() {
        return authToken;
    }
}
