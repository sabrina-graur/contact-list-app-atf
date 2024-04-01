package contact.list.project.configurations.scenario_context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private Map<Object, Object> data;

    private ScenarioContext() {
        data = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void saveData(Object key, Object value) {
        data.put(key, value);
    }

    public Object getData(Object key) {
        return data.get(key);
    }
}
