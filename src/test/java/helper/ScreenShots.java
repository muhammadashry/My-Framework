package helper;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShots {

    public static void takeScreenShot(SelfHealingDriver driver, ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {
            Path dest = Paths.get("D:\\ITI Study\\automation\\Gemy\\failure-screanshots", result.getName() + ".png");
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BYTES));
        } else {
            Path dest = Paths.get("D:\\ITI Study\\automation\\Gemy\\successful-screanshots", result.getName() + ".png");
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BYTES));
        }
    }

}
