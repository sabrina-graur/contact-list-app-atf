package contact.list.project.configurations.scenario.context;

import contact.list.project.enums.ScenarioObjectKey;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private Map<ScenarioObjectKey, Object> data;

    private ScenarioContext() {
        data = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void saveData(ScenarioObjectKey key, Object value) {
        data.put(key, value);
    }

    public <T> T getData(ScenarioObjectKey key) {
        return (T) data.get(key);
    }

    public void clearData() {
        data.clear();
    }
}
