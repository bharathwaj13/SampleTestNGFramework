package org.bharath.pages;

import org.bharath.enums.WaitStrategy;
import org.bharath.utils.DecodeUtils;
import org.openqa.selenium.By;


public final class OrangeHRMLoginPage extends BasePage {

    // Assertions should not be present in Page Classes

    private final By textboxUsername = By.xpath("//input[@name='username']");
    private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By buttonSubmit = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginPage enterUsername(String username) {
        sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, "Username textbox");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(textboxPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE, "Password textbox");
        return this;
    }

    public OrangeHRMDashboardPage clickLogin() {
        click(buttonSubmit, WaitStrategy.CLICKABLE, "Login button");
        return new OrangeHRMDashboardPage();
    }

    public String getUrl() {
        return getPageUrl();
    }

}
