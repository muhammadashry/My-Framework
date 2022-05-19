package helper;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.URL;

public class CrossBrowser {
    protected SelfHealingDriver driver;
    protected WebDriver delegate;
    protected String Node = "http://localhost:4444/wd/hub";
    protected DesiredCapabilities caps;

    public CrossBrowser(WebDriver driver) {
        this.delegate = driver;
    }

    public SelfHealingDriver setup(String browser, String version,Boolean useGrid) throws Exception {
        if (useGrid == true) {
            caps = new DesiredCapabilities();
            caps.setBrowserName(browser);
            delegate = new RemoteWebDriver(new URL(Node), caps);
        }
         if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            delegate = new FirefoxDriver();
            driver = SelfHealingDriver.create(delegate);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", version);
            delegate = new ChromeDriver();
            driver = SelfHealingDriver.create(delegate);
            driver.manage().window().maximize();
            return driver;
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", version);
            delegate = new EventFiringWebDriver(new ChromeDriver(options.addArguments("--headless")));
            driver = SelfHealingDriver.create(delegate);
            return driver;
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            delegate = new EdgeDriver();
            driver = SelfHealingDriver.create(delegate);
        } else {
            throw new Exception("Browser is not correct");
        }
        return driver;
    }
}
