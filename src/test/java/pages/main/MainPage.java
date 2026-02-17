package pages.main;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage openPage() {
        open("/main");
        return this;
    }

}
