package com.thetestingacademy.Day42;

import io.restassured.RestAssured;

public class Day42_Exercise2_RestAssured2 {
    public static void main(String[] args) {

        RestAssured.given()
                        .baseUri("https://api.postalpincode.in/pincode/621210")
                   .when()
                        .get()
                   .then()
                        .log().all().statusCode(200);

    }
}
