package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

   private LoginPage loginPage;

   @Test
   public void testLoginSuccess() {
      loginPage = new LoginPage(driver);

      loginPage.loginCRM("admin@example.com", "123456");
      loginPage.verifyLoginSuccess();

//      driver.get("https://crm.anhtester.com/admin");
//      WebUI.setText(driver, By.id("email"), "admin@example.com");
//      WebUI.setText(driver, By.id("password"), "123456");
//      WebUI.clickElement(driver, By.xpath("//button[@type='submit']"), 20);
//      boolean isElementPresent = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
//      Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");

   }

}
