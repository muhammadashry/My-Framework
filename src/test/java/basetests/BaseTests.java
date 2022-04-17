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
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTests extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Reader dataReader,locatorReader,excelReader;
    protected Properties properties;
    protected JSONArray locators;
    protected  JSONObject users;
    protected CrossBrowserScript crossBrowserScript;
    private Logs log;
    private Assertions assertions;

    @BeforeClass
    @Parameters({"broswer"})
    public void setUp(@Optional("firefox") String broswerName) throws Exception {
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
        assertions.assertOnPage(driver,"My Store","es7aa");
        log.getLog("Open browser");
    }
    @AfterMethod
    public void recoredFaliures(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            Path dest = Paths.get("./ScreanShots",result.getName() + ".png");
            var camera = (TakesScreenshot)driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            Files.move(screenShot, new File("D:\\Gemys_Data_Tasks\\"+ " " +result.getName() + ".png"));

        }
    }
    public String getDataFromJsonFile(String keyword, int index) throws IOException, ParseException {
        locators = locatorReader.getAllUsersLocators(properties.getProperty("json.locator.path"));
        log.getLog("Get All Locators");
        users = (JSONObject) locators.get(index);
        log.getLog("Get Locator for: " + keyword);
        return  (String) users.get(keyword);
    }
    /*@AfterClass
    public void tearDown(){
        driver.quit();
        log.getLog("Tear Down");
    }*/
}
