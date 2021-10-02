package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    /**
     * 1. Page locators
     * 2. Constructor
     * 3. page actions
     */
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By loginButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password??");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkPresent(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public AccountsPage doLogin(String userName, String pwd){
        System.out.println("Logging in to the application ..");
        driver.findElement(emailId).sendKeys(userName);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginButton).click();
        return new AccountsPage(driver);
    }

}
