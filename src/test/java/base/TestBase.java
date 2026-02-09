package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.priorbank.by";
        Configuration.remote = System.getProperty("remote");
        Configuration.pageLoadStrategy = "eager";

        Configuration.browser = System.getProperty("BROWSER", "chrome");
        Configuration.browserVersion = System.getProperty("BROWSER_VERSION", "128.0");
        Configuration.browserSize = System.getProperty("BROWSER_SIZE", "1920x1080");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true,
                "enableFileUploads", true
        ));

        capabilities.setCapability("browserName", "chrome");

        HashMap<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("args", Arrays.asList(
                "--disable-blink-features=AutomationControlled",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36"
        ));

        chromeOptions.put("excludeSwitches", Collections.singletonList("enable-automation"));

        capabilities.setCapability("goog:chromeOptions", chromeOptions);
        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
