package org.bharath.factories;

import org.bharath.enums.ConfigProperties;
import org.bharath.utils.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory() {
    }

    static WebDriver driver = null;

    public static WebDriver getDriver(String browser, String version) throws MalformedURLException {
        System.out.println("version: " + version);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (PropertyFileReader.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                Map<String, Object> selenoidOptions = new HashMap<>();
                selenoidOptions.put("enableVNC", true);
                selenoidOptions.put("enableVideo", true);
                options.addArguments("--headless=new");
                /*options.addArguments("--disable-gpu");*/
                options.setCapability("browserName", "chrome");
                options.setCapability("browserVersion", version);
               // options.setCapability("selenoid:options", selenoidOptions);
                driver = new RemoteWebDriver(new URL(PropertyFileReader.get(ConfigProperties.SELENIUMGRIDURL)), options);
            } else {
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (PropertyFileReader.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("browserName", "firefox");
                options.setCapability("browserVersion", version);
                driver = new RemoteWebDriver(new URL(PropertyFileReader.get(ConfigProperties.SELENIUMGRIDURL)), options);
            }
        } else {
            driver = new FirefoxDriver();
        }

        return driver;
    }
}

