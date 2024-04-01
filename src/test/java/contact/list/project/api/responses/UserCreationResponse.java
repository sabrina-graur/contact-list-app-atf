package contact.list.project.api.responses;

import contact.list.project.configurations.properties.PropertiesManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static contact.list.project.api.enums.Endpoint.SIGN_UP;
import static contact.list.project.api.enums.Endpoint.USER_INFO;

public class UserCreationResponse {

    public static Response addUserResponse(Object object) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer {{token}}")
                .contentType("application/json")
                .body(object)
                .post( PropertiesManager.getBaseUrl() + SIGN_UP.getEndPoint());
    }

    public static Response validateAccountCreation(Object object){
        return RestAssured
                .given()
                .header("Authorization", object)
                .contentType("application/json")
                .get(PropertiesManager.getBaseUrl()+ USER_INFO.getEndPoint());
    }
}
