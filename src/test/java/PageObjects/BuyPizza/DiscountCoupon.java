package PageObjects.BuyPizza;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DiscountCoupon {
    SelenideElement discountCouponButton = $(".button");
    SelenideElement discountCode = $("[name=coupon_code]");

    @Step("Ввести купон <<GIVEMEHALYAVA>>")
    public void discount() {
        discountCode.setValue("GIVEMEHALYAVA");
        discountCouponButton.click();
    }

    @Step("Ввести купон с неизвестным названием")
    public void notDiscount() {
        discountCode.setValue("qwerty");
        discountCouponButton.click();
    }

}
