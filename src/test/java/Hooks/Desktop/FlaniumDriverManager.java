package Hooks.Desktop;

import FlaNium.WinAPI.webdriver.DesktopOptions;
import FlaNium.WinAPI.webdriver.FlaNiumDriver;
import FlaNium.WinAPI.webdriver.FlaNiumDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FlaniumDriverManager {

    static String driverDesktopPath = "yourPath";
    static int driverDesktopPort = 9999;
    static WebDriverWait driverWait;
    private static FlaNiumDriver driverDesktop;

    public static FlaNiumDriver getDriverDesktop() {
        return driverDesktop;
    }

    public static FlaNiumDriverService initService() {
        return new FlaNiumDriverService.Builder()
                .usingDriverExecutable(new File(driverDesktopPath))
                .usingPort(driverDesktopPort)
                .withVerbose(false)
                .withSilent(false)
                .buildDesktopService();
    }

    public static DesktopOptions initOptions(String appPath, String processName) {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(new File(appPath).getAbsolutePath());
        options.setLaunchDelay(5);
        options.setDebugConnectToRunningApp(false);
        options.setProcessName(processName);
        return options;
    }

    public static void initFlaniumDriver(String appPath, String processName) {
        driverDesktop = new FlaNiumDriver(initService(), initOptions(appPath, processName));
        driverWait = new WebDriverWait(driverDesktop, 180);
    }

    public static void quitDriver() {
        if (driverDesktop != null) {
            driverDesktop.quit();
            driverDesktop = null;
        }
    }
}
