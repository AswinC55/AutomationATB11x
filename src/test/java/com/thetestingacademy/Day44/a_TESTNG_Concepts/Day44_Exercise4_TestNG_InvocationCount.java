package com.thetestingacademy.Day44.a_TESTNG_Concepts;

import org.testng.annotations.Test;

public class Day44_Exercise4_TestNG_InvocationCount {

    @Test(invocationCount = 2)
    public void test1(){
        System.out.println("Hi");
    }

    @Test(invocationCount = 3)
    public void test2(){
        System.out.println("Bye");
    }

    @Test
    public void test3(){
        System.out.println("Something");
    }
}
