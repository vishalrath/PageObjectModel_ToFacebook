package com.bridgelabz.facebook.test;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelaz.facebook.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;
    ProfilePage profilePage;
    FriendsPage friendspage;
    Welcomepage welcomepage;
    GroupPage groupPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        friendspage = new FriendsPage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

//    @Test(priority = 1)
//    public void HomePageTitleTest() {
//        homepage = new HomePage();
//        String HomepageTitle = homepage.verifyHomePagePageTitle();
//        //System.out.println("Login Page Title is : "+loginPageTitle);
//        Assert.assertEquals(HomepageTitle, "Facebook", HomepageTitle);
//    }

    @Test
    public void verifyClickOnProfile() {
        profilePage = homepage.clickOnProfile();

    }
    @Test
    public void verifyclickOnfindfreinds() {
    friendspage = homepage.clickOnfindfreinds();

    }

    @Test
    public void verifyclickOngroups() {
        groupPage = homepage.clickOngroups();

    }
    @Test
    public void verifyclickOnWelcomepage() {
        welcomepage = homepage.clickOnWelcomepage();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
