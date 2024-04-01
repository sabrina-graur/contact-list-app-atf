package contact.list.project.ui.steps;

import contact.list.project.configurations.properties.PropertiesManager;
import contact.list.project.configurations.driverfactory.DriverManager;
import contact.list.project.ui.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CommonSteps {

    @Given("user navigates to {string}")
    public static void goToPage(String pageName) throws InterruptedException {
        DriverManager.getDriver().get(PropertiesManager.getPage(pageName));
        Thread.sleep(3000);
    }

    @When("user performs registration with valid data")
    public void registerUserWithValidValues() throws InterruptedException {
        SignUpPage.addUser();
        Thread.sleep(5000);
    }

    @Then("user is taken to the {string}")
    public static void isOnPage(String pageName) throws InterruptedException {
        String expectedUrl = PropertiesManager.getPage(pageName);
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue("Expected URL: " + expectedUrl + ", Actual URL: " + actualUrl, actualUrl.contains(expectedUrl));
        Thread.sleep(5000);
    }

    public static void populateField(By inputField, String value) {
        DriverManager.getDriver().findElement(inputField).sendKeys(value);
    }
}
