package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultsPage {

    private WebDriver driver;

    private By prices = By.xpath("//table//tr/td[6]");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void printCheapestFlights() {

        List<WebElement> priceElements = driver.findElements(prices);
        List<Double> priceList = new ArrayList<>();

        for (WebElement price : priceElements) {
            priceList.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        priceList.sort(Comparator.naturalOrder());

        System.out.println("Cheapest Flight Price: $" + priceList.get(0));
        System.out.println("Second Cheapest Flight Price: $" + priceList.get(1));
    }
}
