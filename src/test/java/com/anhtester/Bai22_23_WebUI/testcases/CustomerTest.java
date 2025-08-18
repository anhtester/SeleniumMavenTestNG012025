package com.anhtester.Bai22_23_WebUI.testcases;

import com.anhtester.Bai22_23_WebUI.pages.CustomersPage;
import com.anhtester.Bai22_23_WebUI.pages.DashboardPage;
import com.anhtester.Bai22_23_WebUI.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

   private LoginPage loginPage;
   private DashboardPage dashboardPage;
   private CustomersPage customersPage;

   @Test
   public void testAddNewCustomer() {
      loginPage = new LoginPage(driver);
      dashboardPage = loginPage.loginCRM();
      customersPage = dashboardPage.clickMenuCustomers();
      customersPage.verifyCustomerPageDisplayed();
      customersPage.clickAddNewCustomerButton();
      customersPage.fillDataNewCustomer("Test Customer 1808A1", "VIP", "USD", "Vietnamese", "Vietnam");
      customersPage.clickSaveButton();
      customersPage.verifyAlertMessageSuccessDisplayed();
      customersPage.verifyCustomerDetail("Test Customer 1808A1", "VIP", "USD", "Vietnamese", "Vietnam");
   }
}
