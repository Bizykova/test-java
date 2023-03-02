package projectPizza.PageObjects.BuyPizza.CreateUserOrder;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateOrder {
    SelenideElement firstNameElement = $("#billing_first_name");
    SelenideElement lastNameElement = $("#billing_last_name");

    SelenideElement buttonSelectCountry = $(".select2-selection__arrow");
    ElementsCollection countries = $$(".select2-results li");

    SelenideElement addressElement = $("#billing_address_1");
    SelenideElement cityElement = $("#billing_city");

    SelenideElement regionElement = $("#billing_state");
    SelenideElement postcodeElement = $("#billing_postcode");
    SelenideElement phoneElement = $("#billing_phone");


    @Step("Создать заказ")
    public void createOrderFillWithYourData(String name,String lastName, String country,String address, String city, String region, String post, String phone){

        firstNameElement.setValue(name).click();
        lastNameElement.setValue(lastName).click();
        buttonSelectCountry.click();
        countries.find(text(country)).click();
        addressElement.setValue(address).click();
        cityElement.setValue(city).click();
        regionElement.setValue(region).click();
        postcodeElement.setValue(post).click();
        phoneElement.setValue(phone).click();
    }
}
