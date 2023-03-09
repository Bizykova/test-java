package projectPizza.PageObjects.BuyPizza.YourOrder;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PaymentMethod {

    public SelenideElement paymentMethod = $("#payment_method_cod");

    @Step("Клик на выбранный способ оплаты")
    public void paymentMethods(){
        paymentMethod.click();
    }
}
