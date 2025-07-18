package com.anhtester.keywords;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUI {
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
}
