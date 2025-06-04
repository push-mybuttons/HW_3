import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import components.ResultsTable;
public class HomeWork6PageObjectTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillTheFormTest() {
        FormPageObjects form = new FormPageObjects();
        ResultsTable results = new ResultsTable();

        form.openPage()
            .setFirstName("Mariia")
            .setLastName("Ivanova")
            .setEmail("mariia@example.com")
            .selectGender("Female")
            .setPhoneNumber("9123456789")
            .setDateOfBirth("May", "1990", "15")
            .setSubject("English")
            .selectHobby("Sports")
            .selectHobby("Music")
            .uploadPicture("img/sample.jpg")
            .setAddress("1234 Main Street, Moscow")
            .selectState("Rajasthan")
            .selectCity("Jaipur")
            .submit();
        results.shouldAppear()
            .shouldHaveText("Mariia Ivanova")
            .shouldHaveText("mariia@example.com")
            .shouldHaveText("9123456789")
            .shouldHaveText("15 May,1990")
            .shouldHaveText("English")
            .shouldHaveText("Sports")
            .shouldHaveText("Music");
    }

    @Test
    void fillMinimalRequiredFieldsTest() {
        FormPageObjects form = new FormPageObjects();
        ResultsTable results = new ResultsTable();

        form.openPage()
            .setFirstName("Ivan")
            .setLastName("Petrov")
            .selectGender("Male")
            .setPhoneNumber("9999999999")
            .submit();

        results.shouldAppear()
            .shouldHaveText("Ivan Petrov")
            .shouldHaveText("Male")
            .shouldHaveText("9999999999");
    }

    @Test
    void negativeTestWithoutPhoneTest() {
        FormPageObjects form = new FormPageObjects();
        ResultsTable results = new ResultsTable();

        form.openPage()
            .setFirstName("Anna")
            .setLastName("Sidorova")
            .selectGender("Female")
            .submit();

        results.shouldNotAppear();
    }
}
