package com.thetestingacademy.Day44.b_Test_Assertions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.build.Plugin;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class Day44_Exercise11_Challenge1 {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Owner("Aswin")
    @Description("TC#1 - POST - Verify the token is created")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void create_Token(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response=r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

    }

    @Owner("Aswin")
    @Description("TC#2 - POST - Verify the Booking ID is created")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void create_Booking(){

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

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        response = r.when().log().all().post();

        vr = response.then().log().all();

        vr.body("booking.firstname", Matchers.equalTo("Siva"));
        vr.body("booking.lastname", Matchers.equalTo("Prasath"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());
        vr.statusCode(200);

    }

    @Owner("Aswin")
    @Description("TC#3 - GET - Verify the GET booking API")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void get_booking(){

        String bookingid = "1744";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.log().all();

        response=r.when().log().all().get();

        vr = response.then().log().all();

        vr.statusCode(200);


    }

    @Owner("Aswin")
    @Description("TC#4 - PATCH - Verify the Partial Update booking API")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4)
    public void patch_partial_update_booking(){

        String bookingid = "1744";
        String token = "618af41688a2e0c";
        String payload = "{\n" +
                "    \"firstname\" : \"Aswin\",\n" +
                "    \"lastname\" : \"C\"\n" +
                "}";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload).log().all();

        response = r.when().log().all().patch();

        vr = response.then().log().all();
        vr.statusCode(200);



    }

    @Owner("Aswin")
    @Description("TC#5 - PUT - Verify the UpdateBooking API")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5)
    public void put_booking(){

        String token = "618af41688a2e0c";
        String bookingid ="1744";
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 117,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();

        vr.statusCode(200);



    }

    @Owner("Aswin")
    @Description("TC#6 - DELETE - Verify the Delete Booking API")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6)
    public void delete_booking(){

        String token = "618af41688a2e0c";
        String bookingid ="1744";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.log().all();

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }



}
