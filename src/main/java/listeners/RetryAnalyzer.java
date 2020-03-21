package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;

    private int maxCount = 3;

    @Override

    public boolean retry(ITestResult result) {
        if (count < maxCount) {
            count++;
            System.out.println("Retry #"+count+" for test: "+result.getMethod().getMethodName());
            return true;
        }
        return false;
    }
}