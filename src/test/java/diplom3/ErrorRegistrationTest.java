package diplom3;

import diplom3.pom.LoginPage;
import diplom3.pom.MainPage;
import diplom3.pom.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


import static diplom3.utils.Utils.faker;
import static org.junit.Assert.assertTrue;

public class ErrorRegistrationTest extends BaseBeforeAndAfter {

    @Test
    @DisplayName("Ошибка регистрации пользователя при пароле менее 6 символов")
    @Description("Появляется сообщение об ошибке")
    public void errorRegistrationTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage
                .openMain()
                .clickLoginButton();
        loginPage
                .clickRegistrationButton();
        registrationPage
                .userRegistration(faker.name().username(), faker.internet().emailAddress(), faker.internet().password(1, 5));

        assertTrue("Сообщение об ошибке не появилось",
                registrationPage.checkErrorMessage());
    }

}
