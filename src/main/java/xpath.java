import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class xpath {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = MobileAutomation.Capabilities("C:\\Users\\shubh\\OneDrive\\Desktop\\Appium automation\\app-debug-universal.apk");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.Button[@text='VIEW']").click();
        driver.findElement(MobileAutomation.GenerateByForText("TV")).click();
        driver.findElement(MobileAutomation.GenerateByForText("FTP")).click();
        driver.findElement(MobileAutomation.GenerateByForText("Movie")).click();
        driver.findElement(MobileAutomation.GenerateByForText("Search")).click();
        Thread.sleep(5000);
        AndroidElement ps = driver.findElement(MobileAutomation.GenerateByForText("Search Here"));
        ps.click();
        ps.sendKeys("Hello World");
//       driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
//        driver.findElementById("android:id/checkbox").click();
//        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//        driver.findElementByClassName("android.widget.EditText").sendKeys("ebrahim881");
//        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
    }

}
