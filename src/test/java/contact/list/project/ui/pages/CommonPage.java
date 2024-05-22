package contact.list.project.ui.pages;

import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.ui.browser.BrowserActions;
import org.apache.logging.log4j.LogManager;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public abstract class CommonPage {

    BrowserActions action = new BrowserActions();

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//h1")
    private WebElement commonTitle;

    public CommonPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickSubmit() {
        action.clickButton(submitButton);
    }

    public WebElement getPageTitle(String title) {
        try {
            String titleLocator = "//h1[text()='%s']";
            return DriverManager.getDriver().findElement(By.xpath(String.format(titleLocator, title)));
        } catch (NoSuchElementException e) {
            LogManager.getLogger().warn("No title with the following text: {}", title);
        }
        return commonTitle;
    }

    public void validatePageTitle(String expectedTitle) {
        Awaitility.await()
                .atMost(PropertiesManager.checkElementIsDisplayedTimeout())
                .untilAsserted(() -> assertEquals("Page title does not match", expectedTitle, getPageTitle(expectedTitle).getText()));
        LogManager.getLogger().info("The title with the following text: \"{}\" is displayed", expectedTitle);
    }
}
