package contact.list.project.configurations.browserstack;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackConfiguration {
    public WebDriver driverBrowserStack;
    public static String userName, accessKey;
    public static Map<String, Object> browserStackYamlMap;

    public BrowserStackConfiguration() {
        File file = new File("src/test/resources/browserstack.yml");
        browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
    }

    @Before
    public void setUp() {
        MutableCapabilities capabilities = new MutableCapabilities();
        userName = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : (String) browserStackYamlMap.get("userName");
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : (String) browserStackYamlMap.get("accessKey");
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        capabilities.setCapability("browserName", "chrome");
        browserstackOptions.put("osVersion", "12.0");
        browserstackOptions.put("deviceName", "Samsung Galaxy S22");
        browserstackOptions.put("deviceOrientation", "portrait");
        capabilities.setCapability("bstack:options", browserstackOptions);
        try {
            driverBrowserStack = new RemoteWebDriver(
                    new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName, accessKey)), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        driverBrowserStack.quit();
    }

    private Map<String, Object> convertYamlFileToMap(File yamlFile, Map<String, Object> map) {
        try {
            InputStream inputStream = Files.newInputStream(yamlFile.toPath());
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);
            map.putAll(config);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Malformed browserstack.yml file - %s.", e));
        }
        return map;
    }
}

//        bStackOptions.put("source", "junit4:sample-master:v1.2");
//        capabilities.setCapability("bstack:options", bStackOptions);