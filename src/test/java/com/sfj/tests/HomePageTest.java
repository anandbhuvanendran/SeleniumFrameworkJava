package com.sfj.tests;

import com.sfj.driver.Driver;
import com.sfj.driver.DriverManager;
import com.sfj.pages.HomePage;
import com.sfj.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest{

    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"Admin","admin123","OrangeHRM"}
        };
    }

    @Test(description = "Verify tile is correct"
    ,dataProvider = "getData")
    public void titleValidationTest(String username,String password,String expectedTitle) throws InterruptedException {
        //Thread.sleep(9000);
//        DriverManager.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//        DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//        DriverManager.getDriver().findElement(By.xpath("//button[text()=' Login ']")).click();
        LoginPage loginPage = new LoginPage();
//        loginPage.setUsername(username);
//        loginPage.setPassword(password);
//        loginPage.clickLoginButton();
        String actualTitle = loginPage.loginToApplication(username,password).getHomePageTitle();
        //Thread.sleep(9000);

       // HomePage homePage = new HomePage();
        //String actualTitle = homePage.getHomePageTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


    }
}
