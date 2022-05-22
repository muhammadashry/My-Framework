package helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logs {
    static Logger log;

    public void getLog(String logKeyWord) {
        log = Logger.getLogger("devpinoyLogger");
        PropertyConfigurator.configure("D:\\ITI Study\\automation\\Gemy\\src\\main\\resources\\log4j.properties");
        log.debug(logKeyWord);
    }
}
