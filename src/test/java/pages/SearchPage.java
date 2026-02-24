package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchButton = $(".button__search"),
            searchInput = $("#searchTopFieldRus"),
            searchSelectList = $(".search-portlet__tooltips-container"),
            searchPlaceholder = $("#searchTopFieldRus"),
            searchClose = $(".search__close-icon-i");

    @Step("Проверяем видимость кнопки поиска")
    public SearchPage searchButtonShouldBeVisible() {
        searchButton.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем на кнопку поиска")
    public SearchPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Проверяем видимость строки поиска")
    public SearchPage searchInputShouldBeVisible() {
        searchInput.shouldBe(visible);
        return this;
    }

    @Step("Вносим значения")
    public SearchPage setSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }


    @Step("Проверяем видимость подсказки")
    public SearchPage searchPlaceholderShouldBeVisible() {
        searchInput.shouldBe(visible);
        return this;
    }


    @Step("Проверяем текст подсказки")
    public SearchPage searchPlaceholderShouldHaveText(String value) {
        searchInput.shouldHave(attribute("placeholder", value));
        return this;
    }

    @Step("Проверяем видимость выпадающего списка")
    public SearchPage searchSelectListShouldBeVisible() {
        searchSelectList.shouldBe(visible);
        return this;
    }

    @Step("Проверяем содержимое в выпадающем списке")
    public SearchPage searchSelectListShouldContainsResult(String value) {
        searchSelectList.shouldHave(text(value));
        return this;
    }

}


