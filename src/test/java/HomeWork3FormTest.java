import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

 public class HomeWork3FormTest {

    @BeforeAll
    static void beforeAll() {
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
        $("#genterWrapper").$(byText("Female")).click();

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
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        // Загрузка изображения
        $("#uploadPicture").uploadFromClasspath("img/sample.jpg");

        // Адрес
        $("#currentAddress").setValue("1234 Main Street, Moscow");

        // Выбор штата и города
        $("#state").scrollTo().click();
        $("#react-select-3-input").setValue("Rajasthan").pressEnter(); // Rajasthan
        $("#city").click();
        $("#react-select-4-input").setValue("Jaipur").pressEnter(); // Jaipur

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
                text("1234 Main Street, Moscow"),
                text("Rajasthan Jaipur")
        );
    }
}
