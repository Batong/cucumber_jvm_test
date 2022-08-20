package drivers;

import io.restassured.RestAssured;

public class API {

    public static void setup(String URI, String endpoint, String port) {
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        RestAssured.basePath = endpoint;
        RestAssured.baseURI = URI;

    }

}