package com.anhtester.Bai19_NavigationPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
   //Khai báo driver trong từng trang
   private WebDriver driver;

   //Khai báo hàm xây dựng cho từng trang
   public DashboardPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
   }

   //Khai báo đối tượng element thuộc về trang Dashboard
   private By buttonDashboardOption = By.xpath("//div[@class='screen-options-btn']");
   private By labelTotalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");

   //Khai báo các hàm xử lý trong nội bộ trang Dashboard
   public void verifyDashboardPageDisplayed() {
      boolean isElementPresent = driver.findElements(buttonDashboardOption).size() > 0;
      Assert.assertTrue(isElementPresent, "Dashboard page is not displayed.");
   }


   public String getTotalProjectsInProgress() {
      String totalProjectsInProgress = driver.findElement(labelTotalProjectsInProgress).getText();
      System.out.println("Total Projects In Progress: " + totalProjectsInProgress);
      return totalProjectsInProgress;
   }

   public void verifyTotalProjectsInProgress() {
      String totalProjectsOnDashboard = driver.findElement(labelTotalProjectsInProgress).getText();
      System.out.println("Total Projects on Dashboard: " + totalProjectsOnDashboard);

      //Click vào menu Projects để kiểm tra tổng số lượng trên trang Projects
      clickMenuProjects();

      ProjectsPage projectsPage = new ProjectsPage(driver);

      Assert.assertEquals(totalProjectsOnDashboard, projectsPage.getTotalProjectsInProgress() + " / "+ projectsPage.getTotalProjects(),
              "Total Projects on Dashboard does not match total Projects on Projects Page.");

   }


}
