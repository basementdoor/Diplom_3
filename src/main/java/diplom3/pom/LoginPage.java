package diplom3.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By enterHeader = By.xpath(".//h2[text()='Вход']");
    private final By emailInput = By.xpath(".//label[text()='Email']/../input");
    private final By passwordInput = By.xpath(".//input[contains(@class, 'text input__textfield')and @type='password']");
    private final By loginButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0') and text()='Войти']");
    private final  By registrationButton = By.xpath(".//a[contains(@class, 'Auth_link__1fOlj') and text()='Зарегистрироваться']");
    private final  By passwordForgotButton = By.xpath(".//a[contains(@class, 'Auth_link__1fOlj') and text()='Восстановить пароль']");

    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getRegistrationButton() {
        return registrationButton;
    }

    public By getPasswordForgotButton() {
        return passwordForgotButton;
    }

    public By getEnterHeader() {
        return enterHeader;
    }

    @Step("Авторизация юзера")
    public LoginPage userLogin(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public LoginPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return this;
    }

    @Step("Нажатие на кнопку 'Восстановить пароль'")
    public LoginPage clickPasswordForgotButton() {
        driver.findElement(passwordForgotButton).click();
        return this;
    }

    @Step("Проверяем, что отображается заголовок 'Вход'")
    public boolean checkEnterHeader() {
        return driver.findElements(enterHeader).size() > 0;
    }




}
