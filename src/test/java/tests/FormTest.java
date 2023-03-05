package tests;

import org.junit.jupiter.api.Test;

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
                address = "Russia, Moscow",
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
                        .uploadPicture(fileName)
                        .setAddress(address)
                        .setState(state)
                        .setCity(city)
                        .submit()
                        .verifyResultsModalAppears()
                        .verifyResult("Student Name","Natalia Kiseleva")
                        .verifyResult("Student Email","kiselevanat@mail.ru")
                        .verifyResult("Gender","Female")
                        .verifyResult("Mobile","7894561230")
                        .verifyResult("Date of Birth","01 May,1997")
                        .verifyResult("Subjects","Maths, Computer Science")
                        .verifyResult("Hobbies","Sports, Music")
                        .verifyResult("Picture","kitty.jpg")
                        .verifyResult("Address","Russia, Moscow")
                        .verifyResult("State and City","Uttar Pradesh Lucknow");
    }
}
