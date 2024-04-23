package contact.list.project.api.actions;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import io.restassured.response.Response;

import static contact.list.project.api.enums.Endpoint.USER_INFO;
import static contact.list.project.configurations.scenario_context.ScenarioObjectKey.RESPONSE;
import static contact.list.project.configurations.scenario_context.ScenarioObjectKey.TOKEN;
import static io.restassured.RestAssured.given;

public class UpdateUserActions {

    public void updateUser(Object userData) {
        Response response = given()
                .header("Authorization", ScenarioContext.getInstance().getData(TOKEN))
                .contentType("application/json")
                .body(userData)
                .patch(PropertiesManager.getBaseUrl() + USER_INFO.getEndPoint())
                .thenReturn();
        ScenarioContext.getInstance().saveData(RESPONSE, response);
    }
}
