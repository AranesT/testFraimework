package Pages.Yandex;

import Helpers.XpathBuilder;
import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public SelenideElement searchField() {
        return XpathBuilder.element("aria-label", "Запрос");
    }

    public SelenideElement fastResult() {
        return XpathBuilder.elementContains("div", "class", "fact__description");
    }

}
