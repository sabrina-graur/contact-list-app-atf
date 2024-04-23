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

    BrowserActions actions = new BrowserActions();
    private static final String TITLE_LOCATOR = "//h1[text()='%s']";

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//h1")
    private WebElement commonTitle;

    public CommonPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickSubmit() {
        actions.clickButton(submitButton);
    }

    public WebElement getPageTitle(String title) {
        try {
            return DriverManager.getDriver().findElement(By.xpath(String.format(TITLE_LOCATOR, title)));
        } catch (NoSuchElementException e) {
            LogManager.getLogger().warn("No title with the following text: {}", title);
        }
        return commonTitle;
    }

    public void assertPageTitle(String expectedTitle) {
        WebElement pageTitleElement = getPageTitle(expectedTitle);
        String actualTitle = pageTitleElement.getText();
        Awaitility.await()
                .atMost(PropertiesManager.checkElementIsDisplayedTimeout())
                .untilAsserted(() -> {
                    assertEquals("Page title does not match", expectedTitle, actualTitle);
                });
        LogManager.getLogger().info("The title with the following text: \"{}\" is displayed", expectedTitle);
    }
}
