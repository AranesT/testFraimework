package Helpers;

import Hooks.WebUI.WebDriverInitialization;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class AllureHelper extends WebDriverInitialization {

    private static final Logger log = LoggerFactory.getLogger(AllureHelper.class);

    public static void takeScreenshot(String screenName) {
        byte[] screen = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(screenName, new ByteArrayInputStream(screen));
    }

    public static void logToAllure(String contName, String value) {
        Allure.addAttachment(contName, value);
        log.info(contName);
        log.info(value);
    }

}
