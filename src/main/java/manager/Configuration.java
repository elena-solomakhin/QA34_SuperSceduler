package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringObjectFactory;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;


//"platformName": "Android",
// "deviceName": "Nex",
// "platformVersion": "8.0",
// "appPackage": "com.example.svetlana.scheduler",
// "appActivity": ".presentation.splashScreen.SplashScreenActivity"
public class Configuration {
    protected static AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(Configuration.class);

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nex9");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName", "Appium");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new ListnerAppium());
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }


}
