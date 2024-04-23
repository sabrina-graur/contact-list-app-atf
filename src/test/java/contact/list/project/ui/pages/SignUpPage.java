package contact.list.project.ui.pages;

import contact.list.project.utils.DataGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends CommonPage {

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    public void addUser() {
        actions.populateField(firstNameInput, DataGenerator.generateRandomFirstName());
        actions.populateField(lastNameInput, DataGenerator.generateRandomLastName());
        actions.populateField(emailInput, DataGenerator.generateRandomEmail());
        actions.populateField(passwordInput, DataGenerator.generateRandomPassword());
        clickSubmit();
    }

    public void clickCancel() {
        actions.clickButton(cancelButton);
    }
}
