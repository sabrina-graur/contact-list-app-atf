package contact.list.project.api.dtos.responses;

import contact.list.project.api.dtos.requests.AddUserRequest;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserCreationResponse {

    private final ScenarioContext scenarioContext = ScenarioContext.getContext();

    public Response addUserRequest(AddUserRequest registrationRequest) {
        return RestAssured
                .given().log().all()
                .auth()
                .oauth2(scenarioContext.getData(AUTH_TOKEN).toString())
                .header("Authorization: Bearer {{token}}")
                .contentType("application/json")
                .body(registrationRequest)
                .post(PropertiesManager.getPage());
    }
}
