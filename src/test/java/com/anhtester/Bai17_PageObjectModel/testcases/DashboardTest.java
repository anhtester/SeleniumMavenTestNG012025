package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.DashboardPage;
import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.Bai17_PageObjectModel.pages.ProjectsPage;
import com.anhtester.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

   private LoginPage loginPage;
   private DashboardPage dashboardPage;
   private ProjectsPage projectsPage;

   @Test
   public void testLabelProjectInProgress() {
      loginPage = new LoginPage(driver);
      loginPage.loginCRM("admin@example.com", "123456");
      loginPage.verifyLoginSuccess();

      dashboardPage = new DashboardPage(driver);
      dashboardPage.verifyDashboardPageDisplayed();

      String totalProjectsInProgressOnDashboard = dashboardPage.getTotalProjectsInProgress();

      dashboardPage.clickMenuProjects();

      projectsPage = new ProjectsPage(driver);

      Assert.assertEquals(totalProjectsInProgressOnDashboard, projectsPage.getTotalProjectsInProgress() + " / " + projectsPage.getTotalProjects(),
              "Total Projects In Progress on Dashboard does not match total Projects In Progress on Projects Page.");

      //dashboardPage.verifyTotalProjectsInProgress();
   }
}
