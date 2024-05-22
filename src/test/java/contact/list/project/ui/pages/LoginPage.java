package contact.list.project.ui.pages;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class LoginPage extends CommonPage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(id = "signup")
    private WebElement signUpButton;

    @FindBy(id = "error")
    private WebElement errorLabel;

    public WebElement getErrorLabel() {
        WaitUtils.waitForElementToBeDisplayed(errorLabel, PropertiesManager.checkElementIsDisplayedTimeout());
        return errorLabel;
    }

    public void clickSignUpButton() {
        action.clickButton(signUpButton);
    }

    public void loginWithCredentials(Map<String, String> user) {
        action.populateField(emailInput, user.get("email"));
        action.populateField(passwordInput, user.get("password"));
        clickSubmit();
    }
}
