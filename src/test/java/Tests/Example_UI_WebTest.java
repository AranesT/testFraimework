package Tests;

import Hooks.WebUI.WebDriverInitialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Example_UI_WebTest extends WebDriverInitialization {

    /**
     * \
     * ПРИМЕР РЕАЛИЗАЦИИ КЛАССА С ТЕСТАМИ ДЛЯ WEB
     */

    Steps.Google.MainPageSteps googleMainPageSteps = new Steps.Google.MainPageSteps();
    Steps.Yandex.MainPageSteps yandexMainPageSteps = new Steps.Yandex.MainPageSteps();

    @Test
    @Tag("Google")
    @DisplayName("Google-тест")
    public void Google_Test() {
        googleMainPageSteps.searchGoogle("QA");
    }

    @Test
    @Tag("Yandex")
    @DisplayName("Yandex-тест")
    public void Yandex_Test() {
        yandexMainPageSteps.searchYandex("QA");
    }

}
