import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import java.io.IOException;
import java.util.Properties;

public class HomeWork5HoverTest {
    private static final Logger logger = LoggerFactory.getLogger(HomeWork5HoverTest.class);

    static {
        // Явно загружаем настройки из файла
        try {
            Properties properties = new Properties();
            properties.load(HomeWork5HoverTest.class.getClassLoader().getResourceAsStream("selenide.properties"));
            properties.forEach((key, value) -> System.setProperty("selenide." + key, value.toString()));
            logger.info("Настройки Selenide загружены из selenide.properties");
        } catch (IOException e) {
            logger.error("Ошибка при загрузке настроек из selenide.properties", e);
        }
    }

    @BeforeAll
    static void beforeAll() {
        logger.info("Инициализация тестового класса");
        Configuration.browserSize = "1920x1080";
        logger.debug("Размер окна: {}", Configuration.browserSize);
    }

    @Test
    void hoverTest() {
        logger.info("Начало выполнения теста hoverTest");

        // Шаг 1: Открываем главную страницу GitHub
        logger.debug("Открываем главную страницу GitHub");
        open("https://github.com");

        // Шаг 2: Находим и наводим курсор на Solutions в главном меню
        logger.debug("Находим и наводим курсор на 'Solutions' в главном меню");
        $$(".HeaderMenu-link").findBy(text("Solutions")).shouldBe(visible).hover();

        // Явно ждём, пока дропдаун станет НЕ скрытым
        $(".HeaderMenu-dropdown").should(not(attribute("hidden")));
        
        // Шаг 4: Находим и кликаем на Enterprises
        logger.debug("Кликаем на 'Enterprises'");
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).shouldBe(visible).click();

        // Шаг 5: Проверяем заголовок страницы
        logger.debug("Проверяем заголовок страницы");
        $(".enterprise-hero").shouldBe(visible)
                .shouldHave(text("The AI-powered developer platform"));
        logger.info("Тест успешно завершен");
    }
}