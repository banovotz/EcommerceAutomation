package stepmethods;

import runtest.SetDriver;
import runtest.Settings;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class ShareSteps {

    @Before
    public void setUp() {
        SetDriver.initializeChromeDriver(false);
        SetDriver.driver.navigate().to(Settings.ECOMMERCE_HOME);
    }

    @After
    public void tearDown() {
        SetDriver.quitDriver();
    }
}