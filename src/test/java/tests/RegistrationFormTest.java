package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;
import studentData.StudentData;
import studentData.TestDataForRegistrationForm;

public class RegistrationFormTest extends TestBase {
    public RegistrationPage registrationPage = new RegistrationPage();
    public RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @Test
    @Feature("Форма регистрации")
    @Story("Заполнение формы регистрации")
    @DisplayName("Заполняем форму регистрации сгенерированными данными")
    @Tag("remote")
    void fillFormTest() {
        StudentData studentData = TestDataForRegistrationForm.generateStudent();
        registrationPage.openPage()
                .removeFooter()
                .removeBanner()
                .setFirstName(studentData.getFirstName())
                .setLastName(studentData.getLastName())
                .setUserEmail(studentData.getEmail())
                .setGender(studentData.getGender())
                .setUserTelephoneNumber(studentData.getUserTelephoneNumber())
                .setBirthDay(studentData.getDayOfBirth(), studentData.getMonthOfBirth(), studentData.getYearOfBirth())
                .setSubjects(studentData.getSubject())
                .setHobbies(studentData.getHobby())
                .uploadPicture(studentData.getFileName())
                .setAddress(studentData.getAddress())
                .setState(studentData.getState())
                .setCity(studentData.getCity())
                .submit();

        registrationResultModal.verifyModalAppears()
                .verifyResult("Student Name", studentData.getFirstName() + ' ' + studentData.getLastName())
                .verifyResult("Student Email", studentData.getEmail())
                .verifyResult("Gender", studentData.getGender())
                .verifyResult("Mobile", studentData.getUserTelephoneNumber())
                .verifyResult("Date of Birth", studentData.getDayOfBirth() + ' ' + studentData.getMonthOfBirth() + ',' + studentData.getYearOfBirth())
                .verifyResult("Subjects", studentData.getSubject())
                .verifyResult("Hobbies", studentData.getHobby())
                .verifyResult("Picture", studentData.getFileName())
                .verifyResult("Address", studentData.getAddress())
                .verifyResult("State and City", studentData.getState() + ' ' + studentData.getCity());
    }
}
