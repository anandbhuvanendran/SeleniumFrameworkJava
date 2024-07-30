package com.sfj.pages.pagecomponents;

import com.sfj.driver.DriverManager;
import org.openqa.selenium.By;

public class FooterMenuComponent {
    private static final By TXT_FOOTER = By.xpath("//p[text()='OrangeHRM OS 5.6.1']");
    public String getFooterText(){

        return DriverManager.getDriver().findElement(TXT_FOOTER).getText();
    }
}
