package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Actions {
    private WebDriver driver;
    private Logs log = new Logs(driver);
    public Actions(WebDriver driver) {
        this.driver = driver;
    }

    public void makeAction(String by, String locator, boolean click){
        switch (by){
            case "xpath":
                if(click==true) {
                    driver.findElement(By.xpath(locator)).click();
                    log.getLog("Get this locator: " + locator);
                }
                else
                    driver.findElement(By.xpath(locator));
                    log.getLog("Get this locator: " + locator);
                break;
            case "id":
                if(click==true) {
                    driver.findElement(By.id(locator)).click();
                    log.getLog("Get this locator: " + locator);
                }
                else
                    driver.findElement(By.id(locator));
                    log.getLog("Get this locator: " + locator);
                break;
            case "name":
                if(click==true) {
                    driver.findElement(By.name(locator)).click();
                    log.getLog("Get this locator: " + locator);
                }
                else
                    driver.findElement(By.name(locator));
                    log.getLog("Get this locator: " + locator);
                break;
            default:
                System.out.println("Error in the locator");
        }
    }
    public void makeAction(String by, String locator, String sendKeys){
        switch (by){
            case "xpath":
                    driver.findElement(By.xpath(locator)).sendKeys(sendKeys);
                    log.getLog("Get this locator: " + locator + "Send this Key " + sendKeys);
                break;
            case "id":
                    driver.findElement(By.id(locator)).sendKeys(sendKeys);
                    log.getLog("Get this locator: " + locator + "Send this Key " + sendKeys);

                break;
            case "name":
                    driver.findElement(By.name(locator)).sendKeys(sendKeys);
                    log.getLog("Get this locator: " + locator + "Send this Key " + sendKeys);
                break;
            default:
                System.out.println("Error in the locator");
        }
    }
    public void makeAction(String webElement,String optionValue ){
        WebElement optionList = driver.findElement(By.id(webElement));
        Select selectOptions = new Select(optionList);
        selectOptions.selectByValue(optionValue);
    }
}
