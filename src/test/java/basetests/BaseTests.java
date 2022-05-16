package basetests;

import assertions.Assertions;
import com.epam.healenium.SelfHealingDriver;
import crossbrowserscropt.CrossBrowserScript;
import helper.Logs;
import helper.Reader;
import helper.ScreenShots;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseTests extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Reader locatorReader;
    protected Properties properties;
    protected CrossBrowserScript crossBrowserScript;
    protected String Node = "http://localhost:4444/wd/hub";
    protected DesiredCapabilities caps;
    private Logs log;
    private Assertions assertions;

    @BeforeSuite
    @Parameters({"browser", "userGrid"})
    public void setUp(@Optional("chrome") String browserName, @Optional("true") Boolean useGrid) throws Exception {
        if (useGrid == true) {
            caps = new DesiredCapabilities();
            caps.setBrowserName(browserName);
            driver = new RemoteWebDriver(new URL(Node), caps);
        }
        assertions = new Assertions(driver);
        FileInputStream objFile = new FileInputStream("D:\\ITI Study\\automation\\Gemy\\src\\main\\resources\\config.properties");
        properties = new Properties();
        properties.load(objFile);
        log = new Logs(driver);
        crossBrowserScript = new CrossBrowserScript(driver);
        driver = crossBrowserScript.setup(browserName, properties.getProperty("browser.version"));
        homePage = new HomePage(driver);
        locatorReader = new Reader(driver);
        driver.get(properties.getProperty("site.automationpractice.url"));
        assertions.assertOnPage(driver, "My Store", "es7aa");
        log.getLog("Open browser");
    }

    @AfterMethod
    public void recoredFaliures(ITestResult result) throws IOException {
            ScreenShots.takeScreenShot((SelfHealingDriver) driver,result);
        }
    @AfterSuite
    public void tearDown() {
        driver.quit();
        log.getLog("Tear Down");
    }
}
