package bizukova.widgetobjects.basket;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Basket {

    public ElementsCollection basketItems=$$("#primary tr.cart_item");
    public SelenideElement firstArticleName=$("#primary tr.cart_item td[data-title=Товар]");
    public SelenideElement firstArticleQuantity =$("#primary tr.cart_item td[data-title=Количество] input");
}
