package org.bharath.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Sample {

    @Test
    public void test() {
        Map<String, String> ELKMap = new HashMap<>();
        ELKMap.put("test", "test10");
        ELKMap.put("status", "pass");
        ELKMap.put("executiontime", String.valueOf(LocalDate.now()));
        RestAssured.given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(ELKMap)
                .when()
                .post("http://localhost:9200/results/_doc/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);
    }
}

