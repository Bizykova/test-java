package bizukova;

import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
@Link(url="https://ru.selenide.org/documentation.html", name = "Javadoc")
@Issue("IDEA-263047")
@TmsLink("IDEA-314023/")

@Epic("Покупка всего с наименованием Harry Potter")
@DisplayName("Покупка первого наименованием Harry Potter")
public class AmazonTest extends TestBase {

    @Test
    public void amazon() {
        //arrange
        open("https://www.amazon.com/");
        // act
        $("#twotabsearchtextbox").setValue("Harry Potter").pressEnter();
        // assert
        $$("[class='sg-col-20-of-24 s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']")
                .first().shouldHave(text("Harry Potter"));
        sleep(2000);
    }
}
