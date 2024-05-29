package contact.list.project.api.actions;

import contact.list.project.api.dtos.response.CreateUserResponse;
import contact.list.project.api.dtos.response.UserProfileResponse;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario.context.ScenarioContext;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;

import static contact.list.project.enums.Endpoint.USER_INFO;
import static contact.list.project.enums.ScenarioObjectKey.RESPONSE;
import static contact.list.project.enums.ScenarioObjectKey.TOKEN;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetUserActions {

    public UserProfileResponse getUserProfile() {
        return given()
                .header("Authorization", ScenarioContext.getInstance().getData(TOKEN))
                .contentType("application/json")
                .get(PropertiesManager.getProperty("BASE_URL") + USER_INFO.getEndPoint())
                .then()
                .extract()
                .as(UserProfileResponse.class);
    }

    public void validateUserAccountCreation() {
        UserProfileResponse actualUserProfile = getUserProfile();
        Response response = ScenarioContext.getInstance().getData(RESPONSE);
        CreateUserResponse expectedUserResponse = response.as(CreateUserResponse.class);
        assertThat(actualUserProfile, equalTo(expectedUserResponse.getUser()));
        LogManager.getLogger().info("The user profile validation was successful. The response body is: {}", expectedUserResponse);
    }

    public void validateUserAccountUpdate() {
        UserProfileResponse actualUserProfile = getUserProfile();
        Response response = ScenarioContext.getInstance().getData(RESPONSE);
        UserProfileResponse expectedUserResponse = response.as(UserProfileResponse.class);
        assertThat(actualUserProfile, equalTo(expectedUserResponse));
        LogManager.getLogger().info("The user profile was successfully updated. The response body is: {}", expectedUserResponse);
    }
}
