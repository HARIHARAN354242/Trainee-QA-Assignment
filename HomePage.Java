package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By fromCity = By.name("fromPort");
    private By toCity = By.name("toPort");
    private By findFlightsBtn = By.cssSelector("input[type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromCity(String city) {
        driver.findElement(fromCity).sendKeys(city);
    }

    public void selectToCity(String city) {
        driver.findElement(toCity).sendKeys(city);
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsBtn).click();
    }
}
