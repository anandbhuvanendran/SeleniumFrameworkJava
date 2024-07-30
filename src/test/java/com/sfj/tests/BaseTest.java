package com.sfj.tests;

import com.sfj.driver.Driver;
import com.sfj.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){
        ExtentReport.initReport();

    }
    @AfterSuite
    public void afterSuite(){
        ExtentReport.flushReport();

    }

    @BeforeMethod
    public void setup(Method method) {
        ExtentReport.createTest(method.getName());
        Driver.initDriver();
    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
