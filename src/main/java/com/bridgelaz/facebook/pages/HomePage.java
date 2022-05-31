package com.bridgelaz.facebook.pages;

import com.bridgelabz.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

     /* find the username or profile name on home page*/
    @FindBy(xpath = "//span[contains(text(),'Raj Chavan')]")
    WebElement userProfile;

    @FindBy(xpath = "//span[contains(text(),'Find Friends')]")
    WebElement findfreinds;

    @FindBy(xpath = "//span[contains(text(),'Welcome')]")
    WebElement welcome;

    @FindBy(xpath = "//span[contains(text(),'Groups')]")
    WebElement groups;

    /* Initialization  the page Object*/
    // create the constructer  of Homepage
    public HomePage() {

        PageFactory.initElements(driver, this);
    }
       /* verify the title on homepage*/
    public String verifyHomePagePageTitle() {
        return driver.getTitle();
    }
    public ProfilePage clickOnProfile() {
        userProfile.click();
        return new ProfilePage();
    }

    public Welcomepage clickOnWelcomepage() {
        welcome.click();
        return new Welcomepage();
    }

    public FriendsPage clickOnfindfreinds() {
        findfreinds.click();
        return new FriendsPage();
    }
    public GroupPage clickOngroups() {
        groups.click();
        return new GroupPage();
    }
}
