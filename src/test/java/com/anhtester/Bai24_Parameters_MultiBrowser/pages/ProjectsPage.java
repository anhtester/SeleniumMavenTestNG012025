package com.anhtester.Bai24_Parameters_MultiBrowser.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
   //Khai báo driver trong từng trang
   private WebDriver driver;

   //Khai báo hàm xây dựng cho từng trang
   public ProjectsPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
      new WebUI(driver);
   }

   //Khai báo đối tượng element thuộc về trang Projects
   private By labelProjectTotalNotStarted = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Not Started']/preceding-sibling::span");
   private By labelProjectTotalInProgress = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='In Progress']/preceding-sibling::span");
   private By labelProjectTotalOnHold = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='On Hold']/preceding-sibling::span");
   private By labelProjectTotalCancelled = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Cancelled']/preceding-sibling::span");
   private By labelProjectTotalFinished = By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Finished']/preceding-sibling::span");

   //Khai báo các hàm xử lý trong nội bộ trang Projects
   public String getTotalProjectsNotStarted() {
      return WebUI.getElementText(labelProjectTotalNotStarted);
   }

   public String getTotalProjectsInProgress() {
      return WebUI.getElementText(labelProjectTotalInProgress);
   }

   public String getTotalProjectsOnHold() {
      return WebUI.getElementText(labelProjectTotalOnHold);
   }

   public String getTotalProjectsCancelled() {
      return WebUI.getElementText(labelProjectTotalCancelled);
   }

   public String getTotalProjectsFinished() {
      return WebUI.getElementText(labelProjectTotalFinished);
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
