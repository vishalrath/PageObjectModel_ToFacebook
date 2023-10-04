package com.Edureka.facebook.test;

import com.Edureka.facebook.base.TestBase;
import com.Edureka.facebook.pages.DiscoverPage;
import com.Edureka.facebook.pages.GroupPage;
import com.Edureka.facebook.pages.HomePage;
import com.Edureka.facebook.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;
    GroupPage groupPage;
    DiscoverPage discoverPage;

    public GroupPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
       // groupPage = homepage.clickOnGroups();
        discoverPage = groupPage.clickOnDiscover();
    }

    @Test(priority = 1)
    public void verifyDiscoverPageTitleTest() {
        String groupsPageTitle = groupPage.verifyGroupsPageTitle();
        Assert.assertEquals(groupsPageTitle, "Groups | Facebook", "GroupsPage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnWorkAndEduaction() {
        discoverPage = groupPage.clickOnDiscover();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
