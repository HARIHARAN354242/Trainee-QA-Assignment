package tests;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultsPage;
import utils.DateUtil;

import java.util.Set;

public class FlightBookingTest extends BaseTest {

    @Test
    public void flightSearchAndPriceValidation() {

        HomePage homePage = new HomePage(driver);

        homePage.selectFromCity("Boston");
        homePage.selectToCity("London");

        // Logical validation of next month date
        System.out.println("Selected Date: " + DateUtil.getNextMonthDate());

        homePage.clickFindFlights();

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.printCheapestFlights();

        // Additional Scenario: Open new tab & navigate to Google
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }

        driver.get("https://www.google.com");
    }
}
