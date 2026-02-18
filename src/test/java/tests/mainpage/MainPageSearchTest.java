package tests.mainpage;


import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.main.MainPage;
import pages.main.SearchPage;
import testdata.SearchData;

import static io.qameta.allure.Allure.step;

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
    @Tag("web")
    @Tag("Positive")
    void searchButtonShouldBeVisibleOnMainPage() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Проверить отображение кнопки поиска на главной странице", () -> {
            searchPage.searchButtonShouldBeVisible();
        });

    }


    @Test
    @DisplayName("На главной странице отображается строка поиска")
    @Tag("web")
    void searchInputShouldBeVisibleOnMainPage() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать на главной странице на кнопку поиска", () -> {
            searchPage.clickSearchButton();
        });

        step("Проверить отображение строки поиска", () -> {
            searchPage.searchInputShouldBeVisible();
        });

    }


    @Test
    @DisplayName("В строке поиска отображается подсказка")
    @Tag("web")
    @Tag("Positive")
    void placeholderOnSearchInputShouldBeVisible() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать на главной странице на кнопку поиска", () -> {
            searchPage.clickSearchButton();
        });

        step("Проверить отображение подсказки в строке поиска", () -> {
            searchPage.searchPlaceholderShouldBeVisible();
        });
    }

    @Test
    @DisplayName("В строке поиска отображается корректный текст подсказки")
    @Tag("web")
    @Tag("Positive")
    void placeholderShouldContainsText() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать на главной странице на кнопку поиска", () -> {
            searchPage.clickSearchButton();
        });

        step("Проверить отображение подсказки в поле ввода", () -> {
            searchPage.searchPlaceholderShouldHaveText(searchData.placeholderText);
        });

    }

    @Test
    @DisplayName("В выпадающем списке отображается искомый запрос")
    @Tag("web")
    @Tag("Positive")
    void searchSelectListShouldDisplayEnteredText() {
        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать на главной странице на кнопку поиска", () -> {
            searchPage.clickSearchButton();
        });

        step("Ввести текст поиска", () -> {
            searchPage.setSearchInput(searchData.searchCredit);
        });

        step("Проверить отображение выпадающего списка", () -> {
            searchPage.searchSelectListShouldBeVisible();
        });

        step("Проверить в выпадающем списке отображение текста из введенного запроса", () -> {
            searchPage.searchSelectListShouldContainsResult(searchData.searchCredit);
        });

    }

}
