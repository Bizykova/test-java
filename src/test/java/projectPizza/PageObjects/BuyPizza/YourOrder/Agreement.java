package projectPizza.PageObjects.BuyPizza.YourOrder;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Agreement {
     SelenideElement checkbox = $("input[type='checkbox']");

     @Step("Соглашение с условием сайта")
     public void agreementCheckbox(){
          checkbox.setSelected(false).click();
     }
}
