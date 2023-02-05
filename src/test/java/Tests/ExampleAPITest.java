package Tests;

import Steps.Api.ApiSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static Helpers.AssertionsWrapper.assertEquals;

public class ExampleAPITest {

    /**
     * \
     * ПРИМЕР РЕАЛИЗАЦИИ КЛАССА С ТЕСТАМИ ДЛЯ BACK
     */

    @Test
    @Tag("API")
    @DisplayName("API successful test")
    public void successfulTest() {
        HashMap<String, String> response = new ApiSteps().findCharacterInfo("2");
        assertEquals("Morty Smith",
                response.get("name"),
                "Ошибка! Ожидаемое имя персонажа не совпадает с действительным!");
    }

    @Test
    @Tag("API")
    @DisplayName("API failed test")
    public void failedTest() {
        HashMap<String, String> response = new ApiSteps().findCharacterInfo("3");
        assertEquals("Morty Smith",
                response.get("name"),
                "Ошибка! Ожидаемое имя персонажа не совпадает с действительным!");
    }
}
