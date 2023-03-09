package projectPizza.PageObjects;

import projectPizza.PageObjects.BuyPizza.*;
import projectPizza.PageObjects.BuyPizza.Basket.*;
import projectPizza.PageObjects.BuyPizza.CreateUserOrder.CreateOrder;
import projectPizza.PageObjects.BuyPizza.YourOrder.Agreement;
import projectPizza.PageObjects.BuyPizza.YourOrder.PaymentMethod;
import projectPizza.PageObjects.BuyPizza.YourOrder.PlaceOrder;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Link(url = "http://pizzeria.skillbox.cc/", name = "Pizzeria")
@Epic("Регистрация пользователя оформление заказа")
public class Tests2 extends TestBase2 {
    Menu menu = new Menu();
    ChooseProduct chooseProduct = new ChooseProduct();
    IncreaseAmount increaseAmount = new IncreaseAmount();
    OrderReceived orderReceived = new OrderReceived();
    Goods goods = new Goods();
    Registration registration = new Registration();
    AmountOfGoods amountOfGoods = new AmountOfGoods();
    PaymentMethod paymentMethod = new PaymentMethod();
    Agreement agreement = new Agreement();
    PlaceOrder placeOrder = new PlaceOrder();
    PaymentAmountWithIcon paymentAmountWithIcon = new PaymentAmountWithIcon();
    UserGreeting userGreeting = new UserGreeting();
    CreateOrder createOrder = new CreateOrder();

    @Test
    @DisplayName("Регистрация пользователя оформление заказа")
    @Description("1. Открыли сайт магазина \n" +
            "2. Выбрали, добавили пиццу с ветчиной в корзину \n" +
            "3. В строке поиска ищем «какао» \n" +
            "4. Добавили какао в корзину \n" +
            "5. Перешли в  корзину \n" +
            "6. Проверили, что сумма заказа верна \n" +
            "7. Проверили содержимое корзины \n" +
            "8. Увеличили на странице корзины количество пиццы и какао до двух штук \n" +
            "9. Обновили коорзину \n" +
            "10. Проверили что содержимое корзины увеличилось до 2 шт  \n" +
            "11. Перешли в раздел «Мой аккаунт» \n" +
            "12. Прошли регистрацию \n" +
            "13. Через меню перешли к оформлению заказа \n" +
            "14. Заполнили формуляр \n" +
            "15. Выбрать дату оформления заказа (на завтра) \n" +
            "16. Выбирать оплату по доставке \n" +
            "17. Подтвердили заказ\n" +
            "18. Проверка: на странице появился элемент <<заказ получен>> \n" +
            "19. Общяя сумма заказа\n")
    void userRegistrationAndPurchaseProducts_Success() {
        //arrange
        open("http://pizzeria.skillbox.cc/");
        String pizza = " Пицца «Ветчина и грибы»";
        String cocoa = "какао";
        String userName = "Vas" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm"));
        String email = userName + "@ya.ru";
        String password = "qwerty123";

        //act
        chooseProduct.pizzaToBasket(pizza);
        chooseProduct.findProductInTheSearchField(cocoa);
        menu.openMenu("Корзина");

        //assert
        amountOfGoods.numberItemsInTheCart();
        assertEquals(new PaymentAmount().totalCost(), new SumOfGoods().checkTheSumOfItemInTheCart());
        paymentAmountWithIcon.OrderAmountNextToTheIcon();
        goods.ProductNameCheck();

        //act
        increaseAmount.increaseAmountOfProductsInTheBasket("2");

        //assert
        amountOfGoods.numberItemsInTheCart();
        sleep(2000);
        assertEquals(new PaymentAmount().totalCost(), new SumOfGoods().checkTheSumOfItemInTheCart());

        //act
        new PaymentAmount().buttonPaymentAmount.click();
        menu.openMenu("Мой аккаунт");
        registration.userRegistration(userName, email, password);

        //assert
        userGreeting.greeting.shouldHave(text("Привет " + userName));

        //act
        menu.openMenu("Оформление заказа");
        createOrder.createOrderFillWithYourData("Вася", "Печкин", "Russia",
                "ул.Кузьминки 43", "Москва", "Московская обл.", "500344", "89192345672");
        paymentMethod.paymentMethod.click();

//      Выбрать дату заказа на завтра
//      new Calendar().selectOrderDate();

        agreement.agreementCheckbox();
        placeOrder.placeOrders.click();

        //assert
        orderReceived.orderReceivedt.shouldBe(visible);

    }
}
