package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {

    @Step("Проверяем появление модального окна")
    public RegistrationResultModal verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    @Step("Проверяем содержимое модального окна - в поле {key} лежит значение {value}")
    public RegistrationResultModal verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}