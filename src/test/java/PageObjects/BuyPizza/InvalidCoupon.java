package PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;
@DisplayName("Неизвестная скидка")
public class InvalidCoupon {
    public SelenideElement invalidCoupon = $(".woocommerce-error");
}
