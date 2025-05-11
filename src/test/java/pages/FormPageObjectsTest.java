package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPageObjectsTest {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement submitButton = $("#submit");

    public void openPage() {
        open("/automation-practice-form");
    }

    public void setFirstName(String value) {
        firstName.setValue(value);
    }

    public void setLastName(String value) {
        lastName.setValue(value);
    }

    public void setEmail(String value) {
        userEmail.setValue(value);
    }

    public void selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
    }

    public void setPhoneNumber(String value) {
        userNumber.setValue(value);
    }

    public void setDateOfBirth(String month, String year, String day) {
        dateOfBirthInput.scrollIntoView(true);
        dateOfBirthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }

    public void setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
    }

    public void selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
    }

    public void uploadPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
    }

    public void setAddress(String address) {
        currentAddress.setValue(address);
    }

    public void selectState(String stateName) {
        state.scrollTo().click();
        $("#react-select-3-input").setValue(stateName).pressEnter();
    }

    public void selectCity(String cityName) {
        city.click();
        $("#react-select-4-input").setValue(cityName).pressEnter();
    }

    public void submit() {
        submitButton.scrollIntoView(true);
        submitButton.click();
    }
} 