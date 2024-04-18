package contact.list.project.ui.pages;

import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import contact.list.project.ui.browser.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    Actions actions = new Actions(ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER));
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public void clickSubmit() {
        actions.clickButton(submitButton);
    }

//    public By getPageElementByName(String elementName) {
//        return switch (elementName) {
//            case "Logout Button" -> ContactListPage.logoutButton;
//            case "Contact List Page Title" -> ContactListPage.pageContactListTitle;
//            default -> throw new IllegalArgumentException("Unknown element name: " + elementName);
//        };
//    }
}
