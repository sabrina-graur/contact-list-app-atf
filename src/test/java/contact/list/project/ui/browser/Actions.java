package contact.list.project.ui.browser;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Actions {
    WebDriver driver;
    private static final Logger LOG = LogManager.getLogger(Actions.class);

    public Actions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement button) {
        try {
            WaitUtils.waitForElementToBeClickable(button, PropertiesManager.checkElementIsDisplayedTimeout());
            String buttonName = button.getAccessibleName();
            button.click();
            LOG.info("The " + buttonName + " button was clicked");
        } catch (Exception e) {
            LOG.error("Error clicking the " + button.getAccessibleName() + "  button", e);
            throw new RuntimeException("Error clicking the " + button.getAccessibleName() + "   button", e);
        }
    }

    public void populateField(WebElement inputField, String value) {
        try {
            WaitUtils.waitForElementToBeDisplayed(inputField, PropertiesManager.checkElementIsDisplayedTimeout());
            inputField.clear();
            inputField.sendKeys(value == null ? "" : value);
            LOG.info(inputField.getAccessibleName() + " field is populated");
        } catch (Exception e) {
            LOG.error("Error occurred during field population", e);
            throw new RuntimeException("Error occurred during field population", e);
        }
    }
}
