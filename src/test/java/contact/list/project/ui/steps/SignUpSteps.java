package contact.list.project.ui.steps;

import contact.list.project.ui.pages.LoginPage;
import contact.list.project.ui.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps {
    SignUpPage signUpPage = new SignUpPage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on Sign Up page")
    public void isOnSignUpPage() {
        loginPage.clickSignUpButton();
    }

    @When("user performs registration")
    public void registerUser() {
        signUpPage.addUser();
    }

    @When("user cancels the registration")
    public void cancel() {
        signUpPage.clickCancel();
    }

    @Then("{string} page is displayed")
    public void isPageDisplayed(String title) {
        signUpPage.validatePageTitle(title);
    }
}
