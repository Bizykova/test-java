package bizukova.widgetobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Регистрация")
public class Registration {

    // elements
    SelenideElement usernameInput=$("#reg_username");
    SelenideElement emailInput=$("#reg_email");
    SelenideElement passwordInput=$("#reg_password");
    SelenideElement registerBtn=$("button[name=register]");

    // actions
    @Step("Зарегистрировать пользователя с именем {username}")
    public void register(String username, String email, String password){
        usernameInput.setValue(username);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        registerBtn.click();
    }
}
