package com.anhtester.Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

   //Khai báo driver trong từng trang
   private WebDriver driver;
   private String url_login_admin = "https://crm.anhtester.com/admin";

   //Khai báo hàm xây dựng cho từng trang
   public LoginPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
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
      boolean isElementPresent = driver.findElements(headerLoginPage).size() > 0;
      Assert.assertTrue(isElementPresent, "Login page is not displayed.");
   }

   public void navigateToLoginAdminPage() {
      driver.get(url_login_admin);
   }

   private void enterEmail(String email) {
      driver.findElement(inputEmail).sendKeys(email);
   }

   private void enterPassword(String password) {
      driver.findElement(inputPassword).sendKeys(password);
   }

   private void clickLoginButton() {
      driver.findElement(buttonLogin).click();
   }

   public void loginCRM(String email, String password) {
      navigateToLoginAdminPage();
      enterEmail(email);
      enterPassword(password);
      clickLoginButton();
   }

   public void verifyLoginSuccess() {
      boolean isElementPresent = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
      Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");
   }

   public void verifyLoginFailureWithEmailOrPasswordInvalid() {
      boolean isElementErrorMessage = driver.findElements(errorMessageInvalid).size() > 0;
      Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");
   }

   public void verifyLoginFailureWithEmailNull() {
      boolean isElementErrorMessage = driver.findElements(errorMessageRequiredEmail).size() > 0;
      Assert.assertTrue(isElementErrorMessage, "Error message for required email not displayed.");
   }

   public void verifyLoginFailureWithPasswordNull() {
      boolean isElementErrorMessage = driver.findElements(errorMessageRequiredPassword).size() > 0;
      Assert.assertTrue(isElementErrorMessage, "Error message for required password not displayed.");
   }

}
