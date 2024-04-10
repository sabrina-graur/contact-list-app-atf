package contact.list.project.ui.pages;

import contact.list.project.utils.DataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SignUpPage extends CommonPage {
    private static final Logger LOG = LogManager.getLogger(SignUpPage.class);
    public static By firstNameInput = By.xpath("//input[@id='firstName']");
    public static By lastNameInput = By.xpath("//input[@id='lastName']");
    public static By cancelButton = By.id("cancel");

    public static void addUser() {
        populateField(firstNameInput, DataGenerator.generateRandomAlphabeticValue(4));
        LOG.info("First name field is populated");
        populateField(lastNameInput, DataGenerator.generateRandomAlphabeticValue(5));
        LOG.info("Last name field is populated");
        populateField(emailInput, DataGenerator.generateRandomEmail(20));
        LOG.info("Email field is populated");
        populateField(passwordInput, DataGenerator.generateRandomAlphanumericValue(8));
        LOG.info("Password field is populated");
        clickSubmit();
    }
}
