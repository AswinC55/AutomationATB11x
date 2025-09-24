package com.thetestingacademy.Day45.Payload_Management.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Day45_Exercise1_Payload_HashMap {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){

        //        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Siva\",\n" +
//                "    \"lastname\" : \"Prasath\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Lunch\"\n" +
//                "}";

        //HashMap -> Key and Value

        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Siva");
        jsonBodyUsingMap.put("lastname","Prasath");
        jsonBodyUsingMap.put("totalprice",111);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2024-01-01");
        bookingDatesMap.put("checkout","2024-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","Lunch");
        System.out.println(jsonBodyUsingMap);

        //After gson
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonBodyUsingMap).log().all();

        response = r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

        vr.body("booking.firstname", Matchers.equalTo("Siva"));
        vr.body("booking.lastname", Matchers.equalTo("Prasath"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());
    }
}
