package tests;


import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CategoriesPage;
import pages.MainPage;
import testdata.CategoriesData;

@Epic("Главная страница PriorBank")
@Feature("Категории услуг")
@DisplayName("Тесты категорий на главной странице")
@Tag("categories")
public class MainPageCategoriesTest extends TestBase {

    MainPage mainPage = new MainPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    CategoriesData categoriesData = new CategoriesData();

    @Test
    @DisplayName("На главной странице отображаются основные категории услуг")
    @Tags({@Tag("web"), @Tag("Regression"), @Tag("Positive")})
    void allMainCategoriesShouldBeVisibleTest() {

        mainPage.openPage();
        categoriesPage.shouldHaveVisibleCategory(
                CategoriesData.MAIN_VISIBLE_CATEGORIES);
    }

    @Test
    @DisplayName("Кнопка 'Еще' должна отображаться")
    @Tags({@Tag("web"), @Tag("Regression"), @Tag("Positive")})
    void moreButtonShouldBeVisibleTest() {
        mainPage.openPage();
        categoriesPage.shouldHaveMoreButton(categoriesData.buttonName);
    }


    @Test
    @DisplayName("Dropdown должен содержать скрытые категории")
    @Tags({@Tag("web"), @Tag("Regression"), @Tag("Positive")})
    void dropDownCategoriesShouldBeVisibleTest() {
        mainPage.openPage();
        categoriesPage
                .shouldHaveMoreButton(categoriesData.buttonName)
                .clickMoreButton()
                .shouldShowDropdown();
        categoriesPage.shouldHaveDropdownCategory(
                CategoriesData.DROPDOWN_CATEGORIES);
    }

    @Test
    @Tags({@Tag("web"), @Tag("Regression"), @Tag("Positive")})
    void allCategoriesShouldBeOnMainPageTest() {
        mainPage.openPage();
        categoriesPage.shouldHaveVisibleCategory(
                CategoriesData.ALL_CATEGORIES);
    }

}
