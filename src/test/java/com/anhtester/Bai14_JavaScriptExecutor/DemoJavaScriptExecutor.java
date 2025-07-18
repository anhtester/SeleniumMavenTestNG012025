package com.anhtester.Bai14_JavaScriptExecutor;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DemoJavaScriptExecutor extends BaseTest {
   @Test
   public void demoClickElementWithJavaScriptExecutor() throws InterruptedException {
      driver.get("https://crm.anhtester.com/admin/authentication");
      Thread.sleep(2000);

      JavascriptExecutor js = (JavascriptExecutor) driver;

      WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
      WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));

      js.executeScript("arguments[0].setAttribute('value','admin@example.com');", inputEmail);
      js.executeScript("arguments[0].setAttribute('value','123456');", inputPassword);
      Thread.sleep(1000);
      WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
      js.executeScript("arguments[0].click();", buttonLogin); //Của JavaScript

      //buttonLogin.click(); //Của Selenium
      Thread.sleep(2000);
   }

   @Test
   public void demoClickElementWithJavaScriptExecutor_CMS() throws InterruptedException {
      driver.get("https://cms.anhtester.com/");
      Thread.sleep(2000);

      JavascriptExecutor js = (JavascriptExecutor) driver;

      WebElement menuBlog = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));

      //js.executeScript("arguments[0].click();", menuBlog);

      menuBlog.click();

      Thread.sleep(2000);
   }

   @Test
   public void demoScrollToElement() throws InterruptedException {
      driver.get("https://anhtester.com");
      Thread.sleep(2000);
      JavascriptExecutor js = (JavascriptExecutor) driver;

      WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));
      //js.executeScript("arguments[0].scrollIntoView(true);", element); //Scroll đến đầu của element

      js.executeScript("arguments[0].scrollIntoView(false);", element); //Scroll đến cuối của element
      Thread.sleep(5000);

   }

   @Test
   public void demoHighlightElement() throws InterruptedException {
      driver.get("https://crm.anhtester.com/admin/authentication");
      Thread.sleep(2000);

      JavascriptExecutor js = (JavascriptExecutor) driver;

      WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
      WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));

//      js.executeScript("arguments[0].style.border='3px solid red'", inputEmail);
//      js.executeScript("arguments[0].style.border='3px solid purple'", inputPassword);

      WebUI.highlightElement(driver, inputEmail);
      Thread.sleep(1000);
      WebUI.highlightElement(driver, inputPassword, "green");

      Thread.sleep(1000);
      js.executeScript("arguments[0].setAttribute('value','admin@example.com');", inputEmail);
      js.executeScript("arguments[0].setAttribute('value','123456');", inputPassword);
      Thread.sleep(1000);
      WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
      js.executeScript("arguments[0].click();", buttonLogin); //Của JavaScript

      //buttonLogin.click(); //Của Selenium
      Thread.sleep(2000);
   }


}
