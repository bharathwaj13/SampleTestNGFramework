package org.bharath.listeners;

import org.bharath.annotations.FrameworkAnnotations;
import org.bharath.reports.ExtentLogger;
import org.bharath.reports.ExtentReportImpl;
import org.bharath.utils.ELKUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReportImpl.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportImpl.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportImpl.createExtentTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        ExtentReportImpl.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
        ExtentReportImpl.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
   //     ELKUtils.sendDetailsToELK(result.getMethod().getMethodName(), "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
      //  ELKUtils.sendDetailsToELK(result.getMethod().getMethodName(), "fail");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);
        ELKUtils.sendDetailsToELK(result.getMethod().getMethodName(), "skip");
    }

}
