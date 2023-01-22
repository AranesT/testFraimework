package Pages.Google;

import Helpers.XpathBuilder;
import com.codeborne.selenide.SelenideElement;

public class MainPage {

    public SelenideElement searchField() {
        return XpathBuilder.element("title", "Поиск");
    }

    public SelenideElement description() {
        return XpathBuilder.elementTextFollowing("Описание", "span");
    }

}
