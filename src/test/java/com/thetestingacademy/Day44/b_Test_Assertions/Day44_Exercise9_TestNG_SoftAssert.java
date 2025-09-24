package com.thetestingacademy.Day44.b_Test_Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day44_Exercise9_TestNG_SoftAssert {

    @Test
    public void test_SoftAssert_Example(){
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start of the Program");
        softAssert.assertEquals("pramod","Pramod");
        System.out.println("End of the Program");
        softAssert.assertAll();

    }
}
