package com.anhtester.Bai24_Parameters_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters {
   @Test(priority = 1)
   @Parameters({"number1", "number2"})
   public void testParameter01(@Optional("50") int a, @Optional("60") int b) {
      System.out.println("A + B = " + (a + b));
   }

   @Test(priority = 2)
   @Parameters({"number1", "number2", "number3"})
   public void testParameter02(int a, int b, int c) {
      System.out.println("A + B + C = " + (a + b + c));
   }

   @Test(priority = 3)
   @Parameters({"number1", "number2", "number3"})
   public void testParameter03(int a, int b, int c) {
      System.out.println("A * B * C = " + (a * b * c));
   }

}
