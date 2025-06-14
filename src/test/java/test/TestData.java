package test;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    private final Faker faker = new Faker(new Locale("en"));

    // Личные данные
    public String firstName = faker.name().firstName(),
                  lastName = faker.name().lastName(),
                  email = faker.internet().emailAddress(),
                  gender = faker.options().option("Male", "Female", "Other"),
                  phoneNumber = faker.phoneNumber().subscriberNumber(10);

    // Дата рождения
    public String month = faker.options().option("January", "February", "March", "April", "May", "June",
                                                "July", "August", "September", "October", "November", "December"),
                  year = String.valueOf(faker.number().numberBetween(1900, 2024)),
                  day = String.valueOf(faker.number().numberBetween(1, 28));

    // Образование и интересы
    public String subject = faker.options().option("English", "Math", "Physics", "Chemistry", "Biology", "Computer Science");
    public String[] hobbies = new String[]{"Sports", "Music"};
    public String picturePath = "img/sample.jpg";

    // Адрес
    public String currentAddress = faker.address().fullAddress(),
                  state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
                  city = getCityByState(state);

    private String getCityByState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Unknown";
        };
    }

    // Геттеры
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getGender() { return gender; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getMonth() { return month; }
    public String getYear() { return year; }
    public String getDay() { return day; }
    public String getSubject() { return subject; }
    public String[] getHobbies() { return hobbies; }
    public String getPicturePath() { return picturePath; }
    public String getCurrentAddress() { return currentAddress; }
    public String getState() { return state; }
    public String getCity() { return city; }
} 