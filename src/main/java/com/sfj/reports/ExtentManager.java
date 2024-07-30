package com.sfj.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager(){}
    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    static ExtentTest getExtentTest(){ // made default so that, this method should not accessed by any other classes for login purpose
        return extentTestThreadLocal.get();
    }
    static void setExtentTest(ExtentTest test){
        extentTestThreadLocal.set(test);
    }

}
