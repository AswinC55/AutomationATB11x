package com.thetestingacademy.Day43.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Day43_Exercise7_DELETE_NonBDDStyle {

    @Test
    public void test_DELETE_NonBDD(){

        String token = "b6dad5fc00698a3";
        String bookingid = "18733";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.log().all();

        Response response = r.when().log().all().delete();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(201);
    }
}
