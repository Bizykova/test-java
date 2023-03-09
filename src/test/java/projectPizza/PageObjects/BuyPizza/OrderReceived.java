package projectPizza.PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;

import static com.codeborne.selenide.Selenide.$x;

@Description("Проверка подтверждение заказа")
public class OrderReceived {
    public SelenideElement orderReceivedt = $x("//h2[@class='post-title']");


}
