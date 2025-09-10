package com.thetestingacademy.Day43.GET;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Day43_EXercise2_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_GET_Positive()
    {

        String pincode = "560066";

        //GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //WHEN
        response= r.when().log().all().get();
        System.out.println(response.asString());

        //THEN
        vr = response.then().log().all();
        vr.statusCode(200);

    }

    @Test
    public void test_GET_Negative()
    {

        String pincode = "@";

        //Given
        r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //When
        response = r.log().all().get();

        System.out.println(response.asString());

        //Then

        vr=response.then().log().all();
        vr.statusCode(404);




    }
}
