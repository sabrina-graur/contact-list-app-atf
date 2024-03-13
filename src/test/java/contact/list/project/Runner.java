package contact.list.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:reports/cucumber-report/cucumber-report.json",
                "html:reports/cucumber-report/cucumber-report-html"
        },
        tags = "@UI",
        features = {"src/test/resources/features"},
        glue = {"contact.list.project"}
)
class Runner {
}
