package contact.list.project.api.steps;

import contact.list.project.api.actions.GetUserActions;
import contact.list.project.api.actions.UpdateUserActions;
import contact.list.project.api.dtos.requests.UserRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class UpdateUserSteps {

    UpdateUserActions updateUserActions = new UpdateUserActions();
    GetUserActions getUserActions = new GetUserActions();

    @When("user updates the account with the following data:")
    public void updateUserData(Map<String, String> userData) {
        UserRequest userUpdateRequest = new UserRequest(userData);
        updateUserActions.updateUser(userData);
        LogManager.getLogger().info("The Request body for amend user is following: {}", userUpdateRequest);
    }

    @And("the new account is updated")
    public void validateAccountIsUpdated() {
        getUserActions.validateUserAccountUpdate();
    }
}
