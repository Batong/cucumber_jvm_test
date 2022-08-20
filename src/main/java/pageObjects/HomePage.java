package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class HomePage {
    final WebDriver driver;
    @FindBy(tagName = "time")
    WebElement week;

    static final String HOMEPAGE = "https://www.vecka.nu/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get(HOMEPAGE);
    }

    public boolean onHomePage() {
        return this.driver.getCurrentUrl().equals(HOMEPAGE);
    }

    public boolean correctDateDisplayed() {
        return week.getText().equals(getCurrentWeek());
    }

    private String getCurrentWeek() {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return String.valueOf(date.get(weekFields.weekOfWeekBasedYear()));
    }

}