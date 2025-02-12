package org.bharath.tests;

import org.assertj.core.api.Assertions;
import org.bharath.annotations.FrameworkAnnotations;
import org.bharath.enums.CategoryType;
import org.bharath.pages.AmazonHomePage;
import org.testng.annotations.Test;

import java.util.Map;

public class AmazonTests extends BaseTest {

    private AmazonTests() {
    }

    @FrameworkAnnotations(author = {"bharath"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void amazonTest(Map<String, String> data) {
        String title = new AmazonHomePage().clickHamburgerMenu().clickMobilesAndComputers()
                .clickSubMenuItem(data.get("menutext")).getTitle();
        Assertions.assertThat(title)
                .isNotNull().isNotBlank();
    }
}
