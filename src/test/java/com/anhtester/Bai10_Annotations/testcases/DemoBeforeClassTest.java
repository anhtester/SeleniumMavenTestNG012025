package com.anhtester.Bai10_Annotations.testcases;

import com.anhtester.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DemoBeforeClassTest extends BaseTest_BeforeClass {

    @Test(priority = 1)
    public void testLoginSuccess() throws InterruptedException {
        System.out.println("testLoginSuccess");
        driver.get(LocatorsCRM.url);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin123@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);
        // Verify login success
        System.out.println("Đăng nhập CRM thành công");
    }

    @Test(priority = 2)
    public void testAddNewCustomer() throws InterruptedException {
        String customerName = "Anh Tester " + System.currentTimeMillis();

        System.out.println("testAddNewCustomer");
//        driver.get(LocatorsCRM.url);
//        Thread.sleep(1000);
//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
//        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();

        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(customerName);
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0912345678");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://anhtester.com");

        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("VIP", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath(LocatorsCRM.optionLanguage)).click();
        //driver.findElement(By.xpath(LocatorsCRM.selectXpathLanguage("German"))).click();

        String languageXpath = String.format(LocatorsCRM.optionLanguageDynamic, "Vietnamese", 1);

        driver.findElement(By.xpath(languageXpath)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Omon");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorsCRM.inputZip)).sendKeys("12345");

        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam", Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();

        Thread.sleep(2000);

        System.out.println("Thêm mới khách hàng thành công: " + customerName);
    }
}
