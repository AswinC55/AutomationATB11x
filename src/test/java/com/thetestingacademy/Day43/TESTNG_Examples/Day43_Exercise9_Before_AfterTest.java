package com.thetestingacademy.Day43.TESTNG_Examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.SortedMap;

public class Day43_Exercise9_Before_AfterTest {

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println("Before GET Token");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("Before GET Booking ID");
    }

    @Test
    public void test_PUT(){
        System.out.println("PUT Request");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Close");
    }
}
