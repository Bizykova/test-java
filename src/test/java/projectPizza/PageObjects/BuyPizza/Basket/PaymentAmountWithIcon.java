package projectPizza.PageObjects.BuyPizza.Basket;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.$;

public class PaymentAmountWithIcon {
    @Description("Сумма заказа - рядом с иконкой ")

    public SelenideElement totalAmount = $(".cart-contents.wcmenucart-contents");
    public SelenideElement buttonPaymentAmount = $(".cart-contents.wcmenucart-contents i");

    public void OrderAmountNextToTheIcon() {
        SumOfGoods sumOfGoods = new SumOfGoods();
        String amount = Float.toString(sumOfGoods.checkTheSumOfItemInTheCart()).replace(".",",");
        totalAmount.shouldHave(Condition.ownText(amount));
        buttonPaymentAmount.click();
    }


}
