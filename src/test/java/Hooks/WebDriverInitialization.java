package Hooks;

import Helpers.AllureHelper;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverInitialization {

    private static final String webDriverLocation = Helpers.Configuration.getConfigurationValue("webdriverlocationLOCAL");

    @BeforeAll
    static void setDriverProps() throws MalformedURLException {
        if (!StringUtils.isBlank(Helpers.Configuration.getConfigurationValue("selenoidUrl"))) {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("browserName", "firefox");
            options.setCapability("browserVersion", "88.0");
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            driver.navigate().to("https://bo.vtb24.ru/login");
        } else {
            System.setProperty("webdriver.chrome.driver", webDriverLocation);
            System.setProperty("selenide.browser", "Chrome");
            Configuration.startMaximized = true;
            Configuration.timeout = 15000;
        }
    }

    @BeforeAll
    static void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));
    }

    @Step("Завершение автотеста")
    @AfterEach
    void end() {
        if (StringUtils.isBlank(Helpers.Configuration.getConfigurationValue("selenoidUrl"))) {
            AllureHelper.takeScreenshot("Завершение автотеста");
            WebDriverRunner.closeWindow();
            WebDriverRunner.closeWebDriver();
        }
    }
}

