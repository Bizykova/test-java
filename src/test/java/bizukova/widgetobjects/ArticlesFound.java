package bizukova.widgetobjects;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$$;
@Epic("Pегистрация пользователя оформление заказа")
@Feature("Покупка торара")
@Story("Покупка товара")
public class ArticlesFound {

    public ElementsCollection articles=$$("#primary .wc-products li");


    @DisplayName("Положить товар в корзину")
    @Step("Положить товар в корзину")
    public void addFirstArticleToBasket(){
        articles.first().$(".price-cart a").click();
    }
}
