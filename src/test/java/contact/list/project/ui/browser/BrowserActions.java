package contact.list.project.ui.browser;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BrowserActions {

    public BrowserActions() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickButton(WebElement button) {
        WaitUtils.waitForElementToBeClickable(button, PropertiesManager.checkElementIsDisplayedTimeout());
        String buttonName = button.getText();
        button.click();
        LogManager.getLogger().info("The [{}] button was clicked", buttonName);
    }

    public void populateField(WebElement inputField, String value) {
        WaitUtils.waitForElementToBeDisplayed(inputField, PropertiesManager.checkElementIsDisplayedTimeout());
        inputField.clear();
        LogManager.getLogger().info("{} field is cleared", inputField.getAccessibleName());
        inputField.sendKeys(value == null ? "" : value);
        LogManager.getLogger().info("{} field is populated with the value: {}", inputField.getAccessibleName(), value);
    }
}
