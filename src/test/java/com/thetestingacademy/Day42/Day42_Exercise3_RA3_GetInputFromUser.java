package com.thetestingacademy.Day42;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Day42_Exercise3_RA3_GetInputFromUser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pincode!");
        String pincode = sc.next();

        RestAssured.given()
                        .baseUri("https://api.postalpincode.in")
                        .basePath("/pincode/" +pincode)
                   .when()
                        .get()
                   .then()
                        .log().all().statusCode(200);

    }
}
