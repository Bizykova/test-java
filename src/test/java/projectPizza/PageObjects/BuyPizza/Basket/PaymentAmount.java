package projectPizza.PageObjects.BuyPizza.Basket;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Float.parseFloat;


public class PaymentAmount {
    public String totalAmountText = $(".order-total .woocommerce-Price-amount.amount > bdi").text();
    public SelenideElement buttonPaymentAmount = $(".wc-proceed-to-checkout a");
    float amount;

    @Step("Сумма заказа - общая стоимость")
    public Float totalCost() {
        amount = 0;
        amount = parseFloat(totalAmountText.replace("₽", "").replace(',', '.'));
        System.out.println(amount);
        return amount;
    }


}
