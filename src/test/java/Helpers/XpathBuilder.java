package Helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class XpathBuilder {

    public static SelenideElement element(String attribute, String param) {
        return $x("//*[@" + attribute + "='" + param + "']");
    }

    public static SelenideElement element(String element, String attribute, String param) {
        return $x("//" + element + "[@" + attribute + "='" + param + "']");
    }

    public static SelenideElement elementTextFollowing(String param, String secondAttribute) {
        return $x("//*[text()='" + param + "']/following::" + secondAttribute + "[1]");
    }

    public static SelenideElement elementContains(String element, String attribute, String param) {
        return $x("//" + element + "[contains(@" + attribute + ",'" + param + "')]");
    }

}
