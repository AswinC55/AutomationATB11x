package com.thetestingacademy.Day43.TESTNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.SortedMap;

public class Day43_Exercise11_TestNG_Groups {

    @Test(groups = {"sanity", "reg"}, priority = 1)
    public void test_SanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg"}, priority = 2)
    public void test_RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"p1","reg"}, priority = 3)
    public void test_SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }




}
