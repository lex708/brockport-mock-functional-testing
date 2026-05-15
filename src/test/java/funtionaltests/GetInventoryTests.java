package funtionaltests;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


public class GetInventoryTests {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void getInventoryReturnsStatus200() {

        // Arrange & Act
        given()
                .when()
                .get("/inventory")

                // Assert
                .then()
                .log().all()
                .statusCode(200)
                .body(containsString("cost"));
    }
}