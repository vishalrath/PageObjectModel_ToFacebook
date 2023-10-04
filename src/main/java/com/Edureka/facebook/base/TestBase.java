package com.Edureka.facebook.base;

import com.facebook.util.UtilityClass;
import com.facebook.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public  static EventFiringWebDriver e_driver;
    /* Properties is globle veriable*/
    public static Properties properties;
    public static EventFiringWebDriver eventFiringWebdriver;
    public static WebEventListener eventListener;
    /* initializing all properties*/

    /*create constructer class and read the properties*/
    public TestBase() {

        /* read the properties and initialing the properties veriable*/
        properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "C:\\Users\\Vishal\\IdeaProjects\\SeleniumFremworkProject\\src\\main\\java\\com\\bruidgelabz\\facebook\\config\\config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* create a initialization method*/
    public void intialization() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            // System.setProperty("webdriver.chrome.driver","System.setProperty("webdriver.chrome.driver", "F:\\SeleniumQA\\chromedriver.exe");");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

        }
        else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

        }
        // Capture screenshot when test failed
        eventFiringWebdriver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        eventFiringWebdriver.register(eventListener);
        driver = eventFiringWebdriver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /* if we want change pageLoadTimeout time and implicitlyWait  that time change  below script code.
         so in that situation we will create a utility class  and define the  IMPLICIT_WAIT_TIME  andPAGE_LOAD_TIME
          value and use to (UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
         */
       driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIME, TimeUnit.SECONDS);


        /* launch the browser*/
        driver.get(properties.getProperty("url"));
    }
}


