package Steps.Yandex;

import ElementSteps.BasicElementSteps;
import Helpers.Configuration;
import io.qameta.allure.Step;

public class MainPageSteps extends Pages.Yandex.MainPage {

    BasicElementSteps basicElementSteps = new BasicElementSteps();
    String yandexUrl = Configuration.getConfigurationValue("yandexUrl");

    @Step("Поиск \"{valueForSearch}\" в Yandex")
    public void searchYandex(String valueForSearch) {
        basicElementSteps.goToUrl(yandexUrl)
                .clickElement("Строка поиска", searchField())
                .sendKeyEnter("Поле поиска", searchField(), valueForSearch)
                .getText("Быстрый ответ", fastResult());
    }

}
