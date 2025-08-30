package com.thetestingacademy.Day42;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Day42_Exercise7_TestNGWithAllureReport {

    String pincode = "621210" ;

    @Test
    public void test_GET_POSITIVE_TC1(){
        pincode = "621210";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in")
                .basePath("/pincode/" +pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void test_GET_NEGATIVE_TC2(){
        pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in")
                .basePath("/pincode/" +pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void test_GET_NEGATIVE_TC3(){
        pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in")
                .basePath("/pincode/" +pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

}
