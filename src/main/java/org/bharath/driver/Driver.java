package org.bharath.driver;

import org.bharath.enums.ConfigProperties;
import org.bharath.exceptions.DriverInvocationFailedException;
import org.bharath.factories.DriverFactory;
import org.bharath.utils.PropertyFileReader;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browser,String version) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser,version));
            } catch (MalformedURLException e) {
                throw new DriverInvocationFailedException("Please check the capabilities of the browser");
            }
            System.out.println(Thread.currentThread().getId() + " : " + DriverManager.getDriver());
            DriverManager.getDriver().get(PropertyFileReader.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
