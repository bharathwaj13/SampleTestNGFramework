package org.bharath.listeners;

import org.bharath.constants.FrameworkConstants;
import org.bharath.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptorListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<Map<String, String>> testDetails = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());
        List<IMethodInstance> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < testDetails.size(); j++) {
                if (list.get(i).getMethod().getMethodName().equalsIgnoreCase(testDetails.get(j).get("testname"))
                        && (testDetails.get(j).get("execute").equalsIgnoreCase("yes"))) {
                    list.get(i).getMethod().setDescription(testDetails.get(j).get("testdescription"));
                    list.get(i).getMethod().setInvocationCount(Integer.parseInt(testDetails.get(j).get("count")));
                    list.get(i).getMethod().setPriority(Integer.parseInt(testDetails.get(j).get("priority")));
                    result.add(list.get(i));
                }
            }


        }
        return result;
    }
}
