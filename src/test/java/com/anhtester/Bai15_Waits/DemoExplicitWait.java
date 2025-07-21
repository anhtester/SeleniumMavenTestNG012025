package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {

   WebDriver driver;

   @Test
   public void demoExplicitWait() throws InterruptedException {

      driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.get("https://hrm.anhtester.com/");

      //Khai báo Explicit wait
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(7));

      //Wait for input username to be visible
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iusername")));
      driver.findElement(By.id("iusername")).sendKeys("admin_example");

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ipassword")));
      driver.findElement(By.id("ipassword")).sendKeys("123456");

      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
      driver.findElement(By.xpath("//button[@type='submit']")).click();

      //Wait for the Projects menu to be visible before clicking
      wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects123')]")));
      driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

      Thread.sleep(2000);
      driver.quit();
   }
}