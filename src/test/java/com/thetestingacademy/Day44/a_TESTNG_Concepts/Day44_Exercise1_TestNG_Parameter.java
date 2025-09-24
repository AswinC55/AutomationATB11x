package com.thetestingacademy.Day44.a_TESTNG_Concepts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day44_Exercise1_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo(String value){
        System.out.println("I am Demo");
        System.out.println("I am running this param");

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox");
        }

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome");
        }
    }
}
