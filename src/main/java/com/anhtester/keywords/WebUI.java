package com.anhtester.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {

   private static int WAIT_TIMEOUT = 10;
   private static double STEP_TIME = 0;
   private static int PAGE_LOAD_TIMEOUT = 20;

   private static WebDriver driver; //driver = null

   public WebUI(WebDriver driver) {
      this.driver = driver;
   }

   public static void logConsole(Object message) {
      System.out.println(message);
   }

   public static void sleep(double seconds) {
      try {
         Thread.sleep((long) (seconds * 1000));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static void highlightElement(By by) {
      // Highlight the element using JavaScript
      String script = "arguments[0].style.border='3px solid red';";

      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript(script, driver.findElement(by));
   }

   public static void highlightElement(By by, String color) {
      // Highlight the element using JavaScript
      String script = "arguments[0].style.border='3px solid " + color + "';";
      ((JavascriptExecutor) driver).executeScript(script, driver.findElement(by));
   }

   //Wait for Element

   public static WebElement waitForElementVisible(By by) {
      WebElement element = null;
      try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
         element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
         highlightElement(by);
         return element;
      } catch (Throwable error) {
         logConsole("Timeout waiting for the element Visible. " + by.toString());
         Assert.fail("Timeout waiting for the element Visible. " + by.toString());
      }
      return element;
   }

   public static WebElement waitForElementVisible(By by, int seconds) {
      WebElement element = null;
      try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(200));
         element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
         highlightElement(by);
         return element;
      } catch (Throwable error) {
         logConsole("Timeout waiting for the element Visible. " + by.toString());
         Assert.fail("Timeout waiting for the element Visible. " + by.toString());
      }
      return element;
   }

   public static WebElement waitForElementToBeClickable(By by) {
      WebElement element = null;
      try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
         element = wait.until(ExpectedConditions.elementToBeClickable(by));
         highlightElement(by);
         return element;
      } catch (Throwable error) {
         logConsole("Timeout waiting for the element to be clickable. " + by.toString());
         Assert.fail("Timeout waiting for the element to be clickable. " + by.toString());
      }
      return element;
   }

   public static WebElement waitForElementToBeClickable(By by, int seconds) {
      WebElement element = null;
      try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(200));
         element = wait.until(ExpectedConditions.elementToBeClickable(by));
         highlightElement(by);
         return element;
      } catch (Throwable error) {
         logConsole("Timeout waiting for the element to be clickable with  " + seconds + "(s) : " + by);
         Assert.fail("Timeout waiting for the element to be clickable with " + seconds + "(s) : " + by);
      }
      return element;
   }

   public static WebElement waitForElementPresent(By by) {
      WebElement element = null;
      try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(200));
         element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
         highlightElement(by);
         return element;
      } catch (Throwable error) {
         logConsole("Element not exist." + by);
         Assert.fail("Element not exist. " + by);
      }
      return element;
   }

   public static WebElement waitForElementPresent(By by, int seconds) {
      WebElement element = null;
      try {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(200));
         element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
         highlightElement(by);
         return element;
      } catch (Throwable error) {
         logConsole("Element not exist." + by);
         Assert.fail("Element not exist. " + by);
      }
      return element;
   }

   //Chờ đợi trang load xong mới thao tác
   public static void waitForPageLoaded() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
      JavascriptExecutor js = (JavascriptExecutor) driver;

      //Wait for Javascript to load
      ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver driver) {
            return js.executeScript("return document.readyState").toString().equals("complete");
         }
      };

      //Check JS is Ready
      boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

      //Wait Javascript until it is Ready!
      if (!jsReady) {
         //System.out.println("Javascript is NOT Ready.");
         //Wait for Javascript to load
         try {
            wait.until(jsLoad);
         } catch (Throwable error) {
            error.printStackTrace();
            Assert.fail("FAILED. Timeout waiting for page load.");
         }
      }
   }

   public static WebElement getWebElement(By by) {
      return driver.findElement(by);
   }

   public static List<WebElement> getWebElements(By by) {
      return driver.findElements(by);
   }

   public static Boolean checkElementExist(By by) {
      List<WebElement> listElement = getWebElements(by);

      if (listElement.size() > 0) {
         System.out.println("checkElementExist: " + true + " --- " + by);
         return true;
      } else {
         System.out.println("checkElementExist: " + false + " --- " + by);
         return false;
      }
   }

   // Hàm kiểm tra sự tồn tại của phần tử với lặp lại nhiều lần
   public static boolean checkElementExist(By by, int maxRetries, int waitTimeMillis) {
      int retryCount = 0;

      while (retryCount < maxRetries) {
         try {
            WebElement element = getWebElement(by);
            if (element != null) {
               System.out.println("Tìm thấy phần tử ở lần thử thứ " + (retryCount + 1));
               return true; // Phần tử được tìm thấy
            }
         } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy phần tử. Thử lại lần " + (retryCount + 1));
            retryCount++;
            try {
               Thread.sleep(waitTimeMillis); // Chờ trước khi thử lại
            } catch (InterruptedException ie) {
               ie.printStackTrace();
            }
         }
      }

      // Trả về false nếu không tìm thấy phần tử sau maxRetries lần
      logConsole("Không tìm thấy phần tử sau " + maxRetries + " lần thử.");
      return false;
   }

   public static void openURL(String url) {
      driver.get(url);
      sleep(STEP_TIME);
      logConsole("Open URL:  " + url);
   }

   public static void clickElement(By by) {
      sleep(STEP_TIME);
      waitForElementToBeClickable(by).click();
      logConsole("Click on element " + by);
   }

   public static void clickElement(By by, int seconds) {
      sleep(STEP_TIME);
      waitForElementToBeClickable(by, seconds).click();
      logConsole("Click on element " + by);
   }

   public static void setText(By by, String text) {
      sleep(STEP_TIME);
      waitForElementVisible(by).sendKeys(text);
      logConsole("Set text " + text + " on element " + by);
   }

   public static void setText(By by, String text, int seconds) {
      sleep(STEP_TIME);
      waitForElementVisible(by, seconds).sendKeys(text);
      logConsole("Set text " + text + " on element " + by);
   }

   public static String getElementText(By by) {
      waitForElementVisible(by);
      sleep(STEP_TIME);
      logConsole("Get text of element " + by);
      String text = getWebElement(by).getText();
      logConsole("==> TEXT: " + text);
      return text; //Trả về một giá trị kiểu String
   }

   public static String getElementAttribute(By by, String attributeName) {
      waitForElementVisible(by);
      System.out.println("Get attribute of element " + by);
      String value = getWebElement(by).getAttribute(attributeName);
      System.out.println("==> Attribute value: " + value);
      return value;
   }

   public static String getElementCssValue(By by, String cssPropertyName) {
      waitForElementVisible(by);
      System.out.println("Get CSS value " + cssPropertyName + " of element " + by);
      String value = getWebElement(by).getCssValue(cssPropertyName);
      System.out.println("==> CSS value: " + value);
      return value;
   }
}
