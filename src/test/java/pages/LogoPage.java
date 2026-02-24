package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$;

public class LogoPage {
    private final static SelenideElement logo = $(".main-logo__image");
    private final static String EXPECTED_ALT = "logo";
    private final static String EXPECTED_SRC_PATTERN = ".*/documents/20143/225926/.*";
    private final static String EXPECTED_SRC_EXTENSION = ".*\\.svg.*";


    @Step("Проверяем видимость логотипа")
    public LogoPage logoShouldBeVisible() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Проверяем атрибуты логотипа")
    public LogoPage logoShouldHaveAttribute() {
        logo.shouldHave(attribute("alt", EXPECTED_ALT))
                .shouldHave(attributeMatching("src", EXPECTED_SRC_PATTERN))
                .shouldHave(attributeMatching("src", EXPECTED_SRC_EXTENSION));
        return this;
    }

    @Step("Проверяем наличие логотипа на странице")
    public LogoPage checkLogo() {
        logoShouldBeVisible();
        logoShouldHaveAttribute();
        return this;
    }
}
