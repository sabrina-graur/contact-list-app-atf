package contact.list.project.ui.steps;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import contact.list.project.ui.pages.ContactListPage;
import contact.list.project.utils.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    WebDriver driver = ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER);
    ContactListPage contactListPage = new ContactListPage(driver);

    @Given("user is on {string}")
    public void isOnPage(String pageName) {
        driver.get(PropertiesManager.getPage(pageName));
    }

    @Then("user is taken to the {string}")
    public void navigateToPage(String pageName) {
        String expectedUrl = PropertiesManager.getPage(pageName);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("Expected URL: " + expectedUrl + ", Actual URL: " + actualUrl, actualUrl.contains(expectedUrl));
    }

    @Then("{string} page is displayed")
    public void isPageDisplayed(String title) {
        WaitUtils.waitForElementToBeDisplayed(contactListPage.getPageContactListTitle(), PropertiesManager.checkElementIsDisplayedTimeout());
        Assert.assertEquals(title, contactListPage.getPageContactListTitle().getAccessibleName());
    }
}
