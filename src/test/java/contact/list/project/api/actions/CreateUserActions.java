package contact.list.project.api.actions;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;

import static contact.list.project.api.enums.Endpoint.SIGN_UP;
import static contact.list.project.configurations.scenario_context.ScenarioObjectKey.RESPONSE;
import static contact.list.project.configurations.scenario_context.ScenarioObjectKey.TOKEN;
import static io.restassured.RestAssured.given;

public class CreateUserActions {

    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public void createUser(Object userData) {
        Response response = given()
                .header("Authorization", "Bearer {{token}}")
                .contentType("application/json")
                .body(userData)
                .post(PropertiesManager.getBaseUrl() + SIGN_UP.getEndPoint())
                .thenReturn();
        scenarioContext.saveData(RESPONSE, response);
        scenarioContext.saveData(TOKEN, response.jsonPath().getString("token"));
        if (scenarioContext.getData(TOKEN) != null) {
            LogManager.getLogger().info("Registered user with token: {}", scenarioContext.getData(TOKEN).toString());
        } else {
            String errorMessage = response.jsonPath().getString("message");
            LogManager.getLogger().info("No Token generated. Failed to register user with the following error: {}", errorMessage);
        }
    }
}
