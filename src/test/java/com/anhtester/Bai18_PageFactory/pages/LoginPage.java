package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

   //Khai báo driver trong từng trang
   private WebDriver driver;
   private String url_login_admin = "https://crm.anhtester.com/admin";

   //Khai báo hàm xây dựng cho từng trang
   public LoginPage(WebDriver driver) {
      super(driver);
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   //Khai báo đối tượng element thuộc về trang Login
   @FindBy(xpath = "//h2[normalize-space()='Login']")
   private WebElement headerLoginPage;

   @FindBy(xpath = "")
   private WebElement checkboxRememberMe;

   @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
   private WebElement linkForgotPassword;

   @FindAll(
           {
                   @FindBy(id = "email"),
                   @FindBy(xpath = "//input[@id='email123']"),
                   @FindBy(name = "email456"),
                   @FindBy(xpath = "//input[@id='username']"),
           }
   )
   private WebElement inputEmail;

   @FindBy(xpath = "//input[@id='password']")
   private WebElement inputPassword;

   @FindBy(xpath = "//button[normalize-space()='Login']")
   private WebElement buttonLogin;

   @FindBy(xpath = "//div[@id='alerts']//div[contains(text(),'Invalid email or password')]")
   private WebElement errorMessageInvalid;

   @FindBy(xpath = "//div[contains(text(),'The Email Address field is required.')]")
   private WebElement errorMessageRequiredEmail;

   @FindBy(xpath = "//div[contains(text(),'The Password field is required.')]")
   private WebElement errorMessageRequiredPassword;

   //Khai báo các hàm xử lý trong nội bộ trang Login

   public void verifyLoginPageDisplayed() {
      boolean isElementPresent = false;
      try {
         isElementPresent = headerLoginPage.isDisplayed();
      } catch (Exception e) {
         isElementPresent = false;
      }

      Assert.assertTrue(isElementPresent, "Login page is not displayed.");
   }

   public void navigateToLoginAdminPage() {
      driver.get(url_login_admin);
   }

   private void enterEmail(String email) {
      //inputEmail.sendKeys(email);
      WebUI.setText(driver, inputEmail, email);
   }

   private void enterPassword(String password) {
      //inputPassword.sendKeys(password);
      WebUI.setText(driver, inputPassword, password);
   }

   private void clickLoginButton() {
      //buttonLogin.click();
      WebUI.clickElement(driver, buttonLogin);
   }

   public void loginCRM(String email, String password) {
      navigateToLoginAdminPage();
      enterEmail(email);
      enterPassword(password);
      clickLoginButton();
   }

   public void verifyLoginSuccess() {
      boolean isElementPresent = false;
      try {
         isElementPresent = menuDashboard.isDisplayed();
      } catch (Exception e) {
         isElementPresent = false;
      }
      Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");
   }

   public void verifyLoginFailureWithEmailOrPasswordInvalid() {
      boolean isElementErrorMessage = false;
      try {
         isElementErrorMessage = errorMessageInvalid.isDisplayed();
      } catch (Exception e) {
         isElementErrorMessage = false;
      }

      Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");
   }

   public void verifyLoginFailureWithEmailNull() {
      boolean isElementErrorMessage = false;
      try {
         isElementErrorMessage = errorMessageRequiredEmail.isDisplayed();
      } catch (Exception e) {
         isElementErrorMessage = false;
      }
      Assert.assertTrue(isElementErrorMessage, "Error message for required email not displayed.");
   }

   public void verifyLoginFailureWithPasswordNull() {
      boolean isElementErrorMessage = false;
      try {
         isElementErrorMessage = errorMessageRequiredPassword.isDisplayed();
      } catch (Exception e) {
         isElementErrorMessage = false;
      }
      Assert.assertTrue(isElementErrorMessage, "Error message for required password not displayed.");
   }

}
