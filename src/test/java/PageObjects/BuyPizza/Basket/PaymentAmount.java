package PageObjects.BuyPizza.Basket;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Float.parseFloat;


public class PaymentAmount {
    SelenideElement totalAmountText = $(".order-total .woocommerce-Price-amount.amount > bdi");
    public SelenideElement buttonPaymentAmount = $(".wc-proceed-to-checkout a");
    SelenideElement totalDiscount = $(".cart-discount .woocommerce-Price-amount.amount");
    SelenideElement totalAmount = $(".cart-subtotal bdi");
    public SelenideElement messageCoupon = $(".woocommerce-message");
    float amount;

    @Step("Сумма заказа - общая стоимость")
    public Float totalCost() {
        amount = 0;
        amount = parseFloat(totalAmountText.text().replace("₽", "").replace(',', '.'));
        return amount;
    }

    @Step("Сумма заказа - общая стоимость - минус скидка")
    public Float totalCostMinusDiscount() {
        float sum;
        float discount = parseFloat(totalDiscount.text().replace("₽", "").replace(',', '.'));
        float amount = parseFloat(totalAmount.text().replace("₽", "").replace(',', '.'));
        sum = amount - discount;
        return sum;
    }

}
