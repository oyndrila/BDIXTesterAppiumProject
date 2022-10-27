import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileAutomation {
    public static AndroidDriver<AndroidElement> Capabilities(String s) throws MalformedURLException {

        File f = new File(s);
        //DesiredCapabilities are a set of key-value pairs encoded as a JSON object.
        //different environment (browser, mobile, or an operating system)
        DesiredCapabilities cap = new DesiredCapabilities();

        //The setCapability() method is used to declare the properties of test environments like device name,
        //operating system name, operating system versions, browser, and browser versions.
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Md.EbrahimHossain");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 28");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        return driver;
    }

    public static By GenerateByForText(String text) {
        return By.xpath("//*[@text='" + text + "']");
    }

    public static void waitForElementToBeVisible(AndroidDriver driver, By elementSelectionLogic)
    {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelectionLogic));
    }
    public static By imageSelector(String id)
    {
        return By.xpath("id");
    }
}
