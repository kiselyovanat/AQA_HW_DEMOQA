package testData;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Map;

public class TestDataForRegistrationForm {
    public static String[]
            genders = {"Male", "Other", "Female"},
            subjects = {"Maths", "Arts", "Accounting", "English", "Social Studies", "Computer Science",
                    "Commerce", "Economics", "Chemistry", "Biology", "Physics", "Civics"},
            hobbies = {"Sports", "Reading", "Music"},
            months = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"};

    public static Map<String, String[]> statesAndCities = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    public static Faker faker = new Faker(new Locale("en"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().nextElement(genders),
            userTelephoneNumber = faker.phoneNumber().subscriberNumber(10),
            dayOfBirth = String.valueOf(faker.number().numberBetween(01, 28)),
            monthOfBirth = faker.options().nextElement(months),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1960, 2005)),
            fileName = "kitty.jpg",
            address = faker.address().fullAddress(),
            state = faker.options().nextElement(statesAndCities.keySet().toArray()).toString(),
            city = faker.options().nextElement(statesAndCities.get(state)),
            subject = faker.options().nextElement(subjects),
            hobby = faker.options().nextElement(hobbies);
}
