package contact.list.project.api.steps;

import contact.list.project.api.enums.ErrorMessage;
import contact.list.project.api.requests.AddUserRequest;
import contact.list.project.api.responses.UserCreationResponse;
import contact.list.project.utils.JsonUtils;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class AddUserSteps {
    private static final Logger LOG = LogManager.getLogger(AddUserSteps.class);
    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Given("^user performs registration with the (valid|invalid) data:$")
    public void registerUser(String validity, DataTable userData) {
        List<Map<String, String>> userList = userData.asMaps(String.class, String.class);
        for (Map<String, String> user : userList) {
            String firstName = user.get("firstName");
            String lastName = user.get("lastName");
            String email = user.get("email");
            String password = user.get("password");
            AddUserRequest addUser = new AddUserRequest(firstName, lastName, email, password);
            LOG.info("Registering user with firstName: {}, lastName: {}, email: {}", firstName, lastName, email);
            Response response = UserCreationResponse.addUserResponse(addUser);
            if (validity.equals("valid")) {
                validateAddUserRequestResponse(response, firstName, lastName, email);
                saveValidResponseData(response);
            } else {
                saveInvalidResponseData(response);
            }
        }
    }

    private void saveValidResponseData(Response response) {
        scenarioContext.saveData("user", JsonUtils.convertToJson(response.jsonPath().getString("user")));
        scenarioContext.saveData("token", response.jsonPath().getString("token"));
        scenarioContext.saveData("statusCode", response.getStatusCode());
    }

    private void saveInvalidResponseData(Response response) {
        scenarioContext.saveData("statusCode", response.getStatusCode());
        scenarioContext.saveData("errorMessage", response.jsonPath().getString("message"));
    }

    public void validateAddUserRequestResponse(Response response, String validFirstName, String
            validLastName, String validEmail) {
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getString("user.firstName"), validFirstName);
        Assert.assertEquals(json.getString("user.lastName"), validLastName);
        Assert.assertEquals(json.getString("user.email"), validEmail);
    }

    @Then("response has status code {}")
    public void validateStatusCode(int expectedCode) {
        LOG.info("Validating response status code: {}", expectedCode);
        Assert.assertEquals(expectedCode, scenarioContext.getData("statusCode"));
    }

    @When("user validates the newly created account")
    public void validateUserAccount() {
        Response response = UserCreationResponse.validateAccountCreation(scenarioContext.getData("token"));
        scenarioContext.saveData("statusCode", response.getStatusCode());
        LOG.info("Validating newly created account with token: {}", scenarioContext.getData("token"));
        Assert.assertEquals(scenarioContext.getData("user"), response.getBody().asString());
    }

    @And("{} error message is displayed:")
    public void validateErrorMessage(ErrorMessage type) {
        String errorMessage = type.getErrorMessageName();
        LOG.info("Validating error message: {}", errorMessage);
        Assert.assertEquals(errorMessage, scenarioContext.getData("errorMessage"));
    }
}
