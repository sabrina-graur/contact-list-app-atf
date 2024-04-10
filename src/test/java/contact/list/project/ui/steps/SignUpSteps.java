package contact.list.project.ui.steps;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.ui.pages.CommonPage;
import contact.list.project.ui.pages.ContactListPage;
import contact.list.project.ui.pages.LoginPage;
import contact.list.project.ui.pages.SignUpPage;
import contact.list.project.utils.WaitUtils;
import io.cucumber.java.en.When;

public class SignUpSteps {

    @When("user performs registration with valid data")
    public void registerUser() {
        SignUpPage.addUser();
        WaitUtils.isDisplayed(ContactListPage.pageTitleContactList, PropertiesManager.checkElementIsDisplayedTimeout()); //TODO: ask Tudor about this soultion
    }

    @When("user clicks sign up button")
    public void clickSignUpButton() {
        CommonPage.clickButton(LoginPage.signUpButton);
    }

    @When("user cancels the registration")
    public void clickCancel() {
        CommonPage.clickButton(SignUpPage.cancelButton);
    }
}
