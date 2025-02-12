package org.bharath.pages;

import org.bharath.driver.DriverManager;
import org.bharath.enums.WaitStrategy;
import org.bharath.factories.ExplicitWaitFactory;
import org.bharath.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    protected void click(By locator, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.getExplicitWait(strategy, locator);
        element.click();
        try {
            ExtentLogger.pass(elementName + " is clicked successfully", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void clickUsingActions(By locator, WaitStrategy strategy, String elementName) {

        WebElement element = ExplicitWaitFactory.getExplicitWait(strategy, locator);
        new Actions(DriverManager.getDriver()).moveToElement(element).click();
        try {
            ExtentLogger.pass(elementName + " is clicked successfully", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendKeys(By locator, String value, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.getExplicitWait(strategy, locator);
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value + " is successfully entered in " + elementName, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getPageUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void switchToFrame(String nameOrId) {
        DriverManager.getDriver().switchTo().frame(nameOrId);
    }

}
