package com.bridgelabz.facebook.test;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelaz.facebook.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;
    ProfilePage profilePage;
    AboutPage aboutPage;
    PhotosPage photosPage;
    VideosPage videosPage;
    FriendsproPage friendsproPage;
   CheckPage checkPage;

    PostsPage postsPage;

    public ProfilePageTest() {
        super();
    }

//    @BeforeMethod
//    public void setUp() {
//        intialization();
//        loginPage = new LoginPage();
//        homepage = new HomePage();
//        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
//        profilePage = homepage.clickOnProfile();
//    }
    @BeforeMethod
    public void setUp() {
        intialization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        profilePage = homepage.clickOnProfile();
    }
    @Test(priority = 1)
    public void verifyProfilePageTitleTest() {
        String homePageTitle = profilePage.verifyProfilePageTitle();
        Assert.assertEquals(homePageTitle, "(5) Raj Chavan | Facebook", "ProfilePage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnPosts() {
        postsPage = profilePage.clickOnPosts();

    }

    @Test(priority = 3)
    public void verifyClickOnAbout() {
        aboutPage = profilePage.clickOnAbout();

    }
    @Test(priority = 4)
    public void verifyClickOnPhotos() {
        photosPage = profilePage.clickOnPhotos();

    }
    @Test(priority = 5)
    public void verifyClickOnFriends() {
        friendsproPage = profilePage.clickOnFriends();

    }


    @Test(priority = 4)
    public void verifyClickOnVideos() {
        videosPage = profilePage.clickOnVideos();

    }

    @Test(priority = 5)
    public void verifyClickOnCheck() {
        checkPage = profilePage.clickOnCheck();

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
