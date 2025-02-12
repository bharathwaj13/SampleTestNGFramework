package org.bharath.tests;

import org.assertj.core.api.Assertions;
import org.bharath.listeners.RetryFailedTest;
import org.bharath.pages.OrangeHRMDashboardPage;
import org.bharath.pages.OrangeHRMLoginPage;
import org.bharath.reports.ExtentReportImpl;
import org.bharath.utils.DataProviderUtils;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMTests() {
    }

    @Test
    public void loginLogoutTest(Map<String, String> data) {

        String url = new OrangeHRMLoginPage()
                .enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .getUrl();

        Assertions.assertThat(url)
                .containsIgnoringCase("dashboard");

        url = new OrangeHRMDashboardPage()
                .clickUserDropDown()
                .clickLogout()
                .getUrl();

        Assertions.assertThat(url)
                .containsIgnoringCase("login");
    }

    @Test
    public void newTest(Map<String, String> data) {

        String url = new OrangeHRMLoginPage()
                .enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .getUrl();

        Assertions.assertThat(url)
                .containsIgnoringCase("dashboard");

        url = new OrangeHRMDashboardPage()
                .clickUserDropDown()
                .clickLogout()
                .getUrl();

        Assertions.assertThat(url)
                .containsIgnoringCase("login");
    }

}
