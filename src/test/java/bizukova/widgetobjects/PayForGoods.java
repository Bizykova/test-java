package bizukova.widgetobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Оформление заказа")
public class PayForGoods {
    SelenideElement buttonPay = $(".wc-proceed-to-checkout a");
    SelenideElement bodyElement = $("#page");

    @DisplayName("кнопка для перехода оформить заказ")
    @Step(" Перейти к оплате")
    public void playForGoods() throws IOException {
        buttonPay.click();
        doScreenshot(bodyElement);

    }
    @Attachment(value = "Скрин всего экрана", fileExtension = "png")
    byte[] doScreenshot(SelenideElement element) throws IOException {
        return Files.readAllBytes(element.screenshot().toPath());
    }
}
