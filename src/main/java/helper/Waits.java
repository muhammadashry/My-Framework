package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    private WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWaits(WebDriver driver, int seconds, String locatorPath, String by) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        switch (by) {
            case "xpath":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
                break;
            case "id":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorPath)));
                break;
            case "name":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorPath)));
                break;
            case "linktext":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorPath)));
                break;
            default:
                System.out.println("Error in the locator");
        }


    }
}
