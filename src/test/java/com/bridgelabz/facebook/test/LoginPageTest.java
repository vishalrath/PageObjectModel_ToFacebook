package com.bridgelabz.facebook.test;

import com.bridgelabz.facebook.base.TestBase;
import com.bridgelaz.facebook.pages.HomePage;
import com.bridgelaz.facebook.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    // creating object of class
    LoginPage loginPage;
    HomePage homepage;
    String sheetName = "Login";

    /* we have to create a constructer of LoginPage.
    we have to cal super() keyword.
    1. super keyword come first inside this class and
    it will call super class constructer becouse in the TestBase class  initialize the propertis*/

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();

    }
    @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage = new LoginPage();
        String loginPageTitle = loginPage.verifyPageTitle();
        //System.out.println("Login Page Title is : "+loginPageTitle);
        Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
    }
      @Test(priority = 2)
    public void loginTest() {
        loginPage = new LoginPage();
        /* username and password  all ready define  in the config.property file
        only here call the object of file = properties*/
          // this method returning homepage class object
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }
    @AfterMethod
    public void tearDown() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}