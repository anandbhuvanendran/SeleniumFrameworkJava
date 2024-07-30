package com.sfj.pages.pagecomponents;

import com.sfj.driver.DriverManager;
import com.sfj.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class LeftMenuComponent {
    private static final By LINK_ADMIN = By.xpath("//span[text()='Admin']");
    public void clickOnAdminTabInLeftMenu()
    {
        SeleniumUtils.click(LINK_ADMIN,"Admin tab");
    }
}
