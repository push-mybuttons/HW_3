import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPageObjects;


public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillTheTextBoxTest() {
        TextBoxPageObjects form = new TextBoxPageObjects();

        form.openPage();
        form.setUserName("Mariia Ivanova");
        form.setEmail("mariia@example.com");
        form.setAddress("1234 Main Street, Moscow");
        form.setPermanentAddress("1234 Permanent Street, Moscow");
        form.submit();
        form.shouldAppear();
        form.checkName("Name:Mariia Ivanova");
        form.checkEmail("Email:mariia@example.com");
        form.checkCurrentAddress("Current Address :1234 Main Street, Moscow");
        form.checkPermanentAddress("Permananet Address :1234 Permanent Street, Moscow");
    }
}