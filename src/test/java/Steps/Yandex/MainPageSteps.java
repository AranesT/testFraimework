package Steps.Yandex;

import ElementSteps.BasicElementSteps;
import Helpers.Configuration;
import io.qameta.allure.Step;

public class MainPageSteps extends Pages.Yandex.MainPage {

    BasicElementSteps basicElementSteps = new BasicElementSteps();
    String yandexUrl = Configuration.getConfigurationValue("yandexUrl");

    @Step("Поиск {valueForSearch} в Yandex")
    public void searchYandex(String valueForSearch) {
        basicElementSteps.goToUrl(yandexUrl);
        basicElementSteps.clickElement("Строка поиска", searchField());
        basicElementSteps.sendKeyEnter("Поле поиска", searchField(), valueForSearch);
        basicElementSteps.getText("Быстрый ответ", fastResult());
    }

}
