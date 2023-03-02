package projectPizza.PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


@DisplayName("Выбрать продукт")
public class ChooseProduct {
    SelenideElement searchLine =$("[name='s']");
    SelenideElement buttonToBasket = $("[name='add-to-cart']");

    @Step("Выбрать продукт на странице")
    public void pizzaToBasket(String product) {
        $$(".span3.wow.flipInY.slick-slide").find(text(product)).click();
        buttonToBasket.click();
    }

    @Step("Выбрать продукт в поле поиска")
    public void findProductInTheSearchField(String product) {
        searchLine.setValue(product).pressEnter();
        buttonToBasket.click();
    }
}
