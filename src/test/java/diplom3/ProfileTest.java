package diplom3;

import diplom3.pom.LoginPage;
import diplom3.pom.MainPage;
import diplom3.pom.ProfilePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfileTest extends BaseBeforeAndAfter {

    @Test
    @DisplayName("Проверка перехода в личный кабинет (профиль)")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void transitionProfileTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage
                .openMain()
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());
        mainPage
                .clickPersonalCabinet();

        assertEquals("Юзер не в профиле",
                true,
                profilePage.checkProfileHeader());

    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на конструктор из профиля)")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void transitionConstructorTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage
                .openMain()
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());
        mainPage
                .clickPersonalCabinet();
        profilePage
                .clickConstructorButton();

        assertEquals("Юзер не на главной",
                true,
                mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на лого из профиля)")
    @Description("Отображается кнопка 'Оформить заказ'")
    public void transitionLogoTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage
                .openMain()
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());
        mainPage
                .clickPersonalCabinet();
        profilePage
                .clickLogoButton();

        assertEquals("Юзер не на главной",
                true,
                mainPage.checkOrderButton());

    }

    @Test
    @DisplayName("Проверка выхода из профиля)")
    @Description("Отображается страница логина")
    public void LogOutTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage
                .openMain()
                .clickLoginButton();
        loginPage
                .userLogin(user.getEmail(), user.getPassword());
        mainPage
                .clickPersonalCabinet();
        profilePage
                .clickLogOutButton();

        assertEquals("Юзер все еще авторизован",
                true,
                loginPage.checkEnterHeader());

    }

}
