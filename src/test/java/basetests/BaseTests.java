package basetests;

import assertions.Assertions;
import com.google.common.io.Files;
import crossbrowserscropt.CrossBrowserScript;
import helper.Logs;
import helper.Reader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTests extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Reader dataReader, locatorReader, excelReader;
    protected Properties properties;
    protected JSONArray locators;
    protected JSONObject users;
    protected CrossBrowserScript crossBrowserScript;
    private Logs log;
    private Assertions assertions;

    @BeforeClass
    @Parameters({"broswer"})
    public void setUp(@Optional("chrome") String broswerName) throws Exception {
        assertions = new Assertions(driver);
        FileInputStream objFile = new FileInputStream("D:\\ITI Study\\automation\\Gemy\\src\\main\\resources\\config.properties");
        properties = new Properties();
        properties.load(objFile);
        log = new Logs(driver);
        crossBrowserScript = new CrossBrowserScript(driver);
        driver = crossBrowserScript.setup(broswerName, properties.getProperty("browser.version"));
        homePage = new HomePage(driver);
        dataReader = new Reader(driver);
        locatorReader = new Reader(driver);
        excelReader = new Reader(driver);
        driver.get(properties.getProperty("site.automationpractice.url"));
        assertions.assertOnPage(driver, "My Store", "es7aa");
        log.getLog("Open browser");
    }

    @AfterMethod
    public void recoredFaliures(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            Path dest = Paths.get("./failure-screanshots", result.getName() + ".png");
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
        else{
            Path dest = Paths.get("./successful-screanshots", result.getName() + ".png");
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
    // Move it to reader class make mapping
    public String getLocatorsFromJsonFile(String keyword) throws IOException, ParseException {
        return locatorReader.getLocatorsFromJsonFile(keyword,properties.getProperty("json.locator.path"));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        log.getLog("Tear Down");
    }
}
