package projectPizza.PageObjects.BuyPizza.Basket;

import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Float.parseFloat;

public class SumOfGoods {
    List<String> cost = $$(".woocommerce-cart-form__cart-item.cart_item  [data-title='Общая стоимость']").texts();
    public float wholeSum;

    @Step("Подсчитать сумму заказа в корзине")
    public float checkTheSumOfItemInTheCart() {
        wholeSum = 0;

        for (int i = 0; i < cost.size(); i++) {
            wholeSum += parseFloat(cost.get(i).replace("₽", "").replace(",", "."));
        }
        return wholeSum;
    }

}
