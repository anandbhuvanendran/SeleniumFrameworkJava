package com.sfj.tests;

import com.sfj.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {
    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"Admin","admin123","OrangeHR"}
        };
    }
    @Test(dataProvider = "getData")
    public void sampleTest(String username,String password,String expectedTitle)  {
        LoginPage loginPage = new LoginPage();
        String actualtitle = loginPage.loginToApplication(username,password).getHomePageTitle();
        Assert.assertEquals(actualtitle,expectedTitle);

    }
}

