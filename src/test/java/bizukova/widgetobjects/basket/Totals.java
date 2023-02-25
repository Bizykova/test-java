package bizukova.widgetobjects.basket;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Totals {
    public SelenideElement totalAmount=$("#primary div.cart_totals tr td[data-title=Сумма]");
}
