package com.sfj.driver;

import com.sfj.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public final class Driver {
    private Driver(){}
    //public static WebDriver driver; // should be private , add as local variable
    public static void initDriver() throws MalformedURLException {
        String browser = ConfigFactory.getConfig().browser();
        String runmode = ConfigFactory.getConfig().runmode();
        WebDriver driver = DriverFactory.getDriver(browser,runmode);
        if(DriverManager.getDriver() == null) {
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }

    }
    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
