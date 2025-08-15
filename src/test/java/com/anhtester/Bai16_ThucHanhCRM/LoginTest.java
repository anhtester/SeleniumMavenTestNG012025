package com.anhtester.Bai16_ThucHanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.ActionKeyword_OLD;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

   @Test
   public void testLoginSuccess() {
      driver.get("https://crm.anhtester.com/admin");

      ActionKeyword_OLD.setText(driver, By.id("email"), "admin@example.com");
      ActionKeyword_OLD.setText(driver, By.id("password"), "123456");
      ActionKeyword_OLD.clickElement(driver, By.xpath("//button[@type='submit']"), 20);

      //Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Dashboard123']")).isDisplayed(), "Login failed or Dashboard not displayed.");

      boolean isElementPresent = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
      Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");
   }

   @Test
   public void testLoginFailureWithEmailInvalid() {

      driver.get("https://crm.anhtester.com/admin");

      ActionKeyword_OLD.setText(driver, By.id("email"), "admin12345@example.com");
      ActionKeyword_OLD.setText(driver, By.id("password"), "123456");
      ActionKeyword_OLD.clickElement(driver, By.xpath("//button[@type='submit']"), 20);

      // Assert that the error message is displayed
      boolean isElementErrorMessage = driver.findElements(By.xpath("//div[@id='alerts']//div[contains(text(),'Invalid email or password')]")).size() > 0;

      System.out.println("Element Error Message: " + "//div[@id='alerts']//div[contains(text(),'Invalid email or password')]");

      Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");

   }

   @Test
   public void testLoginFailureWithPasswordInvalid() {

      driver.get("https://crm.anhtester.com/admin");

      ActionKeyword_OLD.setText(driver, By.id("email"), "admin@example.com");
      ActionKeyword_OLD.setText(driver, By.id("password"), "123456789");
      ActionKeyword_OLD.clickElement(driver, By.xpath("//button[@type='submit']"), 20);

      // Assert that the error message is displayed
      boolean isElementErrorMessage = driver.findElements(By.xpath("//div[@id='alerts']//div[contains(text(),'Invalid email or password')]")).size() > 0;

      System.out.println("Element Error Message: " + "//div[@id='alerts']//div[contains(text(),'Invalid email or password')]");

      Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");

   }

   @Test
   public void testLoginFailureWithEmailNull() {

      driver.get("https://crm.anhtester.com/admin");

      ActionKeyword_OLD.setText(driver, By.id("email"), "");
      ActionKeyword_OLD.setText(driver, By.id("password"), "123456789");
      ActionKeyword_OLD.clickElement(driver, By.xpath("//button[@type='submit']"), 20);

      // Assert that the error message is displayed
      boolean isElementErrorMessage = driver.findElements(By.xpath("//div[contains(text(),'The Email Address field is required.')]")).size() > 0;

      System.out.println("Element Error Message: " + "//div[contains(text(),'The Email Address field is required.')]");

      Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");

   }

}
