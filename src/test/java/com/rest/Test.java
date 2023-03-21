package com.rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test
{
    @org.testng.annotations.Test
    public void test()
    {
        baseURI="https://reqres.in";
        Response res = given().queryParam("page","2").
        when().get("/api/users").
        then().
                log().all().
                assertThat().statusCode(200).extract().response();
        JsonPath jsonPath = new JsonPath(res.asString());
        System.out.println(("First name =" + jsonPath.getString("data[1].first_name")));
        //System.out.println("response = " + res.asString());

    }
}
