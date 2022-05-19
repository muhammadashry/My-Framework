package basetests;

import assertions.Assertions;
import com.epam.healenium.SelfHealingDriver;
import helper.CrossBrowser;
import helper.Logs;
import helper.Reader;
import helper.ScreenShots;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class BaseTests extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Properties properties;
    protected CrossBrowser crossBrowser;
    private Logs log;
    private Assertions assertions;

    @BeforeTest
    @Parameters({"browser", "userGrid"})
    public void setUp(@Optional("chrome") String browser, @Optional("false") Boolean useGrid) throws Exception {
        FileInputStream objFile = new FileInputStream("D:\\ITI Study\\automation\\Gemy\\src\\main\\resources\\config.properties");
        properties = new Properties();
        properties.load(objFile);
        log = new Logs();
        crossBrowser = new CrossBrowser(driver);
        driver = crossBrowser.setup(browser, properties.getProperty("browser.version"),useGrid);
        assertions = new Assertions(driver);
        homePage = new HomePage(driver);
        driver.get(properties.getProperty("site.automationpractice.url"));
        assertions.assertOnPage(driver, "My Store", "es7aa");
        log.getLog("Open browser");
    }

    @AfterMethod
    public void recoredFaliures(ITestResult result) throws IOException {
            ScreenShots.takeScreenShot((SelfHealingDriver) driver,result);
        }
    @AfterTest
    public void tearDown() {
        driver.quit();
        log.getLog("Tear Down");
    }
}
