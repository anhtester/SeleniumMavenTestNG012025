package com.anhtester.Bai13_Alert_Popup_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest {
   @Test
   public void demoHandleIFrame() throws InterruptedException {

      driver.navigate().to("https://www.lambdatest.com/selenium-playground/iframe-demo/");
      Thread.sleep(3000);
      System.out.println("IFrame total: " + driver.findElements(By.tagName("iframe")).size());

      //----Switch to content of iframe (Editor)--------
      driver.switchTo().frame(0); //Thẻ iframe thứ nhất
      Thread.sleep(1000);
      System.out.println(driver.findElement(By.xpath("//div[@class='rsw-ce']")).getText());

      //1. Switch to Parent WindowHandle
      driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào
      Thread.sleep(1000);
      //2. Switch to iframe icon of Messenger
      driver.switchTo().frame(1); //Thẻ iframe thứ hai
      driver.findElement(By.xpath("//a[normalize-space()='API Reference']")).click(); //Nhấn icon để ẩn messenger chat đi

      Thread.sleep(2000);
   }

}
