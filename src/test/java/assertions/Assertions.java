package assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Assertions {
    private WebDriver driver;

    public Assertions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertOnPage(WebDriver driver, String expected, String message) {
        Assert.assertEquals(driver.getTitle(), expected, message);
    }
}
