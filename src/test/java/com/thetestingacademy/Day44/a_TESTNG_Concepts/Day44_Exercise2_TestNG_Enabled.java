package com.thetestingacademy.Day44.a_TESTNG_Concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day44_Exercise2_TestNG_Enabled {

    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("t1");
    }

    @Test(enabled = false)
    public void test2(){
        Assert.assertTrue(true);
        System.out.println("t2");
    }

    @Test
    public void test3(){
        Assert.assertTrue(true);
        System.out.println("t3");
    }
}
