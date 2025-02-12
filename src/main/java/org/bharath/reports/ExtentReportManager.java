package org.bharath.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentReportManager {

    private ExtentReportManager() {
    }

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() { // by making his default we are hiding this class to be implemented in other page classes
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        if (Objects.nonNull(test))
            extentTest.set(test);
    }

    static void unload() {
        extentTest.remove();
    }
}
