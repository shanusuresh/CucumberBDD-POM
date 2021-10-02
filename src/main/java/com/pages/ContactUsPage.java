package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver driver;
    By subjectHeading = By.id("id_contact");
    By email = By.id("email");
    By message = By.id("message");
    By sendButton = By.id("submitMessage");
    By alertText = By.xpath("//p[@class='alert alert-success']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSubjectHeading(String heading){
        Select subjectDropDown = new Select(driver.findElement(subjectHeading));
        subjectDropDown.selectByVisibleText(heading);
    }

    public void enterEmail(String emailId){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterMessage(String msg){
        driver.findElement(message).clear();
        driver.findElement(message).sendKeys(msg);
    }

    public void submitMessage(){
        driver.findElement(sendButton).click();
    }

    public void sendMessage(String heading, String emailId, String msg){
        selectSubjectHeading(heading);
        enterEmail(emailId);
        enterMessage(msg);
//        submitMessage();
    }

    public String getAlertText(){
        String actualAlertText = driver.findElement(alertText).getText();
        return actualAlertText;
    }

}
