package contact.list.project.api.actions;

import contact.list.project.api.enums.ErrorMessage;
import contact.list.project.api.dtos.requests.AddUserRequest;
import contact.list.project.configurations.scenario_context.ScenarioKey;
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

public class AddUserActions {
    private static final Logger LOG = LogManager.getLogger(AddUserActions.class);
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
            Response response = UserCreationResponse.addUserResponse(addUser);
            if (validity.equals("valid")) {
                validateAddUserRequestResponse(response, firstName, lastName, email);
                saveValidResponseData(response);
            } else {
                saveInvalidResponseData(response);
            }
            LOG.info("Registered user with firstName: {}, lastName: {}, email: {}", firstName, lastName, email);
        }
    }

    private void saveValidResponseData(Response response) {
        scenarioContext.saveData(ScenarioKey.USER, JsonUtils.convertToJson(response.jsonPath().getString("user")));
        scenarioContext.saveData(ScenarioKey.TOKEN, response.jsonPath().getString("token"));
        scenarioContext.saveData(ScenarioKey.STATUS_CODE, response.getStatusCode());
    }

    private void saveInvalidResponseData(Response response) {
        scenarioContext.saveData(ScenarioKey.STATUS_CODE, response.getStatusCode());
        scenarioContext.saveData(ScenarioKey.ERROR_MESSAGE, response.jsonPath().getString("message"));
    }

    public void validateAddUserRequestResponse(Response response, String validFirstName, String
            validLastName, String validEmail) {
        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getString("user.firstName"), validFirstName);
        Assert.assertEquals(json.getString("user.lastName"), validLastName);
        Assert.assertEquals(json.getString("user.email"), validEmail);
    }

    @Then("response has status code {}")
    public void validateStatusCode(Integer expectedCode) {
        Assert.assertEquals(expectedCode, scenarioContext.getData(ScenarioKey.STATUS_CODE));
    }

    @Given("user registered an account")
    @When("user validates the newly created account")
    public void validateUserAccount() {
        Response response = UserCreationResponse.validateAccountCreation(scenarioContext.getData(ScenarioKey.TOKEN));
        scenarioContext.saveData(ScenarioKey.STATUS_CODE, response.getStatusCode());
        Assert.assertEquals(scenarioContext.getData(ScenarioKey.USER), response.getBody().asString());
    }

    @And("{} error message is displayed:")
    public void validateErrorMessage(ErrorMessage type) {
        String errorMessage = type.getErrorMessageName();
        Assert.assertEquals(errorMessage, scenarioContext.getData(ScenarioKey.ERROR_MESSAGE));
    }
}
