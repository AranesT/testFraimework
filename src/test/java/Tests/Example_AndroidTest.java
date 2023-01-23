package Tests;

import Hooks.Android.AndroidDriverInitialization;
import org.junit.jupiter.api.Test;

public class Example_AndroidTest extends AndroidDriverInitialization {

    /**
     * \
     * ПРИМЕР РЕАЛИЗАЦИИ КЛАССА С ТЕСТАМИ ДЛЯ АНДРОЙД
     * Стек - андройдСтудио, аппиус-сервер, аппиум-инспектр
     */

    @Test
    public void sampleTest() {
        driver.findElementById("com.google.android.dialer:id/dialpad_fab").click();
        driver.findElementById("com.google.android.dialer:id/one").click();
        driver.findElementById("com.google.android.dialer:id/two").click();
        driver.findElementById("com.google.android.dialer:id/nine");
    }

}
