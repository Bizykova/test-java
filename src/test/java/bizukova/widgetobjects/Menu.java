package bizukova.widgetobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
@Epic("Регистрация пользователя оформление заказа")
@Feature("Покупка торара")
public class Menu {

    SelenideElement menu=$("#menu-primary-menu");

    @DisplayName("Выбрать необходимый пункт меню")
    @Step("открыть меню {name}")
    public void openMenu(String name) throws IOException {
        menu.find(byText(name)).click();
        doScreenshot(menu);
    }
     @Attachment(value = "Меню", fileExtension = "png")
     byte[] doScreenshot(SelenideElement element) throws IOException {
        return Files.readAllBytes(element.screenshot().toPath());
     }
}
