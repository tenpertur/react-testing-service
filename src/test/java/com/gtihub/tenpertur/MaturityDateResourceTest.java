package com.gtihub.tenpertur;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MaturityDateResourceTest {

    @Test
    public void testDateEndpoint() {
        given()
          .when().get("/date?duration=3m&from=2021-10-11")
          .then()
             .statusCode(200)
             .body(is("2022-01-11"));
    }

}