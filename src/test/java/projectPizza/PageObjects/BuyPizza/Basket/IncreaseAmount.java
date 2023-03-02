package projectPizza.PageObjects.BuyPizza.Basket;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class IncreaseAmount {

    ElementsCollection amountElement = $$(".quantity");
    SelenideElement buttonUpdateCart = $("[name='update_cart']");

    @Step("Увеличить количество товаров в корзине")
    public void increaseAmountOfProductsInTheBasket(String quantity) {

        for (int i = 0; i < amountElement.size(); i++) {
            actions().moveToElement(amountElement.get(i)).moveByOffset(-25, -15).click().doubleClick().sendKeys(quantity).perform();
        }
        buttonUpdateCart.click();


    }
}
