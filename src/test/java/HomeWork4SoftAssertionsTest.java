import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.io.IOException;
import java.util.Properties;

/**
 * Тест для проверки наличия примера JUnit5 на странице SoftAssertions
 * требует Java 17+ для поддержки text blocks
 */
public class HomeWork4SoftAssertionsTest {
    private static final Logger logger = LoggerFactory.getLogger(HomeWork4SoftAssertionsTest.class);

    static {
        // Явно загружаем настройки из файла
        try {
            Properties properties = new Properties();
            properties.load(HomeWork4SoftAssertionsTest.class.getClassLoader().getResourceAsStream("selenide.properties"));
            properties.forEach((key, value) -> System.setProperty("selenide." + key, value.toString()));
            logger.info("Настройки Selenide загружены из selenide.properties");
        } catch (IOException e) {
            logger.error("Ошибка при загрузке настроек из selenide.properties", e);
        }
    }

    @BeforeAll
    static void beforeAll() {
        logger.info("Инициализация тестового класса");
        logger.debug("Текущий baseUrl: {}", Configuration.baseUrl);
        logger.debug("Браузер: {}", Configuration.browser);
        logger.debug("Размер окна: {}", Configuration.browserSize);
        logger.debug("Таймаут: {}", Configuration.timeout);
    }

    @Test
    void softAssertionsPageShouldContainJUnit5ExampleTest() {
        logger.info("Начало выполнения теста softAssertionsPageShouldContainJUnit5ExampleTest");
        
        // Шаг 1: Открываем страницу репозитория Selenide
        logger.debug("Открываем страницу репозитория Selenide");
        open("selenide/selenide");

        // Шаг 2: Переходим во вкладку Wiki
        logger.debug("Переходим во вкладку Wiki");
        $("#wiki-tab").shouldBe(visible).click();

        // Шаг 3: Нажимаем "Show more pages" если кнопка видна
        logger.debug("Нажимаем кнопку 'Show more pages'");
        $(".js-wiki-more-pages-link").shouldBe(visible).click();

        // Шаг 4: Проверяем наличие страницы SoftAssertions
        logger.debug("Проверяем наличие страницы SoftAssertions");
        $("#wiki-pages-box").shouldBe(visible).shouldHave(text("SoftAssertions"));

        // Шаг 5: Переходим на страницу SoftAssertions
        logger.debug("Переходим на страницу SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible).click();

        // Шаг 6: Проверяем наличие примера использования JUnit5
        logger.debug("Проверяем наличие примера использования JUnit5");
        $("#wiki-body").shouldBe(visible).shouldHave(text("Using JUnit5 extend test class"));

        // Шаг 7: Проверяем точное соответствие блока кода с примером JUnit5
        logger.debug("Проверяем точное соответствие блока кода с примером JUnit5");
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
            
        logger.info("Тест softAssertionsPageShouldContainJUnit5ExampleTest успешно завершен");
    }
}