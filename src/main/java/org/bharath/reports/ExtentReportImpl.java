package org.bharath.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.bharath.constants.FrameworkConstants;
import org.bharath.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public final class ExtentReportImpl {

    private ExtentReportImpl() {
    }

    private static ExtentReports extent;

    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Orange HRM Test Report");
            spark.config().setReportName("Automation Test");
        }

    }

    public static void createExtentTest(String testcase, String description) {
        ExtentReportManager.setExtentTest(extent.createTest(testcase, description));
    }

    public static void addAuthors(String[] authors) {
        Arrays.stream(authors).forEach(a -> ExtentReportManager.getExtentTest().assignAuthor(a));
    }

    public static void addCategories(CategoryType[] categories) {
        Arrays.stream(categories).forEach(a -> ExtentReportManager.getExtentTest().assignCategory(a.name()));
    }

    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentReportManager.unload();
        }
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
