package com.thetestingacademy.Day43.TESTNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day43_Exercise12_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);

    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1(){
        System.out.println("Method1");
        Assert.assertTrue(true);

    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method2(){
        System.out.println("Method 2");
        Assert.assertTrue(true);

    }
}
