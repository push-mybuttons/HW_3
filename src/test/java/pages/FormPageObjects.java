package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormPageObjects {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final CalendarComponent calendar = new CalendarComponent();

    public FormPageObjects openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FormPageObjects setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public FormPageObjects setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public FormPageObjects setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public FormPageObjects selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public FormPageObjects setPhoneNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public FormPageObjects setDateOfBirth(String month, String year, String day) {
        calendar.setDate(month, year, day);
        return this;
    }

    public FormPageObjects setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public FormPageObjects selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
        }

    public FormPageObjects uploadPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    public FormPageObjects setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public FormPageObjects selectState(String stateName) {
        state.scrollTo().click();
        $("#react-select-3-input").setValue(stateName).pressEnter();
        return this;
    }

    public FormPageObjects selectCity(String cityName) {
        city.click();
        $("#react-select-4-input").setValue(cityName).pressEnter();
        return this;
    }

        public FormPageObjects submit() {
        submitButton.scrollIntoView(true);
        submitButton.click();
        return this;
    }
} 