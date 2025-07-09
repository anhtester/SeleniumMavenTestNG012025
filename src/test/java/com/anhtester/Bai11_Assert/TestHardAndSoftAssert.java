package com.anhtester.Bai11_Assert;

import com.anhtester.LocatorsCRM;
import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestHardAndSoftAssert extends BaseTest {

   @Test(priority = 1)
   public void testAddNewCustomer() throws InterruptedException {

      String customerName = "Anh Tester 09072025A2";

      System.out.println("testAddNewCustomer");
      driver.get(LocatorsCRM.url);
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
      driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
      driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
      Thread.sleep(1000);

      // Verify login success
      List<WebElement> checkMenuDashboard = driver.findElements(By.xpath(LocatorsCRM.menuDashboard));
      System.out.println("checkMenuDashboard: " + checkMenuDashboard.size());
      Assert.assertTrue(checkMenuDashboard.size() > 0, "Menu Dashboard is not displayed after login");

      // Navigate to Customers and Add New Customer
      driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();

      //Check header Customer page is displayed
      List<WebElement> checkHeaderCustomerPage = driver.findElements(By.xpath("//span[normalize-space()='Customers Summary']"));
      System.out.println("checkHeaderCustomerPage: " + checkHeaderCustomerPage.size());
      softAssert.assertTrue(checkHeaderCustomerPage.size() > 0, "Header Customer Page is not displayed.");
      String headerCustomerText = driver.findElement(By.xpath("//span[normalize-space()='Customers Summary']")).getText();
      softAssert.assertEquals(headerCustomerText, "Customers Summary 123", "Header Customer Page text is not correct.");

      driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();

      driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(customerName);

      driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10");
      driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0912345678");
      driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://anhtester.com");

      driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("VIP", Keys.ENTER);
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
      Thread.sleep(1000);

      driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
      Thread.sleep(1000);

      driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
      Thread.sleep(1000);
      //driver.findElement(By.xpath(LocatorsCRM.optionLanguage)).click();
      //driver.findElement(By.xpath(LocatorsCRM.selectXpathLanguage("German"))).click();

      String languageXpath = String.format(LocatorsCRM.optionLanguageDynamic, "Vietnamese", 1);

      driver.findElement(By.xpath(languageXpath)).click();
      Thread.sleep(1000);

      driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Omon");
      driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Can Tho");
      driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Can Tho");
      driver.findElement(By.xpath(LocatorsCRM.inputZip)).sendKeys("12345");

      driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam", Keys.ENTER);

      Thread.sleep(1000);

      driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();

      Thread.sleep(2000);

      // Verify customer added successfully
      List<WebElement> checkCompanyRequiredField = driver.findElements(By.xpath("//p[@id='company-error']"));
      Assert.assertTrue(checkCompanyRequiredField.size() > 0, "Company field is not required.");

      //System.out.println("Thêm mới khách hàng thành công: " + customerName);
   }
}
