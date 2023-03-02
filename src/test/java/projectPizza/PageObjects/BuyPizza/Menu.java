package projectPizza.PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Menu {
    SelenideElement menu = $(".store-menu");

    public void openMenu(String nameMenu) {
        menu.find(byText(nameMenu)).click();
    }

}
