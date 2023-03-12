package bizukova;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import bizukova.widgetobjects.*;
import bizukova.widgetobjects.basket.Basket;
import bizukova.widgetobjects.basket.Totals;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

@Link(url = "https://go.skillbox.ru/", name = "Курс Selenide")
@Epic("Регистрация пользователя оформление заказа")
@Feature("Регистрация")
@Story("Покупка товара")

@DisplayName("My test")

public class Tests extends TestBase {


    @Test
    @DisplayName("Оформляем заказ для покупки стиральной машины")
    @Description("1.Регистрируемся на сайте \n" +
            "2. Совершаем покупку стиральной машины \n" +
            "3. Заполняем заявку для покупки стиральной машины \n" +
            "4. Приобретаем товар \n" +
            "5. Проверяем правильность заполнения заявки \n")
    void costumerCanAddWashMachineToTheBasket() throws IOException {

        open("http://intershop6.skillbox.ru/register/");
        var username = "sel" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
        var email = username + "@ya.ru";

        new Registration().register(username, email, "password123");
        new Header().welcomeMsg.shouldHave(text("Привет " + username));
        new SearchArticle().searchFor("стиральная машина");
        new ArticlesFound().addFirstArticleToBasket();
        new Menu().openMenu("Корзина");
        new Basket().basketItems.shouldHave(size(1));
        basket(new Basket().basketItems.texts().toString());
        new Basket().firstArticleName.shouldHave(text("Стиральная машина"));
        new Basket().firstArticleQuantity.shouldHave(exactValue("1"));
        new Totals().totalAmount.shouldHave(exactText("22990,00₽"));
        new PayForGoods().playForGoods();
        new CreateOrder().createOrder("Masha", "Sizim", "Russia", "Волгоградский проспект 34", "Moscow", "Moscow region", "5550", "891934567898");
        new OrderDetails().orderReceived.shouldHave(exactText("Заказ получен"));
        new OrderDetails().nameProduct.shouldHave(text("Стиральная машина LG FH0C3ND, фронтальная, 6кг, 1000об/мин")).parent()
                .$(".product-quantity").shouldHave(text("1"));
        new OrderDetails().emailCheck.shouldHave(exactText(email));
        new OrderDetails().emailAddAddress.shouldHave(exactText(email));
        new OrderDetails().cityElement.shouldHave(text("Moscow"));
        new OrderDetails().totalSum.shouldHave(exactText("22990,00₽"));
        new OrderDetails().totalSum.shouldHave(exactText("22990,00₽"));
        new OrderDetails().paymentMethod.shouldHave(text("Прямой банковский перевод"));


    }

    @Attachment(value = "Содержимое корзины:", fileExtension = "txt")
    String basket(String contents) {
        return contents;
    }


    @Attachment(value = "Скриншот экрана", fileExtension = "png")
    byte[] doScreenshot() throws IOException{
        return screenshot("my_file_name").getBytes();
    }
}
