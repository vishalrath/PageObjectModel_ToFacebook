package com.Edureka.facebook.pages;

import com.Edureka.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


public class LoginPage extends TestBase {
    Logger logger;
    /* Page Factory --OR Object Repository*/
    // declaration
    /* username using ID property*/
    @FindBy(id = "email")
     /* define the webElement veriable*/
    WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(xpath = "//a[@id='u_0_2_k+']")
    WebElement CreateAccount;

    // initializing the PageObject
    /* create the constructer from loginpage*/
    public LoginPage() {
        /* define PageFactory class  initElements() method*/
        /* Q. How will you intialize the PageFactory?
          ans- we have an method PageFactory of initElements meanse intialing element with driver and
          this- current class object*/
        PageFactory.initElements(driver, this);
        logger = Logger.getLogger(LoginPage.class.getName());
    }
    // Actions
    /* get the page title name*/
    public String verifyPageTitle() {
        logger.info(".....Verify the Page Title.....");
        return driver.getTitle();
    }

    /* create one more method login and pass the string veriable meanse username and password,*/
    public HomePage login(String username, String password) {
        logger.info(".....login.....");
        /* send the values to username and password using sendkey() method*/
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        /* click on login button*/
        loginButton.click();
        /* after click move to the HomePage*/
        return new HomePage();
    }
}
