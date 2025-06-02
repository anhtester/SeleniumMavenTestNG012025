package com.anhtester.Bai9_SetupTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTestNG {

    WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[@class='card__title mt-0']//a[contains(text(),'Sử dụng Chat AI để generate code Test Automation')]"));
        Assert.assertEquals(element.getText(), "Sử dụng Chat AI để generate code Test Automation", "Title of the blog post does not mach!");
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void testSearchOnYouTube() throws InterruptedException {
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(2000);
        WebElement videoTitle = driver.findElement(By.xpath("//a[@title='Anh Tester Automation Testing']"));
        Assert.assertTrue(videoTitle.isDisplayed(), "Video title is not displayed!");
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}