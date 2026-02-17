package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import drivers.MyAndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    // Путь к adb к локальному EmulatorManager
    static String adbPath = "C:\\Users\\vladi\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";

    @BeforeAll
    public static void setUp() {
        Configuration.browser = MyAndroidDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        SelenideAppium.launchApp();
    }

    @BeforeEach
    public void beforeEach() {
//        open();
    }

    @AfterEach
    public void afterEach() {
        clearAppDataDirectly("com.vk.vkvideo");
        clearAppDataDirectly("com.ilyin.alchemy");
    }

    @AfterAll
    static public void setDown() {
        clearAppDataDirectly("com.vk.vkvideo");
        clearAppDataDirectly("com.ilyin.alchemy");
        Selenide.closeWebDriver();
    }

    //Очистка состояния приложения
    static private void clearAppDataDirectly(String appPackage) {
        try {
            Process process = Runtime.getRuntime().exec(adbPath + " shell pm clear " + appPackage);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("App data of app : \"" + appPackage + "\" was deleted with ADB.");
            } else {
                System.err.println("Error ADB, code: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
