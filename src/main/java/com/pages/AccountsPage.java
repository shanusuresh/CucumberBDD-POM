package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    private By accountSections = By.cssSelector("div#center_column span");
    private By topMenu = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li");
    private By contactUsLink = By.linkText("Contact us");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public int getAccountSectionsCount(){
        return driver.findElements(accountSections).size()-1;
    }

    public List<String> getAccountSectionsList(){
        List<String> accountsList = new ArrayList<>();
       List<WebElement> accountSectionsList = driver.findElements(accountSections);
       for (WebElement eachSections: accountSectionsList){
           if(!eachSections.getText().equals("Home")) {
               accountsList.add(eachSections.getText());
           }
       }
       return accountsList;
    }

    public List<String> getTopMenuList(){
        List<String> actualTopMenu = new ArrayList<>();
        List<WebElement> topMenuList = driver.findElements(topMenu);
        for(WebElement topMenu: topMenuList){
            actualTopMenu.add(topMenu.getText());
        }
        return actualTopMenu;
    }

    public int getTopMenuCount(){
        return driver.findElements(topMenu).size();
    }

    public ContactUsPage navigateToContactUsPage(){
        driver.findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }




}
