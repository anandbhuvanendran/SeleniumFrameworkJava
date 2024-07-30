package com.sfj.pages;

import com.sfj.driver.DriverManager;
import com.sfj.pages.pagecomponents.FooterMenuComponent;
import com.sfj.pages.pagecomponents.LeftMenuComponent;

public class HomePage {
    // A home page has top menu --> Composition HAS A relationship
    private LeftMenuComponent leftMenuComponent;
    private FooterMenuComponent footerMenuComponent;
    public HomePage(){
        leftMenuComponent = new LeftMenuComponent();
        footerMenuComponent = new FooterMenuComponent();

    }
    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    public void clickOnAdmin(){
        leftMenuComponent.clickOnAdminTabInLeftMenu();
    }
    public void getFooterText(){
        footerMenuComponent.getFooterText();
    }
}
