package com.everis.base;


import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FreetogameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FreetogameService.class);
    static private final String BASE_URL = "https://www.freetogame.com/api/";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec,responseSpe2c;


    private RequestSpecBuilder builder;


    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        responseSpe2c = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Step("obtiene la informacion")
    public void plataforms(String platform) {

        given().
                spec(requestSpec).
                queryParam("platform", platform).
                when().
                get("games").
                then().
                spec(responseSpec).
                and();
    }
    @Step("obtiene la informacion")
    public void category(String category) {

        given().
                spec(requestSpec).
                queryParam("category", category).
                when().
                get("games").
                then().
                spec(responseSpec).
                and();
    }

    @Step("obtiene la informacion")
    public void category2(String category) {

        given().
                spec(requestSpec).
                queryParam("category", category).
                when().
                get("games").
                then().
                spec(responseSpe2c).
                and();
    }










    @Step("set Header")
    public void setHeader(String k, String v) {
        builder.addHeader(k, v);
    }










    public void validateStatusCode(int i) {
        assertThat(lastResponse().statusCode(), is(i));
    }



}
