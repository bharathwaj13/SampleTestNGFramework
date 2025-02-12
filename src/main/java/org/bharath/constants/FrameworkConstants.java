package org.bharath.constants;

import org.bharath.enums.ConfigProperties;
import org.bharath.utils.PropertyFileReader;

public final class FrameworkConstants {

    // To restrict from creating objects
    private FrameworkConstants() {
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static final String EXCELPATH = RESOURCESPATH + "/excel/testdata.xlsx";
    private static String extentreportfilepath = "";
    private static final long EXPLICITWAIT = 10;
    private static final String RUNMANAGERSHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "DATA";


    public static String getExcelPath() {
        return EXCELPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static Long getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getRunManagerSheet() {
        return RUNMANAGERSHEET;
    }

    public static String getIterationDataSheet() {
        return ITERATIONDATASHEET;
    }

    public static String getExtentReportFilePath() {
        if (extentreportfilepath.isEmpty()) {
            extentreportfilepath = createReportPath();
        }
        return extentreportfilepath;
    }

    private static String createReportPath(){
        if (PropertyFileReader.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "index.html";
        }
        return EXTENTREPORTFOLDERPATH + "index.html";
    }
}
