import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.FormPageObjectsTest;
import components.ResultsTable;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork6PageObject {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillTheFormTest() {
        FormPageObjectsTest form = new FormPageObjectsTest();
        ResultsTable results = new ResultsTable();

        form.openPage();
        form.setFirstName("Mariia");
        form.setLastName("Ivanova");
        form.setEmail("mariia@example.com");
        form.selectGender("Female");
        form.setPhoneNumber("9123456789");
        form.setDateOfBirth("May", "1990", "15");
        form.setSubject("English");
        form.selectHobby("Sports");
        form.selectHobby("Music");
        form.uploadPicture("img/sample.jpg");
        form.setAddress("1234 Main Street, Moscow");
        form.selectState("Rajasthan");
        form.selectCity("Jaipur");
        form.submit();
        results.shouldAppear();
        results.shouldHaveText("Mariia Ivanova");
    }

    @Test
    void fillMinimalRequiredFieldsTest() {
        FormPageObjectsTest form = new FormPageObjectsTest();
        ResultsTable results = new ResultsTable();

        form.openPage();
        form.setFirstName("Ivan");
        form.setLastName("Petrov");
        form.selectGender("Male");
        form.setPhoneNumber("9999999999");
        form.submit();

        results.shouldAppear();
        results.shouldHaveText("Ivan Petrov");
        results.shouldHaveText("Male");
        results.shouldHaveText("9999999999");
    }

    @Test
    void negativeTestWithoutPhoneTest() {
        FormPageObjectsTest form = new FormPageObjectsTest();
        ResultsTable results = new ResultsTable();

        form.openPage();
        form.setFirstName("Anna");
        form.setLastName("Sidorova");
        form.selectGender("Female");
        form.submit();

        results.shouldNotAppear();
    }
}
