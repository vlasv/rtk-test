package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

public class AlchemyTests extends TestBase {

    @Test
    @DisplayName("#1.Проверка получения подсказок за просмотр рекламы")
    void receiveTipsForAD() {
        SelenideAppium.activateApp("com.ilyin.alchemy");

        $x("//android.widget.TextView[@text=\"Играть\"]").tap();

        //Кнопка с дополнительными подсказками
        $x("//y2.f1/android.view.View/android.view.View/android.view.View/android.view" +
                ".View[1]/android.view.View[1]").tap();

        /*Нестабильное появление рекламы, может быть одна реклама или несколько, может вызывать активити гугл плея
        без нажатия на рекламу.
         */
        //Ждем кнопку с рекламой, чтобы наверняка появилась(долго прогружается, особенно на эмуляторе)
//        Selenide.sleep(40000);
        //Кнопка просмотра рекламы
//        $x("//android.widget.TextView[@text=\"Смотреть\"]").tap();
        //Ждем полного прохождения рекламы, чтобы наверняка появились кнопки закрытия
        //Может быть реклама около минуты, кнопки нестабильные, может быть множество вариантов в разных комбинациях
//        Selenide.sleep(60000);
//        $(By.id("m-playable-skip")).tap();
//        $(By.id("m-playable-close")).tap();

        //Можно забрать подсказку раз в 20 минут, чтобы не смотреть рекламу, так как появление рекламы не гарантировано
        $x("//android.widget.TextView[@text=\"Забрать\"]").tap();

        $x("//android.widget.TextView[@text=\"4\"]").shouldHave(exactText("4"));

        Selenide.sleep(5000);

    }

}
