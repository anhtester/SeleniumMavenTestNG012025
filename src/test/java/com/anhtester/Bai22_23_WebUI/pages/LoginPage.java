package com.anhtester.Bai22_23_WebUI.pages;

import com.anhtester.keywords.ActionKeyword_OLD;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {

   //Khai báo driver trong từng trang
   private WebDriver driver;
   private String url_login_admin = "https://crm.anhtester.com/admin";

   //Khai báo hàm xây dựng cho từng trang
   public LoginPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
      new WebUI(driver); // Khởi tạo WebUI để truyền giá trị driver vào trong class WebUI
   }

   //Khai báo đối tượng element thuộc về trang Login
   private By headerLoginPage = By.xpath("");
   private By checkboxRememberMe = By.xpath("");
   private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
   private By inputEmail = By.xpath("//input[@id='email']");
   private By inputPassword = By.xpath("//input[@id='password']");
   private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
   private By errorMessageInvalid = By.xpath("//div[@id='alerts']//div[contains(text(),'Invalid email or password')]");
   private By errorMessageRequiredEmail = By.xpath("//div[contains(text(),'The Email Address field is required.')]");
   private By errorMessageRequiredPassword = By.xpath("//div[contains(text(),'The Password field is required.')]");

   //Khai báo các hàm xử lý trong nội bộ trang Login

   public void verifyLoginPageDisplayed() {
      boolean check = WebUI.checkElementExist(headerLoginPage);
      Assert.assertTrue(check, "Login page is not displayed.");
   }

   public void navigateToLoginAdminPage() {
      WebUI.openURL(url_login_admin);
      WebUI.waitForPageLoaded();
   }

   private void enterEmail(String email) {
      WebUI.setText(inputEmail, email);
   }

   private void enterPassword(String password) {
      WebUI.setText(inputPassword, password);
   }

   private void clickLoginButton() {
      WebUI.clickElement(buttonLogin);
   }

   public void loginCRM(String email, String password) {
      navigateToLoginAdminPage();
      enterEmail(email);
      enterPassword(password);
      clickLoginButton();
      WebUI.waitForPageLoaded();
   }

   public DashboardPage loginCRM() {
      navigateToLoginAdminPage();
      enterEmail("admin@example.com");
      enterPassword("123456");
      clickLoginButton();
      WebUI.waitForPageLoaded();
      verifyLoginSuccess();

      return new DashboardPage(driver);
   }

   public void verifyLoginSuccess() {
      boolean check = WebUI.checkElementExist(By.xpath("//span[normalize-space()='Dashboard']"), 5, 1000);
      Assert.assertTrue(check, "Login failed or Dashboard not displayed.");
   }

   public void verifyLoginFailureWithEmailOrPasswordInvalid() {
      boolean check = WebUI.checkElementExist(errorMessageInvalid);
      Assert.assertTrue(check, "Error message for invalid email not displayed.");
   }

   public void verifyLoginFailureWithEmailNull() {
      boolean check = WebUI.checkElementExist(errorMessageRequiredEmail);
      Assert.assertTrue(check, "Error message for required email not displayed.");
   }

   public void verifyLoginFailureWithPasswordNull() {
      boolean check = WebUI.checkElementExist(errorMessageRequiredPassword);
      Assert.assertTrue(check, "Error message for required password not displayed.");
   }

}
