import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Тест для проверки наличия примера JUnit5 на странице SoftAssertions
 * требует Java 17+ для поддержки text blocks
 */
public class HomeWork4SoftAssertions {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 10000;
    }

    @Test
    void softAssertionsPageShouldContainJUnit5ExampleTest() {
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

        // Шаг 7: Проверяем точное соответствие блока кода с примером JUnit5
        String expectedCode = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");

                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }
            }""";

        // Проверяем наличие и точное соответствие кода
        $(".markdown-body")
            .$$("pre")
            .findBy(text("SoftAssertsExtension"))
            .shouldHave(exactText(expectedCode));
    }
}