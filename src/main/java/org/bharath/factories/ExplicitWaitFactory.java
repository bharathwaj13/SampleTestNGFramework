package org.bharath.factories;

import org.bharath.constants.FrameworkConstants;
import org.bharath.driver.DriverManager;
import org.bharath.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory(){}

    public static WebElement getExplicitWait(WaitStrategy strategy, By locator) {
        WebElement element = null;
        if (strategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (strategy == WaitStrategy.VISIBILITY) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else if (strategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(locator));
            // wait.until(d->d.findElement(linkLogout).isEnabled());  -> Java8
        } else if (strategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(locator);
        }
        return element;
    }

}
