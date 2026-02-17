package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MyAndroidDriver implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options(capabilities);

        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel_4");
        options.setPlatformName("Android");
        options.setPlatformVersion("11.0");

//        options.setAppPackage("com.vk.vkvideo");
//        options.setAppActivity("com.vk.video.screens.main.MainActivity");

        options.clearSystemFiles();
        options.setNoReset(false);
        options.setFullReset(false);

        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

//    @NonNull
//    @Override
//    public WebDriver createDriver(@NonNull Capabilities capabilities) {
//        MutableCapabilities caps = new MutableCapabilities(capabilities);
//
//        caps.setCapability("automationName", "Appium");
//        caps.setCapability("deviceName", "Pixel_4");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "11.0");
//
//        caps.setCapability("appPackage", "com.vk.vkvideo");
//        caps.setCapability("appActivity", "com.vk.video.screens.main.MainActivity");
//
//        caps.setCapability("noReset", "false");
//        caps.setCapability("fullReset", "false");
//
//        try {
//            return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
