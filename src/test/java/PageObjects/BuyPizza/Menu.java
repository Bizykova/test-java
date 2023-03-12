package PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Menu {
    SelenideElement menu = $(".store-menu");
    @Step("Выбор пункта меню")
    public void openMenu(String nameMenu) {
        menu.find(byText(nameMenu)).click();
    }

}
