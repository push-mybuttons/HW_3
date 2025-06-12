import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPageObjects;
import components.ResultsTable;
import test.TestData;

public class HomeWork6PageObjectTest {
    private TestData testData;  // Тестовые данные
    private FormPageObjects form;  // Страничный объект формы
    private ResultsTable results;  // Страничный объект результатов

    @BeforeEach
    void setUp() {
        testData = new TestData();
        form = new FormPageObjects();
        results = new ResultsTable();
    }
    @BeforeAll
    static void beforeAll() {  // Инициализация браузера
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

        // Заполнение формы
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

        // Проверка результатов
        results.shouldAppear()
            .shouldHaveText(testData.getFirstName() + " " + testData.getLastName())
            .shouldHaveText(testData.getEmail())
            .shouldHaveText(testData.getPhoneNumber())
            .shouldHaveText(testData.getDay() + " " + testData.getMonth() + "," + testData.getYear())
            .shouldHaveText(testData.getSubject())
            .shouldHaveText(testData.getHobbies()[0])
            .shouldHaveText(testData.getHobbies()[1]);
    }

    /**
     * Тест заполнения минимально необходимых полей формы
     * Проверяет корректность сохранения и отображения введенных данных
     */
    @Test
    void fillMinimalRequiredFieldsTest() {

        // Заполнение формы
        form.openPage()
            .setFirstName(testData.getFirstName())
            .setLastName(testData.getLastName())
            .selectGender(testData.getGender())
            .setPhoneNumber(testData.getPhoneNumber())
            .submit();

        // Проверка результатов
        results.shouldAppear()
            .shouldHaveText(testData.getFirstName() + " " + testData.getLastName())
            .shouldHaveText(testData.getGender())
            .shouldHaveText(testData.getPhoneNumber());
    }

    /**
     * Негативный тест - попытка отправки формы без номера телефона
     * Проверяет, что форма не может быть отправлена без обязательного поля
     */
    @Test
    void negativeTestWithoutPhoneTest() {

        // Заполнение формы
        form.openPage()
            .setFirstName(testData.getFirstName())
            .setLastName(testData.getLastName())
            .selectGender(testData.getGender())
            .submit();

        // Проверка, что результаты не отображаются
        results.shouldNotAppear();
    }
}
