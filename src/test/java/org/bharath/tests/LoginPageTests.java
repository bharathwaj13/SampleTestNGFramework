package org.bharath.tests;

import org.bharath.driver.Driver;
import org.bharath.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests  extends BaseTest{

    private LoginPageTests(){}

    @Test
    public void test1() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);

    }

}
