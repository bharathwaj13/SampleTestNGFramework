package org.bharath.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.bharath.enums.ConfigProperties;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public final class ELKUtils {

    private ELKUtils() {
    }

    public static void sendDetailsToELK(String testName, String result) {
        if (PropertyFileReader.get(ConfigProperties.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
            Map<String, String> ELKMap = new HashMap<>();
            ELKMap.put("test", testName);
            ELKMap.put("status", result);
            ELKMap.put("executiontime", String.valueOf(LocalDate.now()));
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(ELKMap)
                    .when()
                    .post(PropertyFileReader.get(ConfigProperties.ELASTICURL))
                    .then()
                    .assertThat()
                    .statusCode(201)
                    .extract()
                    .response();
            response.prettyPrint();
        }
    }
}

