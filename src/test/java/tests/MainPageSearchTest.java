package tests;


import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;
import testdata.SearchData;

@Epic("Главная страница PriorBank")
@Feature("Поиск по сайту")
@DisplayName("Тесты по поиску с главной страницы")
@Tag("search")
public class MainPageSearchTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    SearchData searchData = new SearchData();


    @Test
    @DisplayName("На главной странице отображается кнопка поиска")
    @Tags({@Tag("web"), @Tag("Positive")})
    void searchButtonShouldBeVisibleOnMainPageTest() {
        mainPage.openPage();
        searchPage.searchButtonShouldBeVisible();
    }


    @Test
    @DisplayName("На главной странице отображается строка поиска")
    @Tag("web")
    void searchInputShouldBeVisibleOnMainPageTest() {
        mainPage.openPage();
        searchPage.clickSearchButton();
        searchPage.searchInputShouldBeVisible();
    }


    @Test
    @DisplayName("В строке поиска отображается подсказка")
    @Tags({@Tag("web"), @Tag("Positive")})
    void placeholderOnSearchInputShouldBeVisibleTest() {
        mainPage.openPage();
        searchPage.clickSearchButton();
        searchPage.searchPlaceholderShouldBeVisible();
    }

    @Test
    @DisplayName("В строке поиска отображается корректный текст подсказки")
    @Tags({@Tag("web"), @Tag("Positive")})
    void placeholderShouldContainsTextTest() {
        mainPage.openPage();
        searchPage.clickSearchButton();
        searchPage.searchPlaceholderShouldHaveText(searchData.placeholderText);
    }

    @Test
    @DisplayName("В выпадающем списке отображается искомый запрос")
    @Tags({@Tag("web"), @Tag("Positive")})
    void searchSelectListShouldDisplayEnteredTextTest() {
        mainPage.openPage();
        searchPage.clickSearchButton();
        searchPage.setSearchInput(searchData.searchCredit);
        searchPage.searchSelectListShouldBeVisible();
        searchPage.searchSelectListShouldContainsResult(searchData.searchCredit);
    }
}
