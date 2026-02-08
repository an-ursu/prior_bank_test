package tests.mainpage;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

@Epic("Главная страница PriorBank")
@Feature("Логотип")
@DisplayName("Тесты по логотипу")
@Tag("All")
public class MainPageLogoTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Логотип банка должен отображаться на главной странице")
    @Tag("Regression")
    @Tag("web")
    @Tag("Positive")
    void logoOnMainPageShouldBeVisible() {
        step("Open page", () -> {
            mainPage.openPage();
        });

        step("Check logo on main page", () -> {
            mainPage.checkLogo();
        });
    }


}

