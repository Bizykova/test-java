package PageObjects;

import PageObjects.BuyPizza.Basket.*;
import PageObjects.BuyPizza.*;
import PageObjects.BuyPizza.CreateUserOrder.Calendar;
import PageObjects.BuyPizza.CreateUserOrder.CreateOrder;
import PageObjects.BuyPizza.YourOrder.Agreement;
import PageObjects.BuyPizza.YourOrder.PaymentMethod;
import PageObjects.BuyPizza.YourOrder.PlaceOrder;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Link(url = "http://pizzeria.skillbox.cc/", name = "Pizzeria")
@Epic("приобретение товара, регистрация, использование купона")
public class Tests extends TestBase {
    Menu menu = new Menu();
    OrderReceived orderReceived = new OrderReceived();
    String pizza = " Пицца «Ветчина и грибы»";
    String cocoa = "какао";
    PaymentAmount paymentAmount = new PaymentAmount();
    ChooseProduct chooseProduct = new ChooseProduct();
    String userName = "Vas" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss"));
    String email = userName + "@ya.ru";
    String password = "qwerty123";
    Registration registration = new Registration();
    CreateOrder createOrder = new CreateOrder();
    PlaceOrder placeOrder = new PlaceOrder();
    Agreement agreement = new Agreement();
    PaymentMethod paymentMethod = new PaymentMethod();
    String massage = "Неверный купон.";
    @Issue("https://github.com/Bizykova/reports/blob/master/bug_report.xlsx")
    @TmsLink("https://github.com/Bizykova/reports/blob/master/test%20_AI_10.odt")
    @Story("Регистрация пользователя оформление заказа")
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
            "10. Проверили, что содержимое корзины увеличилось до 2 шт какао и пиццы \n" +
            "11. Перешли в раздел «Мой аккаунт» \n" +
            "12. Прошли регистрацию \n" +
            "13. Через меню перешли к оформлению заказа \n" +
            "14. Заполнили формуляр \n" +
            "15. Выбрали дату оформления заказа (на завтра) \n" +
            "16. Выбирает оплату по доставке" +
            "17. Подтвердили заказ\n" +
            "18. Проверка: общуя сумма заказа, данные покупателя\n")
    void userRegistrationAndPurchaseProducts_Success() throws ParseException {
        //arrange
        open("http://pizzeria.skillbox.cc/");
        Goods goods = new Goods();
        PaymentAmountWithIcon paymentAmountWithIcon = new PaymentAmountWithIcon();
        AmountOfGoods amountOfGoods = new AmountOfGoods();
        IncreaseAmount increaseAmount = new IncreaseAmount();
        AmountOfGoods amountOfGoods1 = new AmountOfGoods();
        UserGreeting userGreeting = new UserGreeting();
        Calendar calendar = new Calendar();
        //act
        chooseProduct.pizzaToBasket(pizza);
        chooseProduct.findProductInTheSearchField(cocoa);
        menu.openMenu("Корзина");
        //assert
        amountOfGoods.numberItemsInTheCart();
        assertEquals(paymentAmount.totalCost(), new SumOfGoods().checkTheSumOfItemInTheCart());
        paymentAmountWithIcon.OrderAmountNextToTheIcon();
        goods.ProductNameCheck();
        //act
        increaseAmount.increaseAmountOfProductsInTheBasket("2");
        //assert
        amountOfGoods1.numberItemsInTheCart();
        sleep(2000);
        float totalCost = paymentAmount.totalCost();
        assertEquals(totalCost, new SumOfGoods().checkTheSumOfItemInTheCart());
        //act
        paymentAmount.buttonPaymentAmount.click();
        menu.openMenu("Мой аккаунт");
        registration.userRegistration(userName, email, password);
        //assert
        userGreeting.greeting.shouldHave(text("Привет " + userName));
        //act
        menu.openMenu("Оформление заказа");
        createOrder.createOrderFillWithYourData("Вася", "Печкин", "Russia",
                "ул.Кузьминки 43", "Москва", "Московская обл.", "500344", "89192345672");

        paymentMethod.paymentMethod.click();
        calendar.selectOrderDate();
        agreement.agreementCheckbox();
        placeOrder.placeOrder.click();


        //assert
        orderReceived.orderReceived.shouldBe(visible);
        orderReceived.address.shouldHave(text("Вася")).shouldHave(text("Печкин")).shouldHave(text("ул.Кузьминки 43"))
                .shouldHave(text("Москва")).shouldHave(text("Московская обл.")).shouldHave(text("500344"))
                .shouldHave(text("89192345672")).shouldHave(text(email));
        float total = orderReceived.total();
        assertEquals(total, totalCost, "not equals");


    }
    @Story("Использовать купон со скидкой")
    @DisplayName("Общая стоимость товара - минус скидка")
    @Test
    void addItemToCartUseDiscount_DescriptionPassed() {
        //arrange
        open("http://pizzeria.skillbox.cc/");
        chooseProduct.pizzaToBasket(pizza);
        menu.openMenu("Корзина");
        //act

        new DiscountCoupon().discount();

        //assert
        assertEquals(paymentAmount.totalCostMinusDiscount(), paymentAmount.totalCost());

    }

    @Story("использовать купон со скидкой")
    @DisplayName("Общая стоимость товара - неизвестная скидка")
    @Test
    void addItemToCartUseDiscount_UnknownDiscount() {
        //arrange
        open("http://pizzeria.skillbox.cc/");
        chooseProduct.pizzaToBasket(pizza);
        menu.openMenu("Корзина");
        InvalidCoupon invalidCoupon= new InvalidCoupon();
        //act

        new DiscountCoupon().notDiscount();

        //assert

        assertEquals(invalidCoupon.invalidCoupon.text(),massage,"нет сообщения об ошибке");

    }
    @Issue("https://github.com/Bizykova/reports/blob/master/bug_report.xlsx")
    @TmsLink("https://github.com/Bizykova/reports/blob/master/test_AI_15.odt")
    @Story("Использовать купон со скидкой повторно")
    @DisplayName("Купон действует один раз для каждого нового клиента")
    @Test
    public void couponWorksOnceForEachNewCustomer_Success() {

        open("http://pizzeria.skillbox.cc/");
        menu.openMenu("Акции");

        menu.openMenu("Мой аккаунт");
        registration.userRegistration(userName, email, password);
        menu.openMenu("Главная");
        chooseProduct.pizzaToBasket(pizza);
        menu.openMenu("Корзина");
        new DiscountCoupon().discount();
        paymentAmount.buttonPaymentAmount.click();
        createOrder.createOrderFillWithYourData("Вася", "Печкин", "Russia",
                "ул.Кузьминки 43", "Москва", "Московская обл.", "500344", "89192345672");
        paymentMethod.paymentMethod.click();
        agreement.agreementCheckbox();
        placeOrder.placeOrder.click();
        menu.openMenu("Главная");
        chooseProduct.findProductInTheSearchField(cocoa);
        menu.openMenu("Корзина");
        new DiscountCoupon().discount();

        //assert
        assertEquals(paymentAmount.messageCoupon.text(),massage,"Купон применился");
    }
}
