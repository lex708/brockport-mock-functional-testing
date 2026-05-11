package funtionaltests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class GetInventorySearchByPetTypeAndPetIdTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Test
    public void getDogByPetTypeAndPetIdReturnsStatus200() {
        given()
                .queryParam("petType", "DOG")
                .queryParam("petId", 1)
                .when()
                .get("inventory/search")
                .then()
                .log().all()
                .statusCode(200)
                .body(containsString("DOG"));
    }
}
