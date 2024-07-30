package com.sfj.driver;

import com.sfj.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public final class Driver {
    private Driver(){}
    //public static WebDriver driver; // should be private , add as local variable
    public static void initDriver(){
        String browser = ConfigFactory.getConfig().browser();
        WebDriver driver = DriverFactory.getDriver(browser);
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
