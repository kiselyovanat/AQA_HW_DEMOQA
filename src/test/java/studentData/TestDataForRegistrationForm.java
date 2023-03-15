package studentData;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TestDataForRegistrationForm {
    public static String[]
            genders = {"Male", "Other", "Female"},
            subjects = {"Maths", "Arts", "Accounting", "English", "Social Studies", "Computer Science",
                    "Commerce", "Economics", "Chemistry", "Biology", "Physics", "Civics"},
            hobbies = {"Sports", "Reading", "Music"};

    public static Map<String, String[]> statesAndCities = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    public static Faker faker = new Faker(new Locale("en"));

    public static StudentData generateStudent() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = faker.options().nextElement(genders),
                userTelephoneNumber = faker.phoneNumber().subscriberNumber(10),
                fileName = "kitty.jpg",
                address = faker.address().fullAddress(),
                state = faker.options().nextElement(statesAndCities.keySet().toArray()).toString(),
                city = faker.options().nextElement(statesAndCities.get(state)),
                subject = faker.options().nextElement(subjects),
                hobby = faker.options().nextElement(hobbies);

        Date dateOfBirth = faker.date().birthday();
        String dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(dateOfBirth),
                monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(dateOfBirth),
                yearOfBirth = (new SimpleDateFormat("y", Locale.ENGLISH)).format(dateOfBirth);

        return new StudentData()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserTelephoneNumber(userTelephoneNumber)
                .setFileName(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubject(subject)
                .setHobby(hobby)
                .setDayOfBirth(dayOfBirth)
                .setMonthOfBirth(monthOfBirth)
                .setYearOfBirth(yearOfBirth);

    }


}
