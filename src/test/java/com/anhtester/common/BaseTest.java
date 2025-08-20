package com.anhtester.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
   public WebDriver driver;
   public SoftAssert softAssert;

   @BeforeMethod
   @Parameters({"browser"})
   public void createDriver(@Optional("chrome") String browserName) {

      switch (browserName.trim().toLowerCase()) {
         case "chrome":
            System.out.println("Launching Chrome browser...");
            driver = new ChromeDriver();
            break;
         case "firefox":
            System.out.println("Launching Firefox browser...");
            driver = new FirefoxDriver();
            break;
         case "edge":
            System.out.println("Launching Edge browser...");
            WebDriverManager.edgedriver().setup(); //Tải msedgedriver.exe tương ứng version của trình duyệt đang dùng
            driver = new EdgeDriver();
            break;
         default:
            System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
            driver = new ChromeDriver();
      }

      driver.manage().window().maximize();
      softAssert = new SoftAssert();
   }

   @AfterMethod(alwaysRun = true)
   public void closeDriver() {
      if (driver != null) {
         driver.quit();
         softAssert.assertAll();
      }
   }
}
