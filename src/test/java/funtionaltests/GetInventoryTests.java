package funtionaltests;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetInventoryTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Test
    public void getInventoryReturnsStatus200() {
        given()
                .when()
                .get("inventory")
                .then()
                .log().all()
                .statusCode(200);
    }
}

