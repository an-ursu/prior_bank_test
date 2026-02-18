package pages.main;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchButton = $(".button__search"),
            searchInput = $("#searchTopFieldRus"),
            searchSelectList = $(".search-portlet__tooltips-container"),
            searchPlaceholder = $("#searchTopFieldRus"),
            searchClose = $(".search__close-icon-i");

    public SearchPage searchButtonShouldBeVisible() {
        searchButton.shouldBe(visible);
        return this;
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public SearchPage searchInputShouldBeVisible() {
        searchInput.shouldBe(visible);
        return this;
    }

    public  SearchPage setSearchInput(String value) {
        searchInput.setValue(value);
        return this;
    }


    public SearchPage searchPlaceholderShouldBeVisible() {
        searchInput.shouldBe(visible);
        return this;
    }


    public SearchPage searchPlaceholderShouldHaveText(String value) {
        searchInput.shouldHave(attribute("placeholder",value));
        return this;
    }

    public SearchPage searchCloseButtonShouldBeVisible() {
        searchClose.shouldBe(visible);
        return this;
    }

    public SearchPage clickSearchCloseButton() {
        searchClose.click();
        return this;
    }

    public SearchPage searchSelectListShouldBeVisible() {
        searchSelectList.shouldBe(visible);
        return this;
    }

    public SearchPage searchSelectListShouldContainsResult(String value) {
        searchSelectList.shouldHave(text(value));
        return this;
    }

}


