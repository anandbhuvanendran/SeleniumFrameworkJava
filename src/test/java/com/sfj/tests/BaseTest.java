package com.sfj.tests;

import com.sfj.driver.Driver;
import com.sfj.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Driver.initDriver();
    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
