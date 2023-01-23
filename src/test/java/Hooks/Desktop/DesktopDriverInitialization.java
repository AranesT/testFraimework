package Hooks.Desktop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DesktopDriverInitialization {

    String appName = "yourAppName";
    String processName = "yourAppProcessName";

    @BeforeEach
    public void before() {
        FlaniumDriverManager.initFlaniumDriver(appName, processName);
    }

    @AfterEach
    public void after() {
        FlaniumDriverManager.quitDriver();
    }
}
