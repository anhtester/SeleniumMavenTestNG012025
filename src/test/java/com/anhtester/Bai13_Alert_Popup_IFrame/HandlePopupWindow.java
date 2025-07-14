package com.anhtester.Bai13_Alert_Popup_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopupWindow extends BaseTest {
   @Test
   public void demoOpenNewTab() throws InterruptedException {
      driver.get("https://anhtester.com");
      Thread.sleep(1000);
      driver.switchTo().newWindow(WindowType.TAB);
      Thread.sleep(1000);
      driver.get("https://google.com");
      Thread.sleep(2000);
   }

   @Test
   public void demoOpenNewWindow() throws InterruptedException {
      driver.get("https://anhtester.com");
      Thread.sleep(1000);
      driver.switchTo().newWindow(WindowType.WINDOW);
      Thread.sleep(1000);
      driver.get("https://google.com");
      Thread.sleep(2000);
   }

   @Test
   public void demoNotSwitchToTab() throws InterruptedException {
      driver.get("https://demoqa.com/browser-windows");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@id='tabButton']")).click();
      Thread.sleep(1000);
      //Sau khi chuyển hướng sang Tab mới thì getText cái header
      System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
      Thread.sleep(1000);
   }

   @Test
   public void demoHandlePopupTypeTab() throws InterruptedException {
      driver.get("https://demoqa.com/browser-windows");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@id='tabButton']")).click();
      Thread.sleep(1000);
      // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
      String MainWindow = driver.getWindowHandle();
      System.out.println(MainWindow);

      // Lấy tất cả các mã định danh Tab Window.
      Set<String> windows = driver.getWindowHandles();

      //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
      //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
      for (String window : windows) {
         System.out.println(window);
         if (!MainWindow.equals(window)) {
            //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
            //Chuyển hướng driver đến Tab mới (Tab con)
            driver.switchTo().window(window);
            Thread.sleep(1000);
            System.out.println("Đã chuyển đến Tab Window mới");

            //Một số hàm hỗ trợ
            System.out.println(driver.switchTo().window(window).getTitle());
            System.out.println(driver.switchTo().window(window).getCurrentUrl());

            Thread.sleep(1000);
            //Sau khi chuyển hướng sang Tab mới thì getText cái header
            System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

            // Tắt cái Tab Window mới.
            Thread.sleep(1000);
            driver.close();
         }
      }

      // Chuyển hướng về lại tab chính ban đầu (Main Window)
      driver.switchTo().window(MainWindow);
      System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

      Thread.sleep(1000);
   }

   @Test
   public void demoHandlePopupTypeTab_Position() throws InterruptedException {
      driver.get("https://demoqa.com/browser-windows");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@id='tabButton']")).click();
      Thread.sleep(1000);
      // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
      String MainWindow = driver.getWindowHandle();
      System.out.println(MainWindow);

      // Lấy tất cả các mã định danh Tab Window.
      Set<String> windows = driver.getWindowHandles();

      String firstWindow = (String)windows.toArray()[0]; //Cửa sổ đầu
      String secondWindow = (String)windows.toArray()[1]; //Cửa sổ thứ hai

      driver.switchTo().window(secondWindow);
      Thread.sleep(1000);
      System.out.println("Đã chuyển đến Tab Window mới");

      //Một số hàm hỗ trợ
      System.out.println(driver.switchTo().window(secondWindow).getTitle());
      System.out.println(driver.switchTo().window(secondWindow).getCurrentUrl());

      Thread.sleep(1000);
      //Sau khi chuyển hướng sang Tab mới thì getText cái header
      System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

      // Tắt cái Tab Window mới.
      Thread.sleep(1000);
      driver.close();

      // Chuyển hướng về lại tab chính ban đầu (Main Window)
      driver.switchTo().window(MainWindow);
      System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

      Thread.sleep(1000);
   }

}
