package Tests;
 
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
 
public class BaseClass {
 
    AppiumDriver driver;
 
    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
 
            // Platform Name
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
 
            // Platform Version
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
 
            // Device Name
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Poco M2");
 
            // Unique Device Identifier
            caps.setCapability(MobileCapabilityType.UDID, "0ab4cad80407"); // Replace with actual UDID
 
            // Automation Name
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
 
            // Appium Server URL
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
 
            // Initialize the Appium Driver
          //  driver = new AndroidDriver<>(url, caps);
 
        } catch (Exception exp) {
            System.out.println("Error cause is : " + exp.getCause());
            System.out.println("Message is : " + exp.getMessage());
            exp.printStackTrace();
            throw new RuntimeException("Driver setup failed!");
        }
    }
 
    @Test
    public void testExample() {
        // Example test logic
        System.out.println("Driver is running: " + (driver != null));
    }
 
    @AfterTest
    public void teardown() {
        // Quit the driver after tests
        if (driver != null) {
            driver.quit();
        }
    }
}