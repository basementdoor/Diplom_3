package diplom3;

import diplom3.api.models.User;
import diplom3.api.user.UserClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import static diplom3.api.user.UserGenerator.randomUser;
import static diplom3.constants.Constants.BASE_URL;
import static diplom3.driver.WebDriverCreator.createWebDriver;

public class BaseBeforeAndAfter {

    public WebDriver driver;
    protected static User user;
    UserClient userClient = new UserClient();
    protected String accessToken;
    @Before
    public void setUp() {

        driver = createWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        RestAssured.baseURI = BASE_URL;
        user = randomUser();
        Response response = userClient.userCreate(user);
        accessToken = response.path("accessToken");

    }

    @After
    public void tearDown() {

        driver.quit();

        if(accessToken != null) {
            UserClient.userDelete(accessToken);

        }
    }
}
