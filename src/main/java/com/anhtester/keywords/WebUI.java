package com.anhtester.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
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

   public static boolean checkElementExist(By by) {
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

   public static void setTextAndKey(By by, String value, Keys key) {
      waitForPageLoaded();
      getWebElement(by).sendKeys(value, key);
      System.out.println("Set text: " + value + " on element " + by);
   }

   public static void scrollToElement(By by) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
   }

   public static void scrollToElement(WebElement element) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(false);", element);
   }

   public static void scrollToElementAtTop(By by) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
   }

   public static void scrollToElementAtBottom(By by) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
   }

   public static void scrollToElementAtTop(WebElement element) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true);", element);
   }

   public static void scrollToElementAtBottom(WebElement element) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(false);", element);
   }

   public static void scrollToPosition(int X, int Y) {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollTo(" + X + "," + Y + ");");
   }

   public static boolean moveToElement(By by) {
      try {
         Actions action = new Actions(driver);
         action.moveToElement(getWebElement(by)).release(getWebElement(by)).build().perform();
         return true;
      } catch (Exception e) {
         logConsole(e.getMessage());
         return false;
      }
   }

   public static boolean moveToOffset(int X, int Y) {
      try {
         Actions action = new Actions(driver);
         action.moveByOffset(X, Y).build().perform();
         return true;
      } catch (Exception e) {
         logConsole(e.getMessage());
         return false;
      }
   }

   public static boolean hoverElement(By by) {
      try {
         Actions action = new Actions(driver);
         action.moveToElement(getWebElement(by)).perform();
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public static boolean mouseHover(By by) {
      try {
         Actions action = new Actions(driver);
         action.moveToElement(getWebElement(by)).perform();
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public static boolean dragAndDrop(By fromElement, By toElement) {
      try {
         Actions action = new Actions(driver);
         action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
         //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
         return true;
      } catch (Exception e) {
         logConsole(e.getMessage());
         return false;
      }
   }

   public static boolean dragAndDropElement(By fromElement, By toElement) {
      try {
         Actions action = new Actions(driver);
         action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
         return true;
      } catch (Exception e) {
         logConsole(e.getMessage());
         return false;
      }
   }

   public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
      try {
         Actions action = new Actions(driver);
         //Tính từ vị trí click chuột đầu tiên (clickAndHold)
         action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
         return true;
      } catch (Exception e) {
         logConsole(e.getMessage());
         return false;
      }
   }

   public static boolean pressENTER() {
      try {
         Robot robot = new Robot();
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public static boolean pressESC() {
      try {
         Robot robot = new Robot();
         robot.keyPress(KeyEvent.VK_ESCAPE);
         robot.keyRelease(KeyEvent.VK_ESCAPE);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public static boolean pressF11() {
      try {
         Robot robot = new Robot();
         robot.keyPress(KeyEvent.VK_F11);
         robot.keyRelease(KeyEvent.VK_F11);
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public static boolean verifyEquals(Object actual, Object expected) {
      waitForPageLoaded();
      System.out.println("Verify equals: " + actual + " and " + expected);
      boolean check = actual.equals(expected);
      return check;
   }

   public static void assertEquals(Object actual, Object expected, String message) {
      waitForPageLoaded();
      System.out.println("Assert equals: " + actual + " and " + expected);
      Assert.assertEquals(actual, expected, message);
   }

   public static boolean verifyContains(String actual, String expected) {
      waitForPageLoaded();
      System.out.println("Verify contains: " + actual + " and " + expected);
      boolean check = actual.contains(expected);
      return check;
   }

   public static void assertContains(String actual, String expected, String message) {
      waitForPageLoaded();
      System.out.println("Assert contains: " + actual + " and " + expected);
      boolean check = actual.contains(expected);
      Assert.assertTrue(check, message);
   }

}
