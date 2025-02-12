package org.bharath.tests;

import org.bharath.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {
    }


    @BeforeMethod
    protected void setUp(Object[] object) {
        Map<String, String> map = (Map<String, String>) object[0];
        Driver.initDriver(map.get("browser"), map.get("version"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
