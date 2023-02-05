package ElementSteps;

import Helpers.AllureHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static Helpers.AllureHelper.logToAllure;
import static com.codeborne.selenide.Selenide.open;

public class BasicElementSteps {

    @Step("Перейти на страницу \"{url}\"")
    public BasicElementSteps goToUrl(String url) {
        open(url);
        return this;
    }

    @Step("Клик по элементу \"{elementName}\"")
    public BasicElementSteps clickElement(String elementName, SelenideElement element) {
        AllureHelper.takeScreenshot("Клик по элементу " + elementName + ". Скриншот ДО");
        element.shouldBe(Condition.visible).click();
        AllureHelper.takeScreenshot("Клик по элементу " + elementName + ". Скриншот ПОСЛЕ");
        return this;
    }

    @Step("Заполнение поля \"{elementName}\" значением \"{value}\"")
    public BasicElementSteps sendKey(String elementName, SelenideElement element, String value) {
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ДО");
        element.shouldBe(Condition.visible).sendKeys(value);
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ПОСЛЕ");
        return this;
    }

    @Step("Заполнение поля \"{elementName}\" значением \"{value}\" и нажатие Enter")
    public BasicElementSteps sendKeyEnter(String elementName, SelenideElement element, String value) {
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ДО");
        element.shouldBe(Condition.visible).sendKeys(value + "\n");
        AllureHelper.takeScreenshot("Заполнение поля " + elementName + " значением " + value + ". Скриншот ПОСЛЕ");
        return this;
    }

    @Step("Получение значения из поля \"{elementName}\"")
    public String getText(String elementName, SelenideElement element) {
        AllureHelper.takeScreenshot("Получение значения поля " + elementName);
        logToAllure("Значение поля " + elementName, element.getText());
        return element.getText();
    }

}
