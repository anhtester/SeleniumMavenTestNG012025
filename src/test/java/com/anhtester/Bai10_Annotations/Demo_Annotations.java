package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class Demo_Annotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite Chạy trước toàn bộ suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite Chạy sau toàn bộ suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest Chạy trước tất cả các test trong một thẻ <test>");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest Chạy sau tất cả các test trong một thẻ <test>");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Call Database lấy dữ liệu trước khi chạy test");
        System.out.println("@BeforeClass Chạy trước tất cả các test trong class này");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass Chạy sau tất cả các test trong class này");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod Chạy trước mỗi phương thức test");
        System.out.println("Mở trình duyệt trước mỗi test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod Chạy sau mỗi phương thức test");
        System.out.println("Chụp màn hình và ghi log sau mỗi test");
        System.out.println("Đóng trình duyệt sau mỗi test");
    }

    @BeforeGroups("login")
    public void beforeGroup() {
        System.out.println("@BeforeGroups Chạy trước nhóm test tên là 'login'");
    }

    @Test
    public void test_LoginSuccess() {
        System.out.println("test_LoginSuccess");
    }

    @Test
    public void test_LoginFailWithEmailInvalid() {
        System.out.println("test_LoginFailWithEmailInvalid");
    }

    @Test(groups = {"login", "regression"})
    public void test_LoginWithPasswordInvalid() {
        System.out.println("test_LoginWithPasswordInvalid");
    }

    @Test()
    public void test_LoginFailWithEmailNull() {
        System.out.println("test_LoginFailWithEmailNull");
    }


}
