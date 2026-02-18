package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class TestBase {

    @BeforeAll
    static void setUp() {
        // Базовые настройки
        Configuration.baseUrl = "https://www.priorbank.by";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

        // Настройки для локального запуска
        Configuration.browser = "chrome";
        Configuration.browserBinary = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";

        // Создаем ChromeOptions с настройками для имитации реального пользователя
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=SSLCommittedInterstitials");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-web-security");
        options.addArguments("--reduce-security-for-testing"); // временно для теста

        // Убираем признаки автоматизации
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Реальный user-agent
        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36");

        // Языковые настройки
        options.addArguments("--lang=ru");
        options.addArguments("--accept-lang=ru-RU,ru;q=0.9,en;q=0.8");

        // Дополнительные аргументы для стабильности
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--enable-cookies");
        options.addArguments("--enable-local-storage");

        // Принимаем insecure сертификаты
        options.setAcceptInsecureCerts(true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "enableFileUploads", true
            ));
        }

        // Устанавливаем capabilities
        Configuration.browserCapabilities = capabilities;

        // Таймауты
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 30000;
    }

    @BeforeAll
    static void preloadSSL() {
        try {
            java.net.URL url = new java.net.URL("https://www.priorbank.by");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            int responseCode = conn.getResponseCode();
            System.out.println("Предварительный SSL handshake: " + responseCode);
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Ошибка при предварительном SSL: " + e.getMessage());
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    public void removeAutomationFlags() {
        try {
            executeJavaScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
            executeJavaScript("Object.defineProperty(navigator, 'plugins', {get: () => [1, 2, 3, 4, 5]})");
            executeJavaScript("Object.defineProperty(navigator, 'languages', {get: () => ['ru-RU', 'ru']})");
            System.out.println("✓ Флаги автоматизации удалены");
        } catch (Exception e) {
            System.out.println("⚠ Ошибка при удалении флагов: " + e.getMessage());
        }
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
