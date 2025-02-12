package org.bharath.tests;

import org.bharath.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }

    /**
     * Validate whether title contains Google Search or google search
     * Validate whether the title is not null and the length of the title is greater than 15 and less than 100
     * Check for the links in the pages -> Selenium Tutorial Videos - Automation Testing Tool
     * Number of links displayed exactly is 10 or 15
     */

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("selenium - youtube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        /*Assert.assertTrue(Objects.nonNull(title));
        Assert.assertTrue(title.toLowerCase().contains("Google Search"));
        Assert.assertTrue(title.toLowerCase().matches("[\\w]*google search"));
        Assert.assertTrue(title.length() > 15);
        Assert.assertTrue(title.length() < 100);*/

        //assert using Assertj

        assertThat(title)
                .as("The title is null").isNotNull()
                .containsIgnoringCase("google search")
                .matches("[\\w]*google search")
                .hasSizeBetween(15,100);


        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//a/h3"));

        assertThat(elements)
                .hasSize(14)
                .extracting(WebElement::getText)
                .contains("Selenium Tutorial Videos - Automation Testing Tool");

        /*Assert.assertEquals(elements.size(), 14);
        Assert.assertTrue(elements.stream().anyMatch(e -> e.getText().contains("Selenium Tutorial Videos - Automation Testing Tool")),"Selenium Tutorial link not found");*/
    }

    /*@Test
    public void test3() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Java", Keys.ENTER);

    }*/
}
