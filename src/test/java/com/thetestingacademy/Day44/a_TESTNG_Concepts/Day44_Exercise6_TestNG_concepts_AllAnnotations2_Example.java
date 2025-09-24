package com.thetestingacademy.Day44.a_TESTNG_Concepts;

import org.testng.annotations.*;

public class Day44_Exercise6_TestNG_concepts_AllAnnotations2_Example {

    @BeforeSuite
    void demo1(){
        System.out.println("Read the data from MySQL");
    }

    @BeforeTest
    void demo2(){
        System.out.println("Data in Matrix, TC Before");
    }

    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("After Method");
    }

    @AfterClass
    void demo7(){
        System.out.println("After Class");
    }

    @AfterTest
    void demo8(){
        System.out.println("After Test");
    }

    @AfterSuite
    void demo9(){
        System.out.println("After Suite");
        System.out.println("Close everything, Delete all the Temp files");
    }

}
