package com.thetestingacademy.Day42;

import io.restassured.RestAssured;

public class Day42_Exercise6_Multiple_Testcase {

    public static void main(String[] args) {


        String pincode = "621210";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in")
                .basePath("/pincode/" +pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

        pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in")
                .basePath("/pincode/" +pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

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
