package com.sfj.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.sfj.utils.ScreenshotUtils;

public final class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){

        //ExtentManager.getExtentTest().pass(message);
        ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
    public static void fail(String message){

        //ExtentManager.getExtentTest().fail(message);
        ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
    public static void info(String message){

        ExtentManager.getExtentTest().info(message);
        //ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getScreenshot()).build());
    }
}
