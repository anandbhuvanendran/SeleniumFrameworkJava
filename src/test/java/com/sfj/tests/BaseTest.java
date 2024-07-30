package com.sfj.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sfj.config.FrameworkConfig;
import com.sfj.driver.Driver;
import com.sfj.reports.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

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
