package com.anhtester.Bai18_PageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
   private WebDriver driver;

   public BasePage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   //Element chung cho tất cả các trang
   @FindBy(xpath = "//span[normalize-space()='Dashboard' and @class='menu-text']")
   public WebElement menuDashboard;

   @FindBy(xpath = "//span[normalize-space()='Customers' and @class='menu-text']")
   public WebElement menuCustomers;

   @FindBy(xpath = "//span[normalize-space()='Projects' and @class='menu-text']")
   public WebElement menuProjects;

   @FindBy(xpath = "//span[normalize-space()='Tasks' and @class='menu-text']")
   public WebElement menuTasks;

   @FindBy(xpath = "//li[@class='icon header-user-profile']")
   public WebElement iconProfile;

   @FindBy(xpath = "//a[text()='Logout']")
   public WebElement optionLogout;

   //Các hàm xử lý chung cho tất cả các trang
   public void logoutSystem(){
      iconProfile.click();
      optionLogout.click();
   }

   public void clickMenuDashboard() {
       menuDashboard.click();
   }

   public void clickMenuCustomers() {
       menuCustomers.click();
   }

   public void clickMenuProjects() {
       menuProjects.click();
   }

   public void clickMenuTasks() {
       menuTasks.click();
   }

}
