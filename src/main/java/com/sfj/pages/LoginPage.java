package com.sfj.pages;

import com.sfj.driver.DriverManager;
import com.sfj.enums.WaitType;
import com.sfj.reports.ExtentLogger;
import com.sfj.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class LoginPage {
    private static final By TXTBOX_USERNAME = By.xpath("//input[@name='username']"); //used only by this class not changed frequently so final and static shared memory
    private static final By TXTBOX_PASSWORD = By.xpath("//input[@name='password']");
//    By btnLogin       = By.xpath("//button[text()=' Login ']");
    private static final By BTN_LOGIN = By.xpath("//button[text()=' Login ']");

    private LoginPage setUsername(String username){
        SeleniumUtils.sendKeys(TXTBOX_USERNAME,username,"Username");
        //ExtentLogger.pass("Username added"); moved the code to Utils
        return this;
    }
    private LoginPage setPassword(String password){
        SeleniumUtils.sendKeys(TXTBOX_PASSWORD,password,"Password");
        //ExtentLogger.pass("Password added");
        return this;
    }
    private HomePage clickLoginButton(){

        SeleniumUtils.click(BTN_LOGIN, WaitType.CLICKABLE,"Login button");
        //ExtentLogger.pass("Login button clicked");
        return new HomePage(); // page chaining
    }


    public HomePage loginToApplication(String username,String password){ // Wrapper method
        return setUsername(username)
                .setPassword(password)
                .clickLoginButton(); // method chaining
    }
}
