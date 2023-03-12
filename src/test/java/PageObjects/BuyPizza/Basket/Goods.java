package PageObjects.BuyPizza.Basket;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class Goods{
    SelenideElement tittleBasket = $(".current");
    String cocoaProductElement = "Какао с маршмеллоу";
    String nameProductPizza = "Ветчина и грибы";
    @Step("Проверка наименований продукта")
    public void ProductNameCheck(){
        tittleBasket.shouldHave(text("Корзина"));
        $(withText(cocoaProductElement)).shouldBe(visible);
        $(withText(nameProductPizza)).shouldBe(visible);

    }
}
