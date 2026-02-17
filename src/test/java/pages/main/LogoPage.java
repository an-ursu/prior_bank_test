package pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$;

public class LogoPage {
    private final static SelenideElement logo = $(".main-logo__image");
    private final static String EXPECTED_ALT = "logo";
    private final static String EXPECTED_SRC_PATTERN = ".*/documents/20143/225926/.*";
    private final static String EXPECTED_SRC_EXTENSION = ".*\\.svg.*";


    public LogoPage logoShouldBeVisible() {
        logo.shouldBe(visible);
        return this;
    }

    public LogoPage logoShouldHaveAttribute() {
        logo.shouldHave(attribute("alt", EXPECTED_ALT))
                .shouldHave(attributeMatching("src", EXPECTED_SRC_PATTERN))
                .shouldHave(attributeMatching("src", EXPECTED_SRC_EXTENSION));
        return this;
    }

    public LogoPage checkLogo() {
        logoShouldBeVisible();
        logoShouldHaveAttribute();
        return this;
    }
}
