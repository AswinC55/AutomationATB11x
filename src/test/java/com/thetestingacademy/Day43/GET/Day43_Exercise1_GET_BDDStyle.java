package com.thetestingacademy.Day43.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Day43_Exercise1_GET_BDDStyle {

    @Test
    public void test_GET_Positive(){
        String pin_code = "388620";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pin_code)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
