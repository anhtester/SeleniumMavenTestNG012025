package com.anhtester.Bai16_ThucHanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
   @Test
   public void testDashboard_CheckQuickStatisticsTotal() {
      driver.get("https://crm.anhtester.com/admin");
      WebUI.setText(driver, By.id("email"), "admin@example.com");
      WebUI.setText(driver, By.id("password"), "123456");
      WebUI.clickElement(driver, By.xpath("//button[@type='submit']"), 20);
      boolean isElementPresent = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
      Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");

      // Get label số lượng ngoài Dashboard
      String totalProjectsOnDashboard = driver.findElement(By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span")).getText();
      System.out.println("Total Projects on Dashboard: " + totalProjectsOnDashboard);

      WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Projects']"));

      // Get label số lượng trên trang Projects
      String totalProjectsOnProjectsPage_NotStarted = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Not Started']/preceding-sibling::span")).getText();
      System.out.println("Total Projects on Projects Page (Not Started): " + totalProjectsOnProjectsPage_NotStarted);

      String totalProjectsOnProjectsPage_InProgress = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='In Progress']/preceding-sibling::span")).getText();
      System.out.println("Total Projects on Projects Page (In Progress): " + totalProjectsOnProjectsPage_InProgress);

      String totalProjectsOnProjectsPage_OnHold = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='On Hold']/preceding-sibling::span")).getText();
      System.out.println("Total Projects on Projects Page (On Hold): " + totalProjectsOnProjectsPage_OnHold);

      String totalProjectsOnProjectsPage_Cancelled = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Cancelled']/preceding-sibling::span")).getText();
      System.out.println("Total Projects on Projects Page (Cancelled): " + totalProjectsOnProjectsPage_Cancelled);

      String totalProjectsOnProjectsPage_Finished = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']//span[normalize-space()='Finished']/preceding-sibling::span")).getText();
      System.out.println("Total Projects on Projects Page (Finished): " + totalProjectsOnProjectsPage_Finished);

      int totalProjects = Integer.parseInt(totalProjectsOnProjectsPage_NotStarted) +
              Integer.parseInt(totalProjectsOnProjectsPage_InProgress) +
              Integer.parseInt(totalProjectsOnProjectsPage_OnHold) +
              Integer.parseInt(totalProjectsOnProjectsPage_Cancelled) +
              Integer.parseInt(totalProjectsOnProjectsPage_Finished);

      System.out.println("Total Projects on Projects Page: " + totalProjectsOnProjectsPage_InProgress + " / " + totalProjects);

      // Kiểm tra tổng số lượng trên Dashboard và trang Projects có khớp nhau không
      Assert.assertEquals(totalProjectsOnDashboard, totalProjectsOnProjectsPage_InProgress + " / " + totalProjects, "Total Projects on Dashboard does not match total Projects on Projects Page.");

   }
}
