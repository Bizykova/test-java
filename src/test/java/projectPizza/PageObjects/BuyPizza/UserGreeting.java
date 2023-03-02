package projectPizza.PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;

import static com.codeborne.selenide.Selenide.$;

@Feature("приветствие пользователя после регистрации")
public class UserGreeting {
    public SelenideElement greeting = $(".welcome-user");

}
