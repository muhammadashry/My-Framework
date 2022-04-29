package pages;

import helper.Logs;
import helper.MyActions;
import helper.Reader;
import helper.Waits;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageBase {
    protected WebDriver driver;
    protected Waits timeToWait;
    protected MyActions action;
    protected Logs log;
    protected Reader reader;
    protected Properties propertie;

    public PageBase(WebDriver driver) throws IOException {
        this.driver = driver;
        timeToWait = new Waits(driver);
        action = new MyActions(driver);
        log = new Logs(driver);
        reader = new Reader(driver);
        FileInputStream objFile = new FileInputStream("D:\\ITI Study\\automation\\Gemy\\src\\main\\resources\\config.properties");
        propertie = new Properties();
        propertie.load(objFile);
    }

    public String getLocatorsFromJsonFile(String keyword) throws IOException, ParseException {

        return reader.getLocatorsFromJsonFile(keyword, propertie.getProperty("json.locator.path"));
    }
}
