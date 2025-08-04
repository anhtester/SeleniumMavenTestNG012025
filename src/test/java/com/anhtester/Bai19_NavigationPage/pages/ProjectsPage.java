package com.anhtester.Bai19_NavigationPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
   //Khai báo driver trong từng trang
   private WebDriver driver;

   //Khai báo hàm xây dựng cho từng trang
   public ProjectsPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
   }

   //Khai báo đối tượng element thuộc về trang Projects
   private By labelProjectTotalNotStarted = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Not Started']/preceding-sibling::span");
   private By labelProjectTotalInProgress = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='In Progress']/preceding-sibling::span");
   private By labelProjectTotalOnHold = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='On Hold']/preceding-sibling::span");
   private By labelProjectTotalCancelled = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Cancelled']/preceding-sibling::span");
   private By labelProjectTotalFinished = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Finished']/preceding-sibling::span");

   //Khai báo các hàm xử lý trong nội bộ trang Projects
   public String getTotalProjectsNotStarted() {
      return driver.findElement(labelProjectTotalNotStarted).getText();
   }

   public String getTotalProjectsInProgress() {
      return driver.findElement(labelProjectTotalInProgress).getText();
   }

   public String getTotalProjectsOnHold() {
      return driver.findElement(labelProjectTotalOnHold).getText();
   }

   public String getTotalProjectsCancelled() {
      return driver.findElement(labelProjectTotalCancelled).getText();
   }

   public String getTotalProjectsFinished() {
      return driver.findElement(labelProjectTotalFinished).getText();
   }

   public int getTotalProjects() {
      int totalProjects = Integer.parseInt(getTotalProjectsNotStarted()) +
              Integer.parseInt(getTotalProjectsInProgress()) +
              Integer.parseInt(getTotalProjectsOnHold()) +
              Integer.parseInt(getTotalProjectsCancelled()) +
              Integer.parseInt(getTotalProjectsFinished());
      return totalProjects;
   }

}
