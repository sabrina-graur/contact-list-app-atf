package contact.list.project.ui.steps;

import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioKey;
import contact.list.project.ui.pages.ContactListPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContactListSteps {
    WebDriver driver = ScenarioContext.getInstance().getData(ScenarioKey.WEB_DRIVER);
    ContactListPage contactListPage = new ContactListPage(driver);

    @When("user clicks logout button")
    public void logout() {
        contactListPage.clickLogoutButton();
    }
}
