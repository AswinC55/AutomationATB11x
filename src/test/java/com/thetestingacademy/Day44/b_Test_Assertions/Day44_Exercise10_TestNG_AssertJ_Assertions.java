package com.thetestingacademy.Day44.b_Test_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Day44_Exercise10_TestNG_AssertJ_Assertions {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    Integer bookingId;


    @Test
    public void test_POST(){
        String payload = "{\n" +
                "    \"firstname\" : \"Siva\",\n" +
                "    \"lastname\" : \"Prasath\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response = r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5

        vr.body("booking.firstname", Matchers.equalTo("Siva"));
        vr.body("booking.lastname", Matchers.equalTo("Prasath"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());

        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // HardAssert
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        Assert.assertEquals(firstname,"Siva");
        Assert.assertEquals(lastname,"Prasath");
        Assert.assertNotNull(bookingId);


        //AssertJ(3rd Lib to Assertions) -20%

        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Siva").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();

        //        String s1 = null //Null
        //        String s2 = ""; //Empty
        //        String s3 = " "; //Blank


    }

}
