package org.bharath.utils;

import org.bharath.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String, String>> testData = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {
        String testName = m.getName();
        if (testData.isEmpty()) {
            testData = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
        }
        List<Map<String, String>> resultList = new ArrayList<>();

        for (int i = 0; i < testData.size(); i++) {
            if (testData.get(i).get("testname").equalsIgnoreCase(testName)
                    && (testData.get(i).get("execute").equalsIgnoreCase("yes"))) {
                resultList.add(testData.get(i));
            }
        }
        return resultList.toArray();
    }
}
