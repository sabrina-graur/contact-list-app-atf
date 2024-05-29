package contact.list.project.api.steps;

import contact.list.project.api.actions.CreateUserActions;
import contact.list.project.api.actions.GetUserActions;
import contact.list.project.api.dtos.requests.UserRequest;
import contact.list.project.configurations.scenario.context.ScenarioContext;
import contact.list.project.enums.ScenarioObjectKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class RegisterUserSteps {

    CreateUserActions createUserActions = new CreateUserActions();
    GetUserActions getUserActions = new GetUserActions();

    @Given("user has a registered account with the following credentials:")
    public void registerUserForFurtherUpdate(Map<String, String> userData) {
        prepareCredentials(userData);
        registerUser();
    }

    @Given("the following credentials:")
    public void prepareCredentials(Map<String, String> userDataValue) {
        UserRequest userCreationRequest = new UserRequest(userDataValue);
        ScenarioContext.getInstance().saveData(ScenarioObjectKey.USER_CREDENTIALS, userCreationRequest);
        LogManager.getLogger().info("The Request body for user registration is following: {}", userCreationRequest);
    }

    @When("user registers an account")
    public void registerUser() {
        createUserActions.createUser(ScenarioContext.getInstance().getData(ScenarioObjectKey.USER_CREDENTIALS));
    }

    @And("the new account is created")
    public void verifyAccountIsCreated() {
        getUserActions.validateUserAccountCreation();
    }
}
