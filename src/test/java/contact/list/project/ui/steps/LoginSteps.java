package contact.list.project.ui.steps;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.ui.pages.CommonPage;
import contact.list.project.ui.pages.ContactListPage;
import contact.list.project.ui.pages.LoginPage;
import contact.list.project.utils.DataGenerator;
import contact.list.project.utils.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class LoginSteps {
    private static final Logger LOG = LogManager.getLogger(LoginSteps.class);

    @When("^user logs in with (valid|invalid) credentials$")
    public void loginWithCredentials(String validity) {
        try {
            WaitUtils.isDisplayed(LoginPage.emailInput, PropertiesManager.checkElementIsDisplayedTimeout());
            if (validity.equals("valid")) {
                CommonPage.populateField(LoginPage.emailInput, PropertiesManager.getUsername());
            } else {
                CommonPage.populateField(LoginPage.emailInput, DataGenerator.generateRandomAlphabeticValue(1));
            }
            LOG.info("Email field is populated");
            CommonPage.populateField(LoginPage.passwordInput, PropertiesManager.getPassword());
            LOG.info("Password field is populated");
            CommonPage.clickSubmit();
            if (validity.equals("valid")) {
                WaitUtils.isDisplayed(ContactListPage.pageTitleContactList, PropertiesManager.checkElementIsDisplayedTimeout());
            } else {
                WaitUtils.isDisplayed(LoginPage.errorLabel, PropertiesManager.checkElementIsDisplayedTimeout());
            }
        } catch (Exception e) {
            LOG.error("Error occurred during login process", e);
            throw new RuntimeException("Error occurred during login process", e);
        }
    }

    @Then("{string} error message is displayed")
    public void errorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = DriverManager.getDriver().findElement(LoginPage.errorLabel).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
