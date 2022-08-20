import drivers.API;
import io.restassured.response.Response;
import io.cucumber.java8.En;

import static io.restassured.RestAssured.given;

public class APIStepDefinitions implements En {
    private Response response;

    public APIStepDefinitions() {
        Given("^I add the \"([^\"]*)\" URL with endpoint \"([^\"]*)\"$", (String URI, String endpoint) -> {
            API.setup(URI, endpoint, "443");
        });

        When("^I execute the request$", () -> {
            response = given().when().get("");
        });

        Then("^the correct \"([^\"]*)\" response is returned$", (String responseCode) -> {
            response.then().statusCode(Integer.parseInt(responseCode));
        });
    }
}
