package contact.list.project.ui.pages;

import contact.list.project.utils.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends CommonPage {

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void addUser() {
        actions.populateField(firstNameInput, DataGenerator.generateRandomAlphabeticValue(4));
        actions.populateField(lastNameInput, DataGenerator.generateRandomAlphabeticValue(5));
        actions.populateField(getEmailInput(), DataGenerator.generateRandomEmail(20));
        actions.populateField(getPasswordInput(), DataGenerator.generateRandomAlphanumericValue(8));
        clickSubmit();
    }

    public void clickCancel() {
        actions.clickButton(cancelButton);
    }
}
