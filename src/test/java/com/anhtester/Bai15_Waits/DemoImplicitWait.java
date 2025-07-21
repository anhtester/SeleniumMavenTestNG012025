package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoImplicitWait {

   WebDriver driver;

   @Test
   public void demoImplicitWait() throws InterruptedException {

      driver = new ChromeDriver();
      driver.manage().window().maximize();

      //Set timeout for implicitlyWait
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

      driver.get("https://hrm.anhtester.com/");

      driver.findElement(By.id("iusername")).sendKeys("admin_example");
      driver.findElement(By.id("ipassword123")).sendKeys("123456");
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      //Có bước loading

      //Click menu dự án
      driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

      Thread.sleep(2000);

      //Reset timeout for implicitlyWait
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
      driver.quit();
   }

   @Test
   public void demoImplicitWait2() throws InterruptedException {

      driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

      driver.get("https://hrm.anhtester.com/");

      driver.findElement(By.id("iusername")).sendKeys("admin_example");
      driver.findElement(By.id("ipassword123")).sendKeys("123456");
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      //Có bước loading

      //Click menu dự án
      driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

      Thread.sleep(2000);

      driver.quit();
   }
}