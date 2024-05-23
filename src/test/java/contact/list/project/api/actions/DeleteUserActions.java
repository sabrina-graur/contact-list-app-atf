package contact.list.project.api.actions;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario.context.ScenarioContext;
import contact.list.project.configurations.scenario.context.ScenarioObjectKey;
import org.apache.logging.log4j.LogManager;

import static contact.list.project.api.enums.Endpoint.USER_INFO;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class DeleteUserActions {

    public void deleteAccount() {
        String token = ScenarioContext.getInstance().getData(ScenarioObjectKey.TOKEN);
        given()
                .header("Authorization", token)
                .contentType("application/json")
                .delete(PropertiesManager.getProperty("BASE_URL") + USER_INFO.getEndPoint())
                .then().statusCode(SC_OK);
        LogManager.getLogger().info("User with token: {} was deleted", token);
    }
}
