package diplom3;

import diplom3.pom.ForgotPasswordPage;
import diplom3.pom.LoginPage;
import diplom3.pom.MainPage;
import diplom3.pom.RegistrationPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseBeforeAndAfter {

    @Test
    @DisplayName("Проверка логина по кнопке 'Войти в аккаунт' на главной")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void loginWithLoginButtonTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage
                .openMain()
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());

        assertTrue("Юзер не авторизован",
                mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("Проверка логина по кнопке 'Войти в аккаунт' на главной")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void loginWithPersonalCabinetButtonTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage
                .openMain()
                .clickPersonalCabinet();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());

        assertTrue("Юзер не авторизован",
                mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("Проверка логина по кнопке 'Войти' на форме регистрации")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void loginFromRegistrationFormTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage
                .openMain()
                .clickPersonalCabinet();
        loginPage
                .clickRegistrationButton();
        registrationPage
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());

        assertTrue("Юзер не авторизован",
                mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("Проверка логина по кнопке 'Войти' на форме восстановления пароля")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void loginFromForgotPasswordFormTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage
                .openMain()
                .clickPersonalCabinet();
        loginPage
                .clickPasswordForgotButton();
        forgotPasswordPage
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());

        assertTrue("Юзер не авторизован",
                mainPage.checkOrderButton());

    }
}
