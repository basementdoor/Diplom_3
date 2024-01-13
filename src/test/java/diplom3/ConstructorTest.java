package diplom3;

import diplom3.pom.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseBeforeAndAfter {

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'")
    @Description("Соответствующий элемент отображается")
    public void switchBunTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage
                .openMain()
                .clickSauceSection()
                .clickBunSection();

        assertEquals("Нужный раздел не отображается",
                true,
                mainPage.checkBunSelected());

    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    @Description("Соответствующий элемент отображается")
    public void switchSauceTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage
                .openMain()
                .clickSauceSection();

        assertEquals("Нужный раздел не отображается",
                true,
                mainPage.checkSauceSelected());

    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    @Description("Соответствующий элемент отображается")
    public void switchFillingTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage
                .openMain()
                .clickFillingSection();

        assertEquals("Нужный раздел не отображается",
                true,
                mainPage.checkFillingSelected());
    }
}
