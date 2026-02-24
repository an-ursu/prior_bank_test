package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Открываем страницу сайта")
    public MainPage openPage() {
        open("/main");
        return this;
    }

}
