package diplom3.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static diplom3.constants.Constants.BASE_URL;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalCabinet = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By bunButton = By.xpath(".//span[text()='Булки']/parent::div");
    private final By sauceButton = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By fillingButton = By.xpath(".//span[text()='Начинки']/parent::div");
    private final By bunSeletcted = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Булки']");
    private final By sauceSeletcted = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");
    private final By fillingSeletcted = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");
    private final By orderButton = By.xpath(".//button[contains(@class, 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg')]");


    public By getPersonalCabinet() {
        return personalCabinet;
    }

    public By getBunButton() {
        return bunButton;
    }

    public By getSauceButton() {
        return sauceButton;
    }

    public By getFillingButton() {
        return fillingButton;
    }

    public By getBunSeletcted() {
        return bunSeletcted;
    }

    public By getSauceSeletcted() {
        return sauceSeletcted;
    }

    public By getFillingSeletcted() {
        return fillingSeletcted;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getOrderButton() {
        return orderButton;
    }

    @Step("Открытие главной страницы")
    public MainPage openMain() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Нажатие на кнопку 'Личный кабинет'")
    public MainPage clickPersonalCabinet() {
        driver.findElement(personalCabinet).click();
        return this;
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public MainPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Выбрать раздел 'Булки' в конструкторе")
    public MainPage clickBunSection() {
        driver.findElement(bunButton).click();
        return this;
    }

    @Step("Выбрать раздел 'Соусы' в конструкторе")
    public MainPage clickSauceSection() {
        driver.findElement(sauceButton).click();
        return this;
    }

    @Step("Выбрать раздел 'Начинки' в конструкторе")
    public MainPage clickFillingSection() {
        driver.findElement(fillingButton).click();
        return this;
    }

    @Step("Проверяем, что выбран раздел 'Булки'")
    public boolean checkBunSelected() {
        return driver.findElements(bunSeletcted).size() > 0;
    }

    @Step("Проверяем, что выбран раздел 'Соусы'")
    public boolean checkSauceSelected() {
        return driver.findElements(sauceSeletcted).size() > 0;
    }

    @Step("Проверяем, что выбран раздел 'Начинки'")
    public boolean checkFillingSelected() {
        return driver.findElements(fillingSeletcted).size() > 0;
    }

    @Step("Проверяем, что отображается кнопка 'Оформить заказ'")
    public boolean checkOrderButton() {
        return driver.findElements(orderButton).size() > 0;
    }

}
