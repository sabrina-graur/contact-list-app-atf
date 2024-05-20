package contact.list.project.api.steps;

import contact.list.project.api.actions.GetUserActions;
import contact.list.project.api.actions.UpdateUserActions;
import contact.list.project.api.dtos.requests.UserRequest;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

import static contact.list.project.configurations.scenario_context.ScenarioObjectKey.USER_CREDENTIALS;

public class UpdateUserSteps {

    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    UpdateUserActions updateUserActions = new UpdateUserActions();
    GetUserActions getUserActions = new GetUserActions();

    @When("user updates the account with the following data:")
    public void updateUserData(Map<String, String> userData) {
        UserRequest userUpdateRequest = new UserRequest(userData);
        scenarioContext.saveData(USER_CREDENTIALS, userUpdateRequest);
        updateUserActions.updateUser(scenarioContext.getData(USER_CREDENTIALS));
        LogManager.getLogger().info("The Request body for amend user is following: {}", userUpdateRequest);
    }

    @And("the new account is updated")
    public void validateAccountIsUpdated() {
        getUserActions.validateUserAccountUpdate();
    }
}
