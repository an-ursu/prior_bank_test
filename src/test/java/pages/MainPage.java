package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement logo = $(".main-logo__image");
    public final CategoriesComponents categories = new CategoriesComponents();

    public MainPage openPage() {
        open("/main");
        return this;
    }

    public MainPage checkLogo() {
        logo.shouldBe(visible)
                .shouldHave(attribute("alt", "logo"))
                .shouldHave(attributeMatching("src", ".*/documents/20143/225926/.*"))
                .shouldHave(attributeMatching("src", ".*\\.svg.*"));
        return this;
    }

    public static class CategoriesComponents {

        private final SelenideElement container = $("#tabContainer");
        private final ElementsCollection visibleCategoryItems = $$(".main-menu-nav__item." +
                "gds-nav-tabs__list-item");
        private final ElementsCollection allCategoryLinks = $$(".gds-nav-tabs__link");
        private final SelenideElement moreButton = $("#more");
        private final SelenideElement moreDropdown = $(".more-items-content-wrapper");

        public CategoriesComponents shouldBeVisible() {
            container.shouldBe(visible);
            return this;
        }

        public CategoriesComponents shouldHaveVisibleCategory(List<String> categories) {
            categories.forEach(
                    category ->
                            $(byText(category)).shouldBe(visible));
            return this;
        }

        public CategoriesComponents shouldHaveDropdownCategory(List<String> categories) {
            clickMoreButton();
            moreDropdown.shouldBe(visible);

            categories.forEach(
                    category ->
                            moreDropdown.shouldHave(text(category))
            );
            return this;
        }


        public CategoriesComponents shouldHaveMoreButton() {
            moreButton.shouldBe(visible)
                    .shouldHave(text("Еще"));
            return this;
        }

        public CategoriesComponents clickMoreButton() {
            moreButton.click();
            return this;
        }

        public CategoriesComponents hoverMoreButton() {
            moreButton.hover();
            return this;
        }

        public CategoriesComponents shouldShowDropdown() {
            moreDropdown.shouldBe(visible);
            return this;
        }

    }


}
