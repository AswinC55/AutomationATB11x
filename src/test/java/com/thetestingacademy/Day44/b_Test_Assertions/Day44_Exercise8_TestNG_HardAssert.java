package com.thetestingacademy.Day44.b_Test_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day44_Exercise8_TestNG_HardAssert {

    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Assert.assertEquals("pramod","Pramod");
        System.out.println("End of the Program");

    }
}
