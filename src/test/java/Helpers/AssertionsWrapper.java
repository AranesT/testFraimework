package Helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class AssertionsWrapper {

    @Step("Проверка соответствия значений. Ожидаемое значение: {expectedValue}, реальное значение: {realValue}")
    public static <T> void assertEquals(T expectedValue, T realValue, String message) {
        Assertions.assertEquals(expectedValue,
                realValue,
                message);

    }
}
