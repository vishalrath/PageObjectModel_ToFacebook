package com.Edureka.facebook.pages;

import com.Edureka.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase {
    @FindBy(xpath = "//a[@id='u_0_2_Wg']" )
    WebElement CreateAccount;

    @FindBy(name="firstname")
    WebElement firstname;

    @FindBy(name="lastname")
    WebElement lastname;

    /*@FindBy(name="reg_email__")
   WebElement reg_email--;*/
       /* driver.findElement(name("reg_email_confirmation__")).sendKeys("wass@gmail.com");
        Thread.sleep(1000);*/
        /*driver.findElement(name("reg_passwd__")).sendKeys("12@qwas");
        Thread.sleep(1000);*/
    @FindBy(name ="birthday_day")
    WebElement birthday_day;
    @FindBy(name="birthday_month")
    WebElement birthday_month;
    @FindBy(name="birthday_year")
    WebElement birthday_year;
    @FindBy(name="sex")
    WebElement sex;
    @FindBy(name="websubmit")
    WebElement websubmit;
    public void ResisterPage() {
        PageFactory.initElements(driver, this);
    }



    public void Register( String firstname, String lastname,String birthday_day) {
        this.CreateAccount.click();
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.birthday_day.sendKeys(birthday_day);



    }
}
