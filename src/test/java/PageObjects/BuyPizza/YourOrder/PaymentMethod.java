package PageObjects.BuyPizza.YourOrder;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;

@DisplayName("Клик на выбранный способ оплаты")
public class PaymentMethod {
    public SelenideElement paymentMethod = $("#payment_method_cod");

}
