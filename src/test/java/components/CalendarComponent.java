package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement daySelect = $(".react-datepicker__month");

    public CalendarComponent setDate(String month, String year, String day) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        daySelect.$(byText(day)).click();
        return this;
    }
} 