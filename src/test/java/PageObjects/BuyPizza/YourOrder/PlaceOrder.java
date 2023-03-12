package PageObjects.BuyPizza.YourOrder;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;
@DisplayName("Разместить заказ")
public class PlaceOrder {
    public SelenideElement placeOrder = $("#place_order");
}
