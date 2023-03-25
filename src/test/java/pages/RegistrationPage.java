package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userEmailInput = $("#userEmail"),
            userTelephoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");
    private final String url = "/automation-practice-form";
    private CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу")
    public RegistrationPage openPage() {
        open(url);

        return this;
    }

    @Step("Убираем футер")
    public RegistrationPage removeFooter() {
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Убираем баннер")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Заполняем имя значением {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем фамилию значением {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем email значением {value}")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Заполняем пол значением {value}")
    public RegistrationPage setGender(String value) {
        $(byText(value)).click();

        return this;
    }

    @Step("Заполняем телефонный номер значением {value}")
    public RegistrationPage setUserTelephoneNumber(String value) {
        userTelephoneNumberInput.setValue(value);

        return this;
    }

    @Step("Заполняем дату рождения значением {day}.{month}.{year}")
    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Заполняем предмет значением {subject}")
    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Заполняем хобби значением {hobby}")
    public RegistrationPage setHobbies(String hobby) {
        $(byText(hobby)).click();

        return this;
    }

    @Step("Загружаем картинку {filename}")
    public RegistrationPage uploadPicture(String filename) {
        pictureInput.uploadFromClasspath(filename);

        return this;
    }

    @Step("Заполняем адрес значением {value}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    @Step("Заполняем штат значением {value}")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    @Step("Заполняем город значением {value}")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    @Step("Нажимаем кнопку подтверждения")
    public RegistrationPage submit() {
        submitButton.scrollIntoView(false);
        submitButton.click();

        return this;
    }

}
