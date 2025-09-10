package com.thetestingacademy.Day43.TESTNG_Examples;

import org.testng.annotations.Test;

public class Day43_Exercise10_Priority {

    @Test
    public void t1(){
        System.out.println("1");
    }

    @Test
    public void t3(){
        System.out.println("3");
    }

    @Test
    public void t2(){
        System.out.println("2");
    }

    @Test
    public void t4(){
        System.out.println("4");
    }

    @Test(priority = 1)
    public void t5(){
        System.out.println("5");
    }

    @Test(priority = 5)
    public void t6(){
        System.out.println("9");
    }

    @Test(priority = 3)
    public void t7(){
        System.out.println("7");
    }

    @Test(priority = 4)
    public void t8(){
        System.out.println("8");
    }

    @Test(priority = 2)
    public void t9(){
        System.out.println("6");
    }

}
