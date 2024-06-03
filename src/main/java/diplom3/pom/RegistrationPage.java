package diplom3.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    private By nameInput = By.xpath(".//label[text()='Имя']/../input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private By emailInput = By.xpath(".//label[text()='Email']/../input");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath(".//a[text()='Войти']");
    private By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public By getNameInput() {
        return nameInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getEmailInput() {
        return emailInput;
    }

    public By getRegistrationButton() {
        return registrationButton;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getErrorMessage() {
        return errorMessage;
    }

    @Step("Нажатие на кнопку 'Войти'")
    public RegistrationPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Регистрация пользователя")
    public RegistrationPage userRegistration(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registrationButton).click();
        return this;
    }

    @Step("Проверяем, что отображается сообщение об ошибке")
    public boolean checkErrorMessage() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
