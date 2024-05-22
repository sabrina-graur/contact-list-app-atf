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
        action.populateField(firstNameInput, DataGenerator.generateRandomFirstName());
        action.populateField(lastNameInput, DataGenerator.generateRandomLastName());
        action.populateField(emailInput, DataGenerator.generateRandomEmail());
        action.populateField(passwordInput, DataGenerator.generateRandomPassword());
        clickSubmit();
    }

    public void clickCancel() {
        action.clickButton(cancelButton);
    }
}
