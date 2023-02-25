package bizukova.widgetobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Заполнить таблицу заказа")
public class OrderDetails {

    public SelenideElement orderReceived = $(".post-title");
    public SelenideElement nameProduct = $(".woocommerce-table__product-name.product-name a");

    public SelenideElement emailCheck= $(".woocommerce-order-overview__email.email strong");
    public SelenideElement emailAddAddress= $(".woocommerce-customer-details--email");
    public SelenideElement cityElement= $(".woocommerce-customer-details address");
    public SelenideElement totalSum= $(".woocommerce-Price-amount.amount");
    public SelenideElement paymentMethod= $(".shop_table.order_details").$(byText("Прямой банковский перевод"));

}
