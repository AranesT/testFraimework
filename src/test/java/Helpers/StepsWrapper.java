package Helpers;

import io.qameta.allure.Step;

import java.util.concurrent.Callable;

public class StepsWrapper {

    /**
     * Методы для обертки части кода в один шаг Аллюр
     *
     * @param name    - Имя отображаемого шага
     * @param actions - Тело шага (действия)
     */

    @Step("{0}")
    public static void $(String name, Runnable actions) {
        actions.run();
    }

    @Step("{0}")
    public static <T> T $$(String name, Callable<T> actions) {
        try {
            return actions.call();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
