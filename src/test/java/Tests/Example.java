package Tests;

import Hooks.WebDriverInitialization;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class Example extends WebDriverInitialization {

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

    @Test
    @Tag("SelenoidTest")
    @DisplayName("Selenoid-test")
    public void selenoidTest(){
        open("https://bo.vtb24.ru/login");
        try {
            Thread.sleep(50000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Tag("Новый Тесты")
    @DisplayName("AllureTest")
    public void allureTest(){
        step1();
                step2();
    }

    @Step("Шаг1")
    public void step1(){
        System.out.println("1245");
    }

    @Step("Шаг2")
    public void step2(){
        System.out.println("12435");
    }

}
