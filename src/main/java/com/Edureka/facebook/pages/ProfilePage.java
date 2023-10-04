package com.Edureka.facebook.pages;

import com.Edureka.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Posts')]")
    WebElement posts;

    @FindBy(xpath = "//span[contains(text(), 'About')]")
    WebElement about;

    @FindBy(xpath = "//span[contains(@xpath,'1')]")
    WebElement friends;
    @FindBy(xpath = "//span[contains(text(), 'Photos')]")
    WebElement photos;

    @FindBy(xpath = "//span[contains(text(),'Videos')]")
    WebElement videos;

    @FindBy(xpath = "//span[contains(text(),'Check-ins')]")
    WebElement check;
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyProfilePageTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }

    public PostsPage clickOnPosts() {
        posts.click();
        return new PostsPage();
  }
    public AboutPage clickOnAbout() {
        about.click();
        return new AboutPage();
    }

    public PhotosPage clickOnPhotos() {
        photos.click();
        return new PhotosPage();
    }

    public FriendsproPage clickOnFriends() {
        friends.click();
        return new FriendsproPage();
    }

    public VideosPage clickOnVideos() {
        videos.click();
        return new VideosPage();
    }
    public CheckPage clickOnCheck() {
        check.click();
        return new CheckPage();
    }


}
