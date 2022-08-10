package com.everis.base.stepDefinitions;

import com.everis.base.FreetogameService;
import com.everis.base.NetflixService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.everis.base.models.Book;
import com.everis.base.models.User;
import com.everis.base.stepDefinitions.ServicioSD;
import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FreetogamesSD {
    @Steps
    public FreetogameService freetogamesSD;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(NetflixService.class);
    static private final String BASE_URL = "https://www.freetogame.com/api/games";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;


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

    }
    @Given("que la aplicación esta activa")
    public void queLaAplicaciónEstaActiva() {


    }

    @When("consulto la plataforma: {string}")
    public void consultoLaPlataforma(String plataforms) {
        freetogamesSD.plataforms(plataforms);
    }

    @And("la categoria: {string}")
    public void laCategoria(String category) {
        freetogamesSD.category2(category);

    }

    @Then("valida que la respuesta sea {int}")
    public void validaQueLaRespuestaSea(int i) {
        freetogamesSD.validateStatusCode(i);
    }


    @Then("valida que la respuesta sea igual {int}")
    public void validaQueLaRespuestaSeaIgual(int i) {
        freetogamesSD.validateStatusCode(i);
    }

    @And("la categoria sea: {string}")
    public void laCategoriaSea(String category) {
        freetogamesSD.category(category);

    }

}
