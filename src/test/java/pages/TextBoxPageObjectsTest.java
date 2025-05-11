package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TextBoxPageObjectsTest {
    private final SelenideElement userName = $("#userName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement permanentAddress = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement output = $("#output");

    public void openPage() {
        open("/text-box");
    }

    public void setUserName(String value) {
        userName.setValue(value);
    }

    public void setEmail(String value) {
        userEmail.setValue(value);
    }

    public void setAddress(String address) {
        currentAddress.setValue(address);
    }

    public void setPermanentAddress(String address) {
        permanentAddress.setValue(address);
    }

    public void submit() {
        submitButton.scrollIntoView(true);
        submitButton.click();
    }

    public void shouldAppear() {
        output.should(appear);
    }

    public void shouldHaveText(String text) {
        output.shouldHave(text(text));
    }
    public void checkName(String name) {
        output.$("#name").shouldHave(text(name));
    }
    
    public void checkEmail(String email) {
        output.$("#email").shouldHave(text(email));
    }
    
    public void checkCurrentAddress(String address) {
        output.$("#currentAddress").shouldHave(text(address));
    }
    
    public void checkPermanentAddress(String address) {
        output.$("#permanentAddress").shouldHave(text(address));
    }
} 