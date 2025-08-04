package com.anhtester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {

   private static int WAIT_TIMEOUT = 10;

   public static void highlightElement(WebDriver driver, WebElement element) {
      // Highlight the element using JavaScript
      String script = "arguments[0].style.border='3px solid red';";

      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript(script, element);
   }

   public static void highlightElement(WebDriver driver, WebElement element, String color) {
      // Highlight the element using JavaScript
      String script = "arguments[0].style.border='3px solid " + color + "';";
      ((JavascriptExecutor) driver).executeScript(script, element);
   }

   public static void clickElement(WebDriver driver, By by) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
      wait.until(ExpectedConditions.elementToBeClickable(by));
      highlightElement(driver, driver.findElement(by));
      driver.findElement(by).click();
   }

   public static void clickElement(WebDriver driver, WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
      wait.until(ExpectedConditions.elementToBeClickable(element));
      highlightElement(driver, element);
      element.click();
   }

   public static void clickElement(WebDriver driver, By by, int seconds) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
      wait.until(ExpectedConditions.elementToBeClickable(by)).click();
//      driver.findElement(by).click();
   }

   public static void setText(WebDriver driver, By by, String text) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
      wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
//      driver.findElement(by).sendKeys(text);
   }

   public static void setText(WebDriver driver, WebElement element, String text) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
      wait.until(ExpectedConditions.visibilityOf(element));
      highlightElement(driver, element);
      element.sendKeys(text);
   }
}
