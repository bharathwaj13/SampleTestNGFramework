package org.bharath.pages;

import org.bharath.enums.WaitStrategy;
import org.bharath.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public class AmazonHamburgerMenuPage extends BasePage {

    private final By linkMobileComputers = By.xpath("//div[text()='Mobiles, Computers']/parent::a");

    private String linkSubMenu = "//a[text()='%s']";

    public AmazonLaptopPage clickSubMenuItem(String menuText) {
        String xpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);
        System.out.println("xpath: " + xpath);
        clickUsingActions(By.xpath(xpath), WaitStrategy.CLICKABLE, menuText);
        if (menuText.equalsIgnoreCase("laptops")) {
            return new AmazonLaptopPage();
        }
        return null;
    }

    public AmazonHamburgerMenuPage clickMobilesAndComputers() {
        click(linkMobileComputers, WaitStrategy.CLICKABLE, "Mobiles & Computers");
        return this;
    }

}
