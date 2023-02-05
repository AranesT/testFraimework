package Pages;

import Helpers.XpathBuilder;
import com.codeborne.selenide.SelenideElement;

public enum PageEnumExample {

    searchField(XpathBuilder.element("title", "Поиск")),
    loginButton(XpathBuilder.element("text()", "Войти"));

    final SelenideElement xpath;

    public SelenideElement getXpath() {
        return xpath;
    }

    PageEnumExample(SelenideElement xpath) {
        this.xpath = xpath;
    }
}
