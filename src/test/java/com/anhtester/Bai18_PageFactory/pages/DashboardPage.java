package com.anhtester.Bai18_PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {
   //Khai báo driver trong từng trang
   private WebDriver driver;

   //Khai báo hàm xây dựng cho từng trang
   public DashboardPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
   }

   @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class, 'menu-item')]"))
   private List<WebElement> listMenu;

   //Khai báo đối tượng element thuộc về trang Dashboard
   //private By buttonDashboardOption = By.xpath("//div[@class='screen-options-btn']");
   @FindBy(xpath = "//div[@class='screen-options-btn']")
   private WebElement buttonDashboardOption;

   //private By labelTotalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
   @FindBy(xpath = "(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span")
   private WebElement labelTotalProjectsInProgress;

   public void checkListMenuDisplayed() {
      boolean isElementPresent = false;
      try {
         isElementPresent = listMenu.size() > 0;
      } catch (Exception e) {
         isElementPresent = false;
      }

      Assert.assertTrue(isElementPresent, "List menu is not displayed.");

      System.out.println("List menu is displayed with " + listMenu.size() + " items.");

      System.out.println("List of menu items:");
      for (WebElement menu : listMenu) {
         System.out.println(menu.getText());
      }

   }

   //Khai báo các hàm xử lý trong nội bộ trang Dashboard
   public void verifyDashboardPageDisplayed() {
      //boolean isElementPresent = driver.findElements(buttonDashboardOption).size() > 0;

      boolean isElementPresent = false;
      try {
         isElementPresent = buttonDashboardOption.isDisplayed();
      } catch (Exception e) {
         isElementPresent = false;
      }

      Assert.assertTrue(isElementPresent, "Dashboard page is not displayed.");
   }


   public String getTotalProjectsInProgress() {
      String totalProjectsInProgress = labelTotalProjectsInProgress.getText();
      System.out.println("Total Projects In Progress: " + totalProjectsInProgress);
      return totalProjectsInProgress;
   }

   public void verifyTotalProjectsInProgress() {
      String totalProjectsOnDashboard = labelTotalProjectsInProgress.getText();
      System.out.println("Total Projects on Dashboard: " + totalProjectsOnDashboard);

      //Click vào menu Projects để kiểm tra tổng số lượng trên trang Projects
      clickMenuProjects();

      ProjectsPage projectsPage = new ProjectsPage(driver);

      Assert.assertEquals(totalProjectsOnDashboard, projectsPage.getTotalProjectsInProgress() + " / " + projectsPage.getTotalProjects(),
              "Total Projects on Dashboard does not match total Projects on Projects Page.");

   }


}
