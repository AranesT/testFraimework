package Steps.Api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    final String responseUrl = "https://rickandmortyapi.com/api";

    @Step("Поиск информации о персонаже с id = \"{Id}\"")
    public HashMap<String, String> findCharacterInfo(String Id) {
        Response getFirstCharInfo = given()
                .baseUri(responseUrl)
                .when().get("/character/" + Id)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
        HashMap<String, String> characterInfo = new HashMap<>();
        characterInfo.put("name", new JSONObject(getFirstCharInfo.getBody().asString()).get("name").toString());
        characterInfo.put("id", new JSONObject(getFirstCharInfo.getBody().asString()).get("id").toString());
        characterInfo.put("location", new JSONObject(getFirstCharInfo.getBody().asString()).getJSONObject("location").get("name").toString());
        characterInfo.put("species", new JSONObject(getFirstCharInfo.getBody().asString()).get("species").toString());
        return characterInfo;
    }
}
