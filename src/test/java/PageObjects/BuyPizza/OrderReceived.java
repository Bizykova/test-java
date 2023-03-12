package PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Float.parseFloat;

@Description("Проверка подтверждение заказа, проверка данных пользователя")
public class OrderReceived {

    public SelenideElement orderReceived = $x("//h2[@class='post-title']");
    public SelenideElement address = $(".woocommerce-customer-details address");
@Step("сравнить сумму заказа с суммой в чеке")
    public float total(){
        String total = $(".shop_table.order_details [scope=row]").sibling(0).text();
        float amount = parseFloat(total.replace("₽", "").replace(',', '.'));
        return amount;
    }

}
