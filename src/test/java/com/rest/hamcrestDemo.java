package com.rest;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class hamcrestDemo
{
    @org.testng.annotations.Test
    public void test()
    {
        baseURI="https://reqres.in";
        String  name = given().
                                queryParam("page","2").
                                config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
                    when().
                            get("/api/users").
                    then().
                            assertThat().statusCode(200).extract().response().path("data[1].first_name");
        System.out.println("First name =" + name);
        //System.out.println("response = " + res.asString());

        assertThat(name,equalTo("Lindsay"));


    }
}
