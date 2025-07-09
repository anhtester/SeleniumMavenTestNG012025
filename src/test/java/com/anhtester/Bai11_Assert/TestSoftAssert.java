package com.anhtester.Bai11_Assert;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class TestSoftAssert extends BaseTest {

   @Test(priority = 1)
   public void testSoftAssert() throws InterruptedException {

      driver.get("https://anhtester.com");

      SoftAssert softassert = new SoftAssert();

      String expectedTitle = "Anh Tester";
      String actualTitle = driver.getTitle();

      System.out.println("*** Checking Home page Title ***");

      softassert.assertEquals(actualTitle, expectedTitle); //Fail

      driver.findElement(By.xpath("//a[@id='btn-login']")).click();
      Thread.sleep(2000);
      System.out.println("*** Checking the Login page Title ***");
      String actualLoginPageTitle = driver.getTitle();

      softassert.assertEquals(actualLoginPageTitle, "Login"); //Fail/Pass

      softassert.assertAll(); //Bắt buộc phải gọi assertAll() để kiểm tra tất cả các assert đã được thực hiện
   }
}
