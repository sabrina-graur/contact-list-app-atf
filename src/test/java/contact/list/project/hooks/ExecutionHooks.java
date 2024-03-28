package contact.list.project.hooks;

import contact.list.project.configurations.driverfactory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class ExecutionHooks {

    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();
    }
}

