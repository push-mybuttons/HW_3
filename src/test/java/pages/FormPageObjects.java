package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class FormPageObjects {
    // Элементы формы
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final CalendarComponent calendar = new CalendarComponent();

    public FormPageObjects openPage() {
        open("/automation-practice-form");
        return this;
    }

    public FormPageObjects setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public FormPageObjects setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public FormPageObjects setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public FormPageObjects selectGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public FormPageObjects setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public FormPageObjects setDateOfBirth(String month, String year, String day) {
        dateOfBirthInput.click();
        calendar.setDate(month, year, day);
        return this;
    }

    public FormPageObjects setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public FormPageObjects selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public FormPageObjects uploadPicture(String picturePath) {
        pictureUpload.uploadFromClasspath(picturePath);
        return this;
    }

    public FormPageObjects setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public FormPageObjects selectState(String state) {
        stateWrapper.scrollIntoView(true);
        stateWrapper.$(byText("Select State")).click();
        stateWrapper.$(byText(state)).click();
        return this;
    }

    public FormPageObjects selectCity(String city) {
        stateWrapper.$(byText("Select City")).click();
        stateWrapper.$(byText(city)).click();
        return this;
    }

    public void submit() {
        submitButton.scrollIntoView(true);
        submitButton.click();
    }
} 