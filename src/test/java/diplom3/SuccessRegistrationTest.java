package diplom3;

import diplom3.api.models.User;
import diplom3.pom.LoginPage;
import diplom3.pom.MainPage;
import diplom3.pom.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import static diplom3.utils.Utils.faker;
import static org.junit.Assert.assertEquals;

public class SuccessRegistrationTest extends BaseBeforeAndAfter {

    private String userTestEmail = faker.internet().emailAddress();
    private String userTestPassword = faker.internet().password(7, 10);
    private String userTestName = faker.name().username();

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Отображается кнопка 'Войти' на странице логина")
    public void successRegistrationTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage
                .openMain()
                .clickPersonalCabinet();
        loginPage
                .clickRegistrationButton();
        registrationPage
                .userRegistration(userTestName, userTestEmail, userTestPassword);

        assertEquals("Пользователь не был зарегистирован",
                true,
                loginPage.checkEnterHeader());

    }

    @After
    public void tearDown() {

        driver.quit();

        User logInUser = new User()
                .withEmail(userTestEmail)
                .withPassword(userTestPassword);

        Response logInUserResponse = userClient.userLogIn(logInUser);
        accessToken = logInUserResponse.path("accessToken");
        userClient.userDelete(accessToken);

    }
}
