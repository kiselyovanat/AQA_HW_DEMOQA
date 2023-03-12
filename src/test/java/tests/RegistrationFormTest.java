package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;

import static testData.TestDataForRegistrationForm.*;

public class RegistrationFormTest extends TestBase {

    public RegistrationPage registrationPage = new RegistrationPage();
    public RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeFooter()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserTelephoneNumber(userTelephoneNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        registrationResultModal.verifyModalAppears()
                .verifyResult("Student Name", firstName + ' ' + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userTelephoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + ' ' + monthOfBirth + ',' + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", fileName)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + ' ' + city);
    }
}
