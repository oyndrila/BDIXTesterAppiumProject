import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestRunner {
    private static final DesiredCapabilities cap = new DesiredCapabilities();
    private static AndroidDriver<MobileElement> driver;
    private DashboardPage dashboardPage;
    private Hamburger ham;
    private ServerListPage server;
    @BeforeAll
    public static void setupDeviceCapabilities() {
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 28");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\shubh\\OneDrive\\Desktop\\Appium automation\\app-debug-universal.apk");
        System.out.println("setupDeviceCapabilities");
    }

    @BeforeEach
    public void spinUpAndroidDriver() {
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        dashboardPage = new DashboardPage(driver);
        System.out.println("spinUpAndroidDriver");
    }

    @Test
    public void testView() throws InterruptedException {
        ServerListPage server = new ServerListPage(driver);
        server.waitUntilStartTextVisible();
        dashboardPage.clickViewButton();
    }

    @Test
    public void testServer() throws InterruptedException {
        testView();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ServerListPage server = new ServerListPage(driver);
        server.waitUntilTvTextIsNotVisible();
        server.clickFTPButton();
        server.clickMovieButton();
        server.clickTVButton();
        server.search();
    }

    @Test
    public void testHamburger() throws InterruptedException {
        ServerListPage server = new ServerListPage(driver);
        server.waitUntilStartTextVisible();
        dashboardPage.hamBurgerImageClick();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        dashboardPage.showServerList();
        Thread.sleep(10000);
    }

    @AfterAll
    public static void stopAndroidDriver() {
        driver.quit();
    }

}
