import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Natalia");
        $("#lastName").setValue("Kiseleva");
        $("#userEmail").setValue("kiselevanat@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("7894561230");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("kitty.jpg");
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

       $(".modal-body").shouldHave(text("Natalia Kiseleva"), text("kiselevanat@mail.ru"),
               text("Female"), text("7894561230"), text("01 May,1997"), text("Maths, Computer Science"),
               text("Sports, Music"), text("kitty.jpg"), text("Some address"), text("Uttar Pradesh Lucknow"));
    }
}
