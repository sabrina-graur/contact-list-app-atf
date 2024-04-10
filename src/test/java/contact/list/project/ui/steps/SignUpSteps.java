package contact.list.project.ui.steps;

import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import contact.list.project.ui.pages.LoginPage;
import contact.list.project.ui.pages.SignUpPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SignUpSteps {
    WebDriver driver = ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER);
    SignUpPage signUpPage = new SignUpPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("user performs registration with valid data")
    public void registerUser() {
        signUpPage.addUser();
    }

    @When("user clicks sign up button")
    public void clickSignUpButton() {
        loginPage.clickSignUpButton();
    }

    @When("user cancels the registration")
    public void cancel() {
        signUpPage.clickCancel();
    }
}
