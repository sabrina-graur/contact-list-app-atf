package contact.list.project.configurations.logger;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerHelper {
    public static void setLogFileName(Scenario scenario) {
        String scenarioName = scenario.getName().trim().replaceAll(" ", "_");
        ThreadContext.put("scenarioName", scenarioName);
        Configurator.reconfigure();
    }
}
