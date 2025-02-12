package org.bharath.pages;

import org.bharath.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage {

    private final By hamburgerMenu = By.id("nav-hamburger-menu");

    public AmazonHamburgerMenuPage clickHamburgerMenu() {
        click(hamburgerMenu, WaitStrategy.CLICKABLE, "HamburgerMenu");
        return new AmazonHamburgerMenuPage();
    }

}
