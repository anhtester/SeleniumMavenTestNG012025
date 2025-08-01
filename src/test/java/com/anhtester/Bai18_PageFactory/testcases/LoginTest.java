package com.anhtester.Bai18_PageFactory.testcases;

import com.anhtester.Bai18_PageFactory.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

   private LoginPage loginPage;

   @Test(priority = 1)
   public void testLoginSuccess() {
      loginPage = new LoginPage(driver);

      loginPage.loginCRM("admin@example.com", "123456");
      loginPage.verifyLoginSuccess();
   }

   @Test(priority = 2)
   public void testLoginFailureWithEmailInvalid() {
      loginPage = new LoginPage(driver);
      loginPage.loginCRM("admin123@example.com", "123456");

      loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
   }

   @Test(priority = 3)
   public void testLoginFailureWithPasswordInvalid() {
      loginPage = new LoginPage(driver);
      loginPage.loginCRM("admin@example.com", "123");

      loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
   }

   @Test(priority = 4)
   public void testLoginFailureWithEmailNull() {
      loginPage = new LoginPage(driver);
      loginPage.loginCRM("", "123456");

      loginPage.verifyLoginFailureWithEmailNull();
   }

   @Test(priority = 5)
   public void testLoginFailureWithPasswordNull() {
      loginPage = new LoginPage(driver);
      loginPage.loginCRM("admin@example.com", "");

      loginPage.verifyLoginFailureWithPasswordNull();
   }

}
