package contact.list.project.ui.pages;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.ui.steps.CommonSteps;
import contact.list.project.utils.DataGenerator;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(LoginPage.class);
    public static By signUpButton = By.xpath("//button[@id='signup']");
    public static By errorLabel = By.id("error");

    public static void loginWithValidCredentials() {
        try {
            WaitUtils.isElementDisplayed(emailInput, PropertiesManager.checkElementIsDisplayedTimeout());
            CommonSteps.populateField(emailInput, PropertiesManager.getUsername());
            LOG.info("Email field is populated");
            CommonSteps.populateField(passwordInput, PropertiesManager.getPassword());
            LOG.info("Password field is populated");
            clickSubmit();
            LOG.info("Login with valid credentials successful");
        } catch (Exception e) {
            LOG.error("Email input field is not displayed", e);
            throw new RuntimeException("Email input field is not displayed", e);
        }
    }

    public static void loginWithInvalidCredentials() {
        try {
            WaitUtils.isElementDisplayed(emailInput, PropertiesManager.checkElementIsDisplayedTimeout());
            CommonSteps.populateField(emailInput, DataGenerator.generateRandomAlphabeticValue(1));
            LOG.info("Email field is populated");
            CommonSteps.populateField(passwordInput, PropertiesManager.getPassword());
            LOG.info("Password field is populated");
            clickSubmit();
            LOG.info("Login failed");
        } catch (Exception e) {
            LOG.error("Email input field is not displayed", e);
            throw new RuntimeException("Email input field is not displayed", e);
        }
    }
}
