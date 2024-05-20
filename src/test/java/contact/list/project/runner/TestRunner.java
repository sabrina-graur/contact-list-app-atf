package contact.list.project.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/cucumber-report/cucumber-report-html"
        },
        tags = "@UI or @API or @Negative",
        features = {"src/test/resources/features"},
        glue = {"contact.list.project.ui.steps", "contact.list.project.hooks", "contact.list.project.api.steps"}
)
public class TestRunner {
}
