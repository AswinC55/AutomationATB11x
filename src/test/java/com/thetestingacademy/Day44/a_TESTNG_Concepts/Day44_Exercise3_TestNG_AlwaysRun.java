package com.thetestingacademy.Day44.a_TESTNG_Concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day44_Exercise3_TestNG_AlwaysRun {

    @Test
    public void test_new_register(){
        Assert.assertTrue(true);
        System.out.println("Register");
    }

    @Test(alwaysRun = true, enabled = false)
    public void test_login(){
        Assert.assertTrue(true);
        System.out.println("Login");
    }

    @Test
    public void test_normal(){
        Assert.assertTrue(true);
        System.out.println("Normal");
    }
}
