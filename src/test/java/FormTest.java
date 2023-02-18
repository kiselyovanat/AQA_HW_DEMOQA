import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Natalia");
        $("#lastName").setValue("Kiseleva");
        $("#userEmail").setValue("kiselevanat@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7894561230");
        $("#currentAddress").setValue("Some address 1");


   //     $("#submit").click();

       // $("#output").shouldHave(text("Alex Egorov"), text("alex@egorov.com"),
          //      text("Some address 1"), text("Another address 1"));
    }
}
