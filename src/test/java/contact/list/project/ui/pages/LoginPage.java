package contact.list.project.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;

public class LoginPage extends CommonPage {

    @FindBy(id = "signup")
    private WebElement signUpButton;

    @FindBy(id = "error")
    private WebElement errorLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getErrorLabel() {
        return errorLabel;
    }

    public void clickSignUpButton() {
        actions.clickButton(signUpButton);
    }

    public void loginWithCredentials(Map<String, String> user) {
            actions.populateField(getEmailInput(), user.get("email"));
            actions.populateField(getPasswordInput(), user.get("password"));
            clickSubmit();
    }
}
