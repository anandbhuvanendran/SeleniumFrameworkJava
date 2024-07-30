package com.sfj.utils;

import com.sfj.config.ConfigFactory;
import com.sfj.driver.DriverManager;
import com.sfj.enums.WaitType;
import com.sfj.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    public static void click(By by,String elementName){
        WebElement element = waitUntilElementPresent(by);
        ExtentLogger.pass(elementName + "clicked");
        element.click();
    }
    public static void click(By by, WaitType waitType,String elementName){
        WebElement element = null;
        if(waitType == WaitType.PRESENCE){
            element = waitUntilElementPresent(by);
        }
        else if(waitType == WaitType.CLICKABLE){
            element = waitUntilElementToBeClickable(by);
        }
        ExtentLogger.pass(elementName + "clicked");
        element.click();
    }
    public static void sendKeys(By by,String value,String elementName){
        WebElement element = waitUntilElementPresent(by);
        ExtentLogger.pass("value added to "+elementName);
        element.sendKeys(value);
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));// this will return the element
    }
    private static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ConfigFactory.getConfig().timeout());
        return wait.until(ExpectedConditions.elementToBeClickable(by));// this will return the element
    }
}
