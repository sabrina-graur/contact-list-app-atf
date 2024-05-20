package contact.list.project.api.steps;

import contact.list.project.api.enums.ErrorMessage;
import contact.list.project.configurations.scenario_context.ScenarioContext;
import contact.list.project.configurations.scenario_context.ScenarioObjectKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonSteps {
    Response response = ScenarioContext.getInstance().getData(ScenarioObjectKey.RESPONSE);

    @Then("response has status code {}")
    public void validateStatusCode(int expectedStatusCode) {
        assertThat("The status code is incorrect", response.getStatusCode(), is(expectedStatusCode));
        LogManager.getLogger().info("The {} status code is received", expectedStatusCode);
    }

    @And("{} error message is displayed")
    public void validateErrorMessage(ErrorMessage type) {
        String expectedErrorMessage = type.getErrorMessageName();
        assertThat("The error message is incorrect", response.jsonPath().getString("message"), is(expectedErrorMessage));
        LogManager.getLogger().info("The following error message is displayed: {}", expectedErrorMessage);
    }
}
