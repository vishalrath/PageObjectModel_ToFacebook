package com.bridgelaz.facebook.pages;

import com.bridgelabz.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

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
    }
    // Actions
    /* get the pade title name*/
    public String verifyPageTitle() {
        return driver.getTitle();
    }

    /* create one more method login and pass the string veriable meanse username and password,*/
    public HomePage login(String username, String password) {
        /* send the values to username and password using sendkey() method*/
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        /* click on login button*/
        loginButton.click();
        /* after click move to the HomePage*/
        return new HomePage();
    }
}
