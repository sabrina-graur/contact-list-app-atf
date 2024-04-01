package contact.list.project.ui.steps;

import contact.list.project.ui.pages.ContactListPage;
import io.cucumber.java.en.When;

public class ContactListSteps {

    @When("user clicks logout button")
    public void logout() {
        ContactListPage.clickLogout();
    }
}
