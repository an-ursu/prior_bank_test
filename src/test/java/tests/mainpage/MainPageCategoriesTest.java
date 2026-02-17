package tests.mainpage;


import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.main.CategoriesPage;
import pages.main.MainPage;
import testdata.CategoriesData;

import static io.qameta.allure.Allure.step;

@Epic("Главная страница PriorBank")
@Feature("Категории услуг")
@DisplayName("Тесты категорий на главной странице")
@Tag("categories")
public class MainPageCategoriesTest extends TestBase {

    MainPage mainPage = new MainPage();
    CategoriesPage categoriesPage = new CategoriesPage();

    @Test
    @DisplayName("На главной странице отображаются основные категории услуг")
    @Tag("Regression")
    @Tag("web")
    @Tag("Positive")
    void allMainCategoriesShouldBeVisible() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Проверить отображение основных категорий услуг на главной странице", () -> {
            categoriesPage.shouldHaveVisibleCategory(
                    CategoriesData.MAIN_VISIBLE_CATEGORIES);
        });
    }

    @Test
    @DisplayName("Кнопка 'Еще' должна отображаться")
    @Tag("Positive")
    @Tag("web")
    void moreButtonShouldBeVisible() {

        step("Открыть станицу", () -> {
            mainPage.openPage();
        });

        step("Проверить отображение кнопки 'Еще'", () -> {
            categoriesPage.shouldHaveMoreButton();
        });
    }


    @Test
    @DisplayName("Dropdown должен содержать скрытые категории")
    @Tag("Regression")
    @Tag("web")
    @Tag("Positive")
    void dropDownCategoriesShouldBeVisible() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Открыть выпадающее меню", () -> {
            categoriesPage
                    .shouldHaveMoreButton()
                    .clickMoreButton()
                    .shouldShowDropdown();

        });

        step("Проверить отображение категорий услуг в выпадающем списке", () -> {
            categoriesPage.shouldHaveDropdownCategory(
                    CategoriesData.DROPDOWN_CATEGORIES);
        });
    }

    @Test
    @Tag("Regression")
    @Tag("web")
    @Tag("Positive")
    void allCategoriesShouldBeOnMainPage() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });

        step("Проверить отображение основных категорий услуг на главной странице", () -> {
            categoriesPage.shouldHaveVisibleCategory(
                    CategoriesData.ALL_CATEGORIES);
        });
    }

}
