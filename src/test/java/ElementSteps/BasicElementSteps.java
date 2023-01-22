package ElementSteps;

import Helpers.AllureHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static Helpers.AllureHelper.logToAllure;
import static com.codeborne.selenide.Selenide.open;

public class BasicElementSteps {

    @Step("Перейти на страницу \"{url}\"")
    public void goToUrl(String url) {
        open(url);
    }

    @Step("Клик по элементу \"{elementName}\"")
    public void clickElement(String elementName, SelenideElement element) {
        AllureHelper.takeScreenshot("Клик по элементу " + elementName + ". Скриншот ДО");
        element.shouldBe(Condition.visible).click();
        AllureHelper.takeScreenshot("Клик по элементу " + elementName + ". Скриншот ПОСЛЕ");
    }

    @Step("Заполнение поля {elementName} значением {value}")
    public void sendKey(String elementName, SelenideElement element, String value) {
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ДО");
        element.shouldBe(Condition.visible).sendKeys(value);
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ПОСЛЕ");
    }

    @Step("Заполнение поля \"{elementName}\" значением \"{value}\" и нажатие Enter")
    public void sendKeyEnter(String elementName, SelenideElement element, String value) {
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ДО");
        element.shouldBe(Condition.visible).sendKeys(value + "\n");
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ПОСЛЕ");
    }

    @Step("Получение значения из поля \"{elementName}\"")
    public String getText(String elementName, SelenideElement element) {
        AllureHelper.takeScreenshot("Получение значения поля " + elementName);
        logToAllure("Значение поля " + elementName, element.getText());
        return element.getText();
    }

}
