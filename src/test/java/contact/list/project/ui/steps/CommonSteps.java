package contact.list.project.ui.steps;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.driverfactory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonSteps {

    @Given("user is on {string}")
    public void isOnPage(String pageName) {
        DriverManager.getDriver().get(PropertiesManager.getPage(pageName));
    }

    @Then("user is taken to the {string}")
    public void navigateToPage(String pageName) {
        String expectedUrl = PropertiesManager.getPage(pageName);
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue("Expected URL: " + expectedUrl + ", Actual URL: " + actualUrl, actualUrl.contains(expectedUrl));
    }
}
