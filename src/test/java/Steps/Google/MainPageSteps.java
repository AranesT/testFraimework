package Steps.Google;

import ElementSteps.BasicElementSteps;
import Helpers.Configuration;
import io.qameta.allure.Step;

public class MainPageSteps extends Pages.Google.MainPage {

    BasicElementSteps basicElementSteps = new BasicElementSteps();
    String googleUrl = Configuration.getConfigurationValue("googleUrl");

    @Step("Поиск {valueForSearch} в Google")
    public void searchGoogle(String valueForSearch) {
        basicElementSteps.goToUrl(googleUrl);
        basicElementSteps.clickElement("Строка поиска", searchField());
        basicElementSteps.sendKeyEnter("Поле поиска", searchField(), valueForSearch);
        basicElementSteps.getText("Описание", description());
    }

}
