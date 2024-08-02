package com.sfj.tests;

import com.sfj.annotations.FrameworkAnnotations;
import com.sfj.pages.LoginPage;
import com.sfj.reports.ExtentManager;
import com.sfj.testdata.TestData;
import com.sfj.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {
//    @DataProvider
//    public static Object[][] getData() {
//        return new Object[][]{
//                {"Admin","admin123","OrangeHR"}
//        };
//    }
    @FrameworkAnnotations(author = "Anand",category = {"smoke","regression"})
    @Test(description = "Sample test description",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void sampleTest(TestData testData)  {
        LoginPage loginPage = new LoginPage();
        String actualtitle = loginPage.loginToApplication(testData.userName,testData.password).getHomePageTitle();
        Assert.assertEquals(actualtitle,testData.title);


    }
}

