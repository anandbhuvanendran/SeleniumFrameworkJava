package com.sfj.tests;


import com.sfj.annotations.FrameworkAnnotations;
import com.sfj.pages.LoginPage;
import com.sfj.reports.ExtentManager;
import com.sfj.testdata.TestData;
import com.sfj.utils.DataProviderUtils;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest{

//    @DataProvider
//    public static Object[][] getData() {
//        return new Object[][]{
//                {"Admin","admin123","OrangeHRM"}
//        };
//    }
//@DataSupplier
//public StreamEx<TestData> getData(){
//    return TestDataReader.use(XlsxReader.class)
//            .withTarget(TestData.class)
//            .withSource("testdata.xlsx")
//            .read()
//            .filter(testData -> testData.testCaseName.equalsIgnoreCase("titleValidationTest"));
//
//}

    @FrameworkAnnotations(author = "Sachin",category = {"smoke"})
    @Test(description = "Verify tile is correct",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void titleValidationTest(TestData testData) {

//        DriverManager.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//        DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//        DriverManager.getDriver().findElement(By.xpath("//button[text()=' Login ']")).click();

        LoginPage loginPage = new LoginPage();

//        loginPage.setUsername(username);
//        loginPage.setPassword(password);
//        loginPage.clickLoginButton();

        String actualTitle = loginPage.loginToApplication(testData.userName,testData.password).getHomePageTitle();

        //Thread.sleep(9000);

       // HomePage homePage = new HomePage();
        //String actualTitle = homePage.getHomePageTitle();

        Assert.assertEquals(actualTitle,testData.title);


    }
}
