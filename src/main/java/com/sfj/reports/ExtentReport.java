package com.sfj.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sfj.constants.FrameworkConstants;

public final class ExtentReport {
    private ExtentReport(){}
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static void initReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        extent.attachReporter(spark);
    }
    public static void flushReport(){
        extent.flush();
    }
    public static void createTest(String testCaseName){
        extentTest = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(extentTest);
    }
    public static void setAuthor(String authorName){
        ExtentManager.getExtentTest().assignAuthor(authorName);
    }
    public static void setCategory(String[] category){
        ExtentManager.getExtentTest().assignCategory(category);
    }
}
