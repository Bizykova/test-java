package projectPizza.PageObjects.BuyPizza.CreateUserOrder;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

;

public class Calendar {
    SelenideElement openCalendar = $("#order_date");
    @Step("Выбрать дату заказа на завтра")
    public void selectOrderDate(){
        openCalendar.click(ClickOptions.usingDefaultMethod().offsetX(250));
    }
}
