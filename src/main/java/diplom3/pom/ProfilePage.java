package diplom3.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By profileHeader = By.xpath(".//a[text()='Профиль']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private final By logOutButton = By.xpath(".//button[text()='Выход']");

    public By getProfileHeader() {
        return profileHeader;
    }

    public By getConstructorButton() {
        return constructorButton;
    }

    public By getLogoButton() {
        return logoButton;
    }

    public By getLogOutButton() {
        return logOutButton;
    }

    @Step("Проверяем, что отображается раздел 'Профиль'")
    public boolean checkProfileHeader() {
        return driver.findElements(profileHeader).size() > 0;
    }

    @Step("Клик на кнопку конструктора в профиле")
    public ProfilePage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return this;
    }

    @Step("Клик на лого в профиле")
    public ProfilePage clickLogoButton() {
        driver.findElement(logoButton).click();
        return this;
    }

    @Step("Клик на кнопку 'Выход' в профиле")
    public ProfilePage clickLogOutButton() {
        driver.findElement(logOutButton).click();
        return this;
    }

}
