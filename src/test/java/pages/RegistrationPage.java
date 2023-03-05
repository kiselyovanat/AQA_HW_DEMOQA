package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String [] values){
        for (int i = 0; i<values.length; i++){
            subjectsInput.setValue(values[i]).pressEnter();
        }

        return this;
    }

    public RegistrationPage setHobbies(String [] values){
        for (int i = 0; i<values.length; i++){
            $(byText(values[i])).click();
        }

        return this;
    }

    public RegistrationPage uploadPicture(String filename){
        pictureInput.uploadFromClasspath(filename);

        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value){
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit(){
        submitButton.scrollIntoView(false);
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }
}
