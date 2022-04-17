package crossbrowserscropt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserScript {
    protected WebDriver driver;
        // handel el options
    public CrossBrowserScript(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setup(String browser, String version) throws Exception{
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver",version);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }
        else if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else{
            throw new Exception("Browser is not correct");
        }
        return driver;
    }
}