package com.sfj.listener;

import com.sfj.annotations.FrameworkAnnotations;
import com.sfj.reports.ExtentLogger;
import com.sfj.reports.ExtentManager;
import com.sfj.reports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.setAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
        ExtentReport.setCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " is failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }
    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReport();
    }

}
