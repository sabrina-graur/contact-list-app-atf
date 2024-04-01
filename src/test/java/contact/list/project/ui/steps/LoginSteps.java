package contact.list.project.ui.steps;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    @When("^user logs in with (valid|invalid) credentials$")
    public void login (String validity) throws InterruptedException {
            if (validity.equals("valid")) {
                LoginPage.loginWithValidCredentials();
            } else {
                LoginPage.loginWithInvalidCredentials();
            }
        Thread.sleep(5000);
    }

    @Then("{string} error message is displayed")
    public void errorMessageIsDisplayed(String message) {
        String actualMessage = DriverManager.getDriver().findElement(LoginPage.errorLabel).getText();
        Assert.assertEquals(actualMessage, message);
    }
}
