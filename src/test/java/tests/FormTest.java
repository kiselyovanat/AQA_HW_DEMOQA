package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends TestBase {
    @Test
    void fillFormTest() {
        String firstName = "Natalia",
                lastName = "Kiseleva",
                email = "kiselevanat@mail.ru",
                gender = "Female",
                userNumber = "7894561230",
                dayOfBirth = "01",
                monthOfBirth = "May",
                yearOfBirth = "1997",
                subjects[] = new String[] {"Math", "Computer Science"},
                hobbies[] = new String[] {"Sports", "Music"},
                fileName = "kitty.jpg",
                state = "Uttar Pradesh",
                city = "Lucknow";

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(email)
                        .setGender(gender)
                        .setUserNumber(userNumber)
                        .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                        .setSubjects(subjects)
                        .setHobbies(hobbies)
                        .uploadPicture(fileName);

        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").scrollIntoView(false);
        $("#submit").click();

       $(".modal-body").shouldHave(text("Natalia Kiseleva"), text("kiselevanat@mail.ru"),
               text("Female"), text("7894561230"), text("01 May,1997"), text("Maths, Computer Science"),
               text("Sports, Music"), text("kitty.jpg"), text("Some address"), text("Uttar Pradesh Lucknow"));
    }
}
