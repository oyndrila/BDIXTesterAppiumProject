import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ServerListPage {

    private final By tvServer = MobileAutomation.GenerateByForText("TV");
    private final By ftpServer = MobileAutomation.GenerateByForText("FTP");
    private final By movieServer = MobileAutomation.GenerateByForText("Movie");
    private final By search = MobileAutomation.GenerateByForText("Search");
    private final By startText = MobileAutomation.GenerateByForText("Start Test");

    private final AndroidDriver<MobileElement> driver;

    public ServerListPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public void clickTVButton() {
        driver.findElement(tvServer).click();
    }
    public void clickFTPButton() {
        driver.findElement(ftpServer).click();
    }
    public void clickMovieButton() {
        driver.findElement(movieServer).click();
    }
    public void search() {
        driver.findElement(search).click();
    }

    public void waitUntilTvTextIsNotVisible(){
        MobileAutomation.waitForElementToBeVisible(driver,tvServer);
    }
    public void waitUntilStartTextVisible(){
        MobileAutomation.waitForElementToBeVisible(driver,startText);
    }
}
