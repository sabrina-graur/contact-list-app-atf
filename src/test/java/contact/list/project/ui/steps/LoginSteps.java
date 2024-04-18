package contact.list.project.ui.steps;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import contact.list.project.ui.pages.LoginPage;
import contact.list.project.utils.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER));

    @When("user logs in with the following credentials:") //TODO: read about cucumber Enum
    public void login(Map<String, String> userData) {
        loginPage.loginWithCredentials(userData);
    }

    @Then("{string} error message is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        WaitUtils.waitForElementToBeDisplayed(loginPage.getErrorLabel(), PropertiesManager.checkElementIsDisplayedTimeout());
        String actualMessage = loginPage.getErrorLabel().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
