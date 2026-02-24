package tests;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.LogoPage;
import pages.MainPage;

@Epic("Главная страница PriorBank")
@Feature("Логотип")
@DisplayName("Тесты по логотипу")
@Tag("logo")
public class MainPageLogoTest extends TestBase {

    MainPage mainPage = new MainPage();
    LogoPage logoPage = new LogoPage();

    @Test
    @DisplayName("Логотип банка должен отображаться на главной странице")
    @Tags({@Tag("web"), @Tag("Regression"), @Tag("Positive")})
    void logoOnMainPageShouldBeVisibleTest() {
        mainPage.openPage();
        logoPage.checkLogo();
    }
}

