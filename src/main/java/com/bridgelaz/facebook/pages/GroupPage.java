package com.bridgelaz.facebook.pages;

import com.bridgelabz.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupPage extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'Discover')]")
    WebElement discover;

    public void GroupsPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyGroupsPageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public DiscoverPage clickOnDiscover() {
        discover.click();
        return new DiscoverPage();
    }
}
