package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTable {
    private final SelenideElement table = $(".table-responsive");
    private final SelenideElement modal = $(".modal-content");

    public void shouldAppear() {
        modal.should(appear);
    }

    public void shouldNotAppear() {
        modal.shouldNot(appear);
    }

    public void shouldHaveText(String text) {
        table.shouldHave(text(text));
    }
} 