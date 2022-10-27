import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private final By viewButtonLocator = MobileAutomation.GenerateByForText("VIEW");
//    private final By startButtonLocator = MobileAutomation.GenerateByForText("Start Test");
    //    private final By hamlocator = MobileAutomation.imageSelector("com.shubhobrata.roy.bdixtester.tester:id/iv_menu_acceser");
//    private final By menuLocator = MobileAutomation.showServerList("Show Server List");;
    private AndroidDriver<MobileElement> driver;

    public DashboardPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }


    public void clickViewButton() {
        driver.findElement(viewButtonLocator).click();
    }
    public void waitUntilStartTestNotVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.Button[contains(@resource-id, 'com.shubhobrata.roy.bdixtester.tester:id/btn_start_testing\n')]")));
    }

    public void hamBurgerImageClick() {
       driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.shubhobrata.roy.bdixtester.tester:id/iv_menu_acceser']")).click();
    }
    public void showServerList(){
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Show Server List']")).click();
    }
}

