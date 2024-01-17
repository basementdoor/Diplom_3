package diplom3.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public By getLoginButton() {
        return loginButton;
    }

    @Step("Нажатие на кнопку 'Войти'")
    public ForgotPasswordPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
}
