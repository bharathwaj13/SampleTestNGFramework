package org.bharath.listeners;

import org.bharath.enums.ConfigProperties;
import org.bharath.utils.PropertyFileReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int counter = 0;
    private int maxRetry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if (PropertyFileReader.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = counter < maxRetry;
            counter++;
        }
        return value;
    }
}
