package projectPizza.PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Registration {
    SelenideElement registrationButton = $(byText("Зарегистрироваться"));
    SelenideElement userNameElement = $("[name = username]");
    SelenideElement emailElement = $("[name = email]");
    SelenideElement passwordElement = $("[name = password]");


    @Step("Регистрация пользователя")
    public void userRegistration(String userName, String email,String password){
        registrationButton.click();
        userNameElement.setValue(userName);
        emailElement.setValue(email);
        passwordElement.setValue(password);
        registrationButton.click();


    }
}
