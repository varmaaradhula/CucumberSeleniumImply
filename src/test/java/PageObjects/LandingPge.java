package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPge {

    public WebDriver driver;

    public LandingPge(WebDriver driver){
        this.driver = driver;
    }

    By searchBox = By.cssSelector(".search-keyword");
    By searchResultProduct = By.cssSelector(".product");
    By topDeals = By.xpath("//a[text()='Top Deals']");

    public void searchItem(String name){
        driver.findElement(searchBox).sendKeys(name);
    }

    public List<WebElement> getSearchResults(){
        List<WebElement> results = driver.findElements(searchResultProduct);
        return results;
    }

    public void selectTopDealsPage() throws InterruptedException {
        driver.findElement(topDeals).click();
        Thread.sleep(5000);
    }

    public String getTitleOfLandingPage(){
        return driver.getTitle();
    }
}
