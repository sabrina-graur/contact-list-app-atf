package contact.list.project.api.steps;

import contact.list.project.api.actions.CreateUserActions;
import contact.list.project.api.actions.GetUserActions;
import contact.list.project.api.dtos.requests.UserRequest;
import contact.list.project.configurations.scenario.context.ScenarioContext;
import contact.list.project.configurations.scenario.context.ScenarioObjectKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class RegisterUserSteps {

    CreateUserActions createUserActions = new CreateUserActions();
    GetUserActions getUserActions = new GetUserActions();

    @Given("user has a registered account with the following {}:")
    public void registerUserForFurtherUpdate(ScenarioObjectKey userDataKey, Map<String, String> userData) {
        prepareCredentials(userDataKey, userData);
        registerUser(ScenarioObjectKey.USER_CREDENTIALS);
    }

    @Given("the following {}:")
    public void prepareCredentials(ScenarioObjectKey userDataKey, Map<String, String> userDataValue) {
        UserRequest userCreationRequest = new UserRequest(userDataValue);
        ScenarioContext.getInstance().saveData(userDataKey, userCreationRequest);
        LogManager.getLogger().info("The Request body for user registration is following: {}", userCreationRequest);
    }

    @When("user performs registration with {}")
    public void registerUser(ScenarioObjectKey data) {
        createUserActions.createUser(ScenarioContext.getInstance().getData(data));
    }

    @And("the new account is created")
    public void verifyAccountIsCreated() {
        getUserActions.validateUserAccountCreation();
    }
}
