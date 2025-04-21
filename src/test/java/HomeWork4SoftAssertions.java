import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWork4SoftAssertions {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 10000;

    }

    @Test
    void softAssertionsPageShouldContainJUnit5Example() {
        // Шаг 1: Открываем страницу репозитория Selenide
        open("/selenide/selenide");

        // Шаг 2: Переходим во вкладку Wiki
        $("#wiki-tab").shouldBe(visible).click();

        // Шаг 3: Нажимаем "Show more pages" если кнопка видна
        $(".js-wiki-more-pages-link").shouldBe(visible).click();

        // Шаг 4: Проверяем наличие страницы SoftAssertions
        $("#wiki-pages-box").shouldBe(visible).shouldHave(text("SoftAssertions"));

        // Шаг 5: Переходим на страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible).click();

        // Шаг 6: Проверяем наличие примера использования JUnit5
        $("#wiki-body").shouldBe(visible).shouldHave(text("Using JUnit5 extend test class"));

        // Шаг 7: Проверяем наличие блока кода с примером JUnit5 в соответствующей секции
        $(".markdown-body")
            .$$("pre")
            .findBy(text("SoftAssertsExtension"))
            .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"))
            .shouldHave(text("class Tests"))
            .shouldHave(text("Configuration.assertionMode = SOFT;"));
    }
}