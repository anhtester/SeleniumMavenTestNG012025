package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class DemoAnnotation extends ParentClass {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeGroups(groups = { "testOne" })
    public void beforeGroupOne() {
        System.out.println("Before Group testOne");
    }

    @AfterGroups(groups = { "testOne" })
    public void afterGroupOne() {
        System.out.println("After Group testOne");
    }

    @BeforeGroups(groups = { "testTwo" })
    public void beforeGroupTwo() {
        System.out.println("Before Group testTwo");
    }

    @AfterGroups(groups = { "testTwo" })
    public void afterGroupTwo() {
        System.out.println("After Group testTwo");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(groups = { "testOne" }, alwaysRun = true, description = "This is test method 1")
    public void testOneMethod() {
        System.out.println("Test method 1");
    }

    @Test(groups = { "testTwo" }, enabled = true, timeOut = 3000)
    public void testTwoMethod() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Test method 2");
    }

}