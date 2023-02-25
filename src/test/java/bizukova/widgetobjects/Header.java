package bizukova.widgetobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import static com.codeborne.selenide.Selenide.$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Регистрация")
public class Header {
    public SelenideElement welcomeMsg= $("header .welcome-user");
}
