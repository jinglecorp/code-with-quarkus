package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.acme.utils.Constants;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get(Constants.PATH)
          .then()
             .statusCode(200)
             .body(containsString("Hello RESTEasy"));
    }

    @Test
    public void testGreetingEndpoint() {
        final String uuid = UUID.randomUUID().toString();
        given()
          .pathParam(Constants.NAME_PATH_VAR, uuid)
          .when().get(Constants.PATH + "/greeting/{" + Constants.NAME_PATH_VAR +"}")
          .then()
            .statusCode(200)
            .body(is("hello " + uuid));
    }

}