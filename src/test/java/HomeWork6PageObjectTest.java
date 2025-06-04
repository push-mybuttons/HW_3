import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import components.ResultsTable;
import test.TestData;

public class HomeWork6PageObjectTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    /**
     * Тест заполнения всех полей формы
     * Проверяет корректность сохранения и отображения всех введенных данных
     */
    @Test
    void fillTheFormTest() {
        // Подготовка тестовых данных
        TestData testData = new TestData();

        // Инициализация страничных объектов
        FormPageObjects form = new FormPageObjects();
        ResultsTable results = new ResultsTable();

        form.openPage()
            .setFirstName(testData.getFirstName())
            .setLastName(testData.getLastName())
            .setEmail(testData.getEmail())
            .selectGender(testData.getGender())
            .setPhoneNumber(testData.getPhoneNumber())
            .setDateOfBirth(testData.getMonth(), testData.getYear(), testData.getDay())
            .setSubject(testData.getSubject())
            .selectHobby(testData.getHobbies()[0])
            .selectHobby(testData.getHobbies()[1])
            .uploadPicture(testData.getPicturePath())
            .setAddress(testData.getCurrentAddress())
            .selectState(testData.getState())
            .selectCity(testData.getCity())
            .submit();

        results.shouldAppear()
            .shouldHaveText(testData.getFirstName() + " " + testData.getLastName())
            .shouldHaveText(testData.getEmail())
            .shouldHaveText(testData.getPhoneNumber())
            .shouldHaveText(testData.getDay() + " " + testData.getMonth() + "," + testData.getYear())
            .shouldHaveText(testData.getSubject())
            .shouldHaveText(testData.getHobbies()[0])
            .shouldHaveText(testData.getHobbies()[1]);
    }

    @Test
    void fillMinimalRequiredFieldsTest() {
        TestData testData = new TestData();

        FormPageObjects form = new FormPageObjects();
        ResultsTable results = new ResultsTable();

        form.openPage()
            .setFirstName(testData.getFirstName())
            .setLastName(testData.getLastName())
            .selectGender(testData.getGender())
            .setPhoneNumber(testData.getPhoneNumber())
            .submit();

        results.shouldAppear()
            .shouldHaveText(testData.getFirstName() + " " + testData.getLastName())
            .shouldHaveText(testData.getGender())
            .shouldHaveText(testData.getPhoneNumber());
    }

    @Test
    void negativeTestWithoutPhoneTest() {
        TestData testData = new TestData();

        FormPageObjects form = new FormPageObjects();
        ResultsTable results = new ResultsTable();

        form.openPage()
            .setFirstName(testData.getFirstName())
            .setLastName(testData.getLastName())
            .selectGender(testData.getGender())
            .submit();

        results.shouldNotAppear();
    }
}
