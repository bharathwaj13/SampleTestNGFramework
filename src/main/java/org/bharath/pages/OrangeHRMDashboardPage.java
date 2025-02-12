package org.bharath.pages;

import org.bharath.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMDashboardPage extends BasePage{

    private final By linkUserDropDown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By linkLogout = By.xpath("//a[text()='Logout']");


    public OrangeHRMDashboardPage clickUserDropDown() {
        click(linkUserDropDown, WaitStrategy.CLICKABLE,"User Dropdown");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(linkLogout, WaitStrategy.CLICKABLE,"Logout Link");
        return new OrangeHRMLoginPage();
    }

    public String getUrl(){
        return getPageUrl();
    }
}
