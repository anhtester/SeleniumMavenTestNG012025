package com.anhtester.Bai25_ParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class EdgeTest {

   @Test
   public void EdgeTestMethod01() {
      System.out.println("Initializing the Microsoft Edge driver");
      WebDriver driver = new EdgeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //Initialize the Edge driver
      System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
      driver.get("https://anhtester.com");
      driver.findElement(By.xpath("//h3[normalize-space()='Mobile Testing']")).click();
      driver.quit();
   }

   @Test
   public void EdgeTestMethod02() {
      System.out.println("Initializing the Microsoft Edge driver");
      WebDriver driver = new EdgeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //Initialize the Edge driver
      System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
      driver.get("https://anhtester.com");
      driver.findElement(By.xpath("//h3[normalize-space()='Desktop Testing']")).click();
      driver.quit();
   }

//   @Test
//   public void EdgeTestMethod03() {
//      System.out.println("Initializing the Microsoft Edge driver");
//      WebDriver driver = new EdgeDriver();
//      driver.manage().window().maximize();
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//      //Initialize the Edge driver
//      System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
//      driver.get("https://anhtester.com");
//      driver.findElement(By.xpath("//h3[normalize-space()='Desktop Testing']")).click();
//      driver.quit();
//   }

}