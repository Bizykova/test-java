package PageObjects.BuyPizza.CreateUserOrder;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

;

public class Calendar {

    SelenideElement openCalendar = $("#order_date");
    SelenideElement date = $("[type='date']");

    @Step("Выбрать дату заказа на завтра")
    public void selectOrderDate() throws ParseException {
        //openCalendar.click(ClickOptions.usingDefaultMethod().offsetX(250));

        Date dt = new Date();
        Date tomorrow = new Date(dt.getTime() + (1000 * 60 * 60 * 24));
        String dateStr = tomorrow.toLocaleString();

        Locale locale = new Locale("ru", "RU");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");

        date.setValue(
                formatter1.format(dateFormat.parse(dateStr))
        );

    }
}
