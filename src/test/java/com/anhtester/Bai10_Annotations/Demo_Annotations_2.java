package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class Demo_Annotations_2 {


    @BeforeClass
    public void beforeClass() {
        System.out.println("Call API lấy dữ liệu trước khi chạy test");
        System.out.println("@BeforeClass 2 Chạy trước tất cả các test trong class này");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass 2 Chạy sau tất cả các test trong class này");
    }

    @Test
    public void test_LoginSuccess() {
        System.out.println("Thực hiện kiểm thử đăng nhập - Success");
    }

    @Test
    public void test_LoginFail() {
        System.out.println("Thực hiện kiểm thử đăng nhập - Fail");
    }


}
