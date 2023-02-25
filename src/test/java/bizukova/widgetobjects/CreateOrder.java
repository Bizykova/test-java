package bizukova.widgetobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Регистрация , оформление заказа")
@DisplayName("аполним поля таблицы заказа входными данными")
public class CreateOrder {
    SelenideElement nameInput = $("#billing_first_name");
    SelenideElement lastNameInput = $("#billing_last_name");
    ElementsCollection countrysInput = $$(".select2-dropdown.select2-dropdown--below span li");
    SelenideElement openListOfCountries = $(".select2-selection__arrow");
    SelenideElement addressInput = $("#billing_address_1");
    SelenideElement cityInput = $("#billing_city");
    SelenideElement regionInput = $("#billing_state");
    SelenideElement indexInput = $("#billing_postcode");
    SelenideElement phoneInput = $("#billing_phone");
    SelenideElement buttonOrder = $("#place_order");

    @Step("заполним поля таблицы заказа входными данными")
    public void createOrder(String name, String lastName, String country, String address, String city, String region, String index, String phone) {
        nameInput.setValue(name);
        lastNameInput.setValue(lastName);
        openListOfCountries.click();
        countrysInput.find(text(country)).click();
        addressInput.click();
        addressInput.setValue(address);
        cityInput.click();
        cityInput.setValue(city);
        regionInput.click();
        regionInput.setValue(region);
        indexInput.click();
        indexInput.setValue(index);
        phoneInput.click();
        phoneInput.setValue(phone);
        buttonOrder.click();
    }
}
