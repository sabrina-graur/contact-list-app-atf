package contact.list.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/evidence/reports/cucumber-report/cucumber-report-html"
        },
        tags = "@API or @UI",
        features = {"src/test/resources/features"},
        glue = {"contact.list.project"}
)
class Runner {
}
