package helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    int counter = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < 2) {
            counter++;
            return true;
        }
        return false;
    }
}
