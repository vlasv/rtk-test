package tests;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

@DisplayName("Сьют тестов ВК видео")
public class VkTests extends TestBase {

    @Test
    @DisplayName("#1.Успешный запуск проигрывания видео ВК видео")
    void playVideoTest() throws InterruptedException {
        //Переходим по диплинку на видео
        SelenideAppium.openAndroidDeepLink("https://vkvideo.ru/video-201326578_456256781", "com.vk.vkvideo");
        //Ожидаем, что видео прогрузилось, может долго прогружаться и не прогрузиться в итоге
        Selenide.sleep(20000);

        //Сравниваем значение времени на поисковой линейке, чтобы время второго маркера было позднее, чем первого.
        $(By.id("com.vk.vkvideo:id/playerContainer")).tap();
        double firstVideoPlayStamp = Double.parseDouble($(By.id("com.vk.vkvideo:id/seek_bar")).getText());
        //Ожидаем, что интерфейс плеера пропадёт
        Selenide.sleep(20000);

        $(By.id("com.vk.vkvideo:id/video_display")).tap();
        double secondVideoPlayStamp = Double.parseDouble($(By.id("com.vk.vkvideo:id/seek_bar")).getText());
        Assertions.assertTrue(secondVideoPlayStamp > firstVideoPlayStamp, "Видео не воспроизводится");
    }
}
