package org.bharath.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.bharath.enums.ConfigProperties;
import org.bharath.utils.PropertyFileReader;
import org.bharath.utils.ScreenshotUtils;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentReportManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotRequired) {
        if (PropertyFileReader.get(ConfigProperties.PASSEDSTEPSCREENSHOT).
                equalsIgnoreCase("yes") && isScreenshotRequired) {
            ExtentReportManager.getExtentTest().
                    pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else pass(message);
    }

    public static void fail(String message, boolean isScreenshotRequired) {
        if (PropertyFileReader.get(ConfigProperties.FAILEDSTEPSCREENSHOT).
                equalsIgnoreCase("yes") && isScreenshotRequired) {
            ExtentReportManager.getExtentTest().
                    fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else fail(message);
    }

    public static void skip(String message, boolean isScreenshotRequired) {
        if (PropertyFileReader.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).
                equalsIgnoreCase("yes") && isScreenshotRequired) {
            ExtentReportManager.getExtentTest().
                    skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else skip(message);
    }

}
