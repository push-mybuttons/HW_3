package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");

    public void setDate(String month, String year, String day) {
        dateOfBirthInput.scrollIntoView(true);
        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }
} 