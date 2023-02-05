package Steps.Google;

import ElementSteps.BasicElementSteps;
import Helpers.Configuration;
import io.qameta.allure.Step;

public class MainPageSteps extends Pages.Google.MainPage {

    BasicElementSteps basicElementSteps = new BasicElementSteps();
    String googleUrl = Configuration.getConfigurationValue("googleUrl");

    @Step("Поиск \"{valueForSearch}\" в Google")
    public void searchGoogle(String valueForSearch) {
        basicElementSteps
                .goToUrl(googleUrl)
                .clickElement("Строка поиска", searchField())
                .sendKeyEnter("Поле поиска", searchField(), valueForSearch)
                .getText("Описание", description());
    }

}
