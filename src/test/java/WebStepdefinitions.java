import io.cucumber.java8.En;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class WebStepdefinitions implements En {

    private WebDriver driver;

    private HomePage homePage;

    public WebStepdefinitions() {

        Given("^I browse to the main site$", () -> {
            driver = new ChromeDriver();;
            homePage = new HomePage(driver);
            assertTrue(homePage.onHomePage());
        });

        When("^the correct week should be displayed$", () -> {
            assertTrue(homePage.correctDateDisplayed());
            driver.close();
        });

    }
}
