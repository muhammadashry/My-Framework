package helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Logs {
    private WebDriver driver;
    static Logger log;

    public Logs(WebDriver driver) {
        this.driver = driver;

    }
    public void getLog(String logKeyWord) {
        log = Logger.getLogger("devpinoyLogger");
        PropertyConfigurator.configure("D:\\ITI Study\\automation\\Gemy\\src\\main\\resources\\log4j.properties");
        log.debug(logKeyWord);
    }
}
