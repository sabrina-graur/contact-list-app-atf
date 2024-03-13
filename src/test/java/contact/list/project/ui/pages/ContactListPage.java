package contact.list.project.ui.pages;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactListPage extends CommonPage {

    private static final Logger LOG = LogManager.getLogger(ContactListPage.class);

    public static By addContactButton = By.id("add-contact");
    public static By logout = By.id("logout");

    public static void clickLogout() {
        try {
            WaitUtils.isElementDisplayed(logout, PropertiesManager.checkElementIsDisplayedTimeout());
            WebElement logoutButton = DriverManager.getDriver().findElement(logout);
            logoutButton.click();
            LOG.info("The Logout button was clicked");
        } catch (Exception e) {
            LOG.error("Error clicking the Logout button", e);
            throw new RuntimeException("Error clicking the Logout button", e);
        }
    }
}
