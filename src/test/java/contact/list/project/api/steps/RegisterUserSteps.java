package contact.list.project.api.steps;

import contact.list.project.api.actions.CreateUserActions;
import contact.list.project.api.actions.GetUserActions;
import contact.list.project.api.dtos.requests.UserRequest;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioObjectKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class RegisterUserSteps {

    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    CreateUserActions createUserActions = new CreateUserActions();
    GetUserActions getUserActions = new GetUserActions();

    @Given("user has a registered account with the following {}:")
    public void userHasARegisteredAccount(ScenarioObjectKey userDataKey, Map<String, String> userData) {
        prepareCredentials(userDataKey, userData);
        registerUser(ScenarioObjectKey.USER_CREDENTIALS);
    }

    @Given("the following {}:")
    public void prepareCredentials(ScenarioObjectKey userDataKey, Map<String, String> userDataValue) {
        UserRequest userCreationRequest = new UserRequest(userDataValue);
        scenarioContext.saveData(userDataKey, userCreationRequest);
        LogManager.getLogger().info("The Request body for user registration is following: {}", userCreationRequest);
    }

    @When("user performs registration with {}")
    public void registerUser(ScenarioObjectKey data) {
        createUserActions.createUser(scenarioContext.getData(data));
    }

    @And("the new account is created")
    public void verifyAccountIsCreated() {
        getUserActions.validateUserAccountCreation();
    }
}
