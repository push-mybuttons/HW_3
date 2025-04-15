import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

 public class HomeWork3FormTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillTheFormTest() {
        open("/automation-practice-form");

        // Заполнение текстовых полей
        $("#firstName").setValue("Mariia");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("mariia@example.com");

        // Пол
        $("label[for='gender-radio-2']").click();

        // Номер телефона
        $("#userNumber").setValue("9123456789");

        // Дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--015").click();

        // Предметы
        $("#subjectsInput").setValue("English").pressEnter();

        // Хобби
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();

        // Загрузка изображения
        $("#uploadPicture").uploadFromClasspath("img/sample.jpg");

        // Адрес
        $("#currentAddress").setValue("123 Main Street, Moscow");

        // Выбор штата и города
        $("#state").scrollTo().click();
        $("#react-select-3-option-0").click(); // NCR
        $("#city").click();
        $("#react-select-4-option-1").click(); // Gurgaon

        // Отправка формы
        $("#submit").click();

        // Проверка результата
        $(".modal-content").should(appear);
        $(".table-responsive").shouldHave(
                text("Mariia Ivanova"),
                text("mariia@example.com"),
                text("Female"),
                text("9123456789"),
                text("15 May,1990"),
                text("English"),
                text("Sports, Music"),
                text("sample.jpg"),
                text("123 Main Street, Moscow"),
                text("NCR Gurgaon")
        );
    }
}
