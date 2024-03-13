package contact.list.project.configurations.scenario_context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private Map<String, Object> scenarioContext;

    private ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext() {
        return scenarioContext;
    }
}
