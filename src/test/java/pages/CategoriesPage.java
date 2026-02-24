package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoriesPage {

    private SelenideElement container = $("#tabContainer");
    private ElementsCollection visibleCategoryItems = $$(".main-menu-nav__item." +
            "gds-nav-tabs__list-item");
    private ElementsCollection allCategoryLinks = $$(".gds-nav-tabs__link");
    private SelenideElement moreButton = $("#more");
    private SelenideElement moreDropdown = $(".more-items-content-wrapper");

    @Step("Проверяем отображение категорий")
    public CategoriesPage shouldHaveVisibleCategory(List<String> categories) {
        categories.forEach(
                category ->
                        $(byText(category)).shouldBe(visible));
        return this;
    }

    @Step("Проверяем отображение в выпадающем списке категорий")
    public CategoriesPage shouldHaveDropdownCategory(List<String> categories) {
        clickMoreButton();
        moreDropdown.shouldBe(visible);

        categories.forEach(
                category ->
                        moreDropdown.shouldHave(text(category))
        );
        return this;
    }

    @Step("Проверяем отображение кнопки")
    public CategoriesPage shouldHaveMoreButton(String value) {
        moreButton.shouldBe(visible)
                .shouldHave(text(value));
        return this;
    }

    @Step("Нажимаем на кнопку")
    public CategoriesPage clickMoreButton() {
        moreButton.click();
        return this;
    }

    @Step("Проверяем видимость выпадающего списка")
    public CategoriesPage shouldShowDropdown() {
        moreDropdown.shouldBe(visible);
        return this;
    }

}


