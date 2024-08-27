package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OffersPage {

    public WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    By searchBox = By.xpath("//input[@id='search-field']");
    By searchResultProduct = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]");

    public void searchItem(String name){
        driver.findElement(searchBox).sendKeys(name);
    }

    public List<WebElement> getSearchResults(){
        List<WebElement> results = driver.findElements(searchResultProduct);
        return results;
    }
}
