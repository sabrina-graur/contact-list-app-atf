package contact.list.project.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPage extends CommonPage {

    @FindBy(id = "logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//h1[text() ='Contact List']")
    private WebElement pageContactListTitle;

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPageContactListTitle() {
        return pageContactListTitle;
    }

    public void clickLogoutButton(){
        actions.clickButton(logoutButton);
    }
}
