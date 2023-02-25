package bizukova.widgetobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Покупка торара")
public class SearchArticle {

    SelenideElement searchInput=$("header input[name=s]");
    @DisplayName("Поиск товара")
    @Step("Ищем товар: {article}")
    public void searchFor(String article){
        searchInput.setValue(article).pressEnter();
    }

}
