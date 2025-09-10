package com.thetestingacademy.Day43.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Day43_Exercise6_PATCH_NonBDDStyle {

    @Test
    public void test_PATCH_NonBDD(){

        String token = "21720da4fe7c84d";
        String bookingid = "341";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payloadPatch).log().all();

        Response response = r.when().log().all().patch();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);
    }


}
