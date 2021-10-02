package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

    public WebDriver getInit(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.out.println("Setting up firefox driver");
            WebDriverManager.firefoxdriver().setup();
            System.out.println(System.getProperty("webdriver.gecko.driver"));
            tldriver.set(new FirefoxDriver());
        }
        else if(browser.equalsIgnoreCase("safari")){
            tldriver.set(new SafariDriver());
        }
        else{
            System.out.println("Please enter the valid browser "+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tldriver.get();
    }

}
