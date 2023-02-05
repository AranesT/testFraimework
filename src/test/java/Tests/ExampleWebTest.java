package Tests;

import Hooks.WebDriverInitialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ExampleWebTest extends WebDriverInitialization {

    /**
     * \
     * ПРИМЕР РЕАЛИЗАЦИИ КЛАССА С ТЕСТАМИ ДЛЯ UI
     */

    Steps.Google.MainPageSteps googleMainPageSteps = new Steps.Google.MainPageSteps();
    Steps.Yandex.MainPageSteps yandexMainPageSteps = new Steps.Yandex.MainPageSteps();

    @Test
    @Tag("UI")
    @DisplayName("Google-тест")
    public void GoogleTest() {
        googleMainPageSteps.searchGoogle("QA");
    }

    @Test
    @Tag("UI")
    @DisplayName("Yandex-тест")
    public void YandexTest() {
        yandexMainPageSteps.searchYandex("QA");
    }

}
