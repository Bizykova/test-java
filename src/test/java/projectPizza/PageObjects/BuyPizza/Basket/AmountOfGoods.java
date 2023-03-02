package projectPizza.PageObjects.BuyPizza.Basket;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.parseInt;

public class AmountOfGoods {
    ElementsCollection amountElement = $$(".quantity input");
    int num;

    @Step("Общее коль-во товара в корзине")
    public void numberItemsInTheCart() {
        num = 0;
        for (int i = 0; i < amountElement.size(); i++) {
            num += parseInt(amountElement.get(i).getValue());
        }
    }

}
