package contact.list.project.ui.steps;

import contact.list.project.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on Login page")
    public void userIsOnLoginPage() {
        LogManager.getLogger().info("Login page is displayed");
    }

    @When("user logs in with the following credentials:")
    public void login(Map<String, String> userData) {
        loginPage.loginWithCredentials(userData);
    }

    @Then("{string} message is displayed")
    public void validateErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorLabel().getText();
        assertThat("The error message is incorrect", actualMessage, is(expectedMessage));
    }

    @Then("{string} is displayed")
    public void isLoginPageDisplayed(String title) {
        loginPage.assertPageTitle(title);
    }
}
