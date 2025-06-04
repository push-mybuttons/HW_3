package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTable {
    private final SelenideElement table = $(".table-responsive");
    private final SelenideElement modal = $(".modal-content");

    public ResultsTable shouldAppear() {
        modal.should(appear);
        return this;
    }

    public ResultsTable shouldNotAppear() {
        modal.shouldNot(appear);
        return this;
    }

        public ResultsTable shouldHaveText(String text) {
        table.shouldHave(text(text));
        return this;
    }
} 