package StepDefinitions;

import PageObjects.LandingPge;
import Utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LandingPageStepDefinitions {
public WebDriver driver;
public String expectedSerachResult = "Tomato";
public String homePageVegName;
public String offerPageVegName;
public TestContextSetUp testContext;
public LandingPge landingPage;


public LandingPageStepDefinitions(TestContextSetUp testContext){
    this.testContext = testContext;
     this.landingPage = testContext.pageObjectManager.getLandingPage();
}

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        String landingPageTitle = landingPage.getTitleOfLandingPage();
        System.out.println("Landing Page Title: "+landingPageTitle);
        Assert.assertTrue(landingPageTitle.contains("GreenKart"));
    }
    @When("^User searched with shortname (.+) and extracted actual product$")
    public void user_searched_with_shortname_and_extracted_actual_product(String veggieShortName) {
        //LandingPge landingPage = testContext.pageObjectManager.getLandingPage();
        landingPage.searchItem(veggieShortName);
       List<WebElement> searchResult =landingPage.getSearchResults();
       List<WebElement> expectedveggies = searchResult.stream().filter(s->s.getText().contains(veggieShortName)).collect(Collectors.toList());
        testContext.homePageVegName = expectedveggies.get(0).getText().split("-")[0].trim();
        System.out.println("Name of the veggie on Lnding page: "+testContext.homePageVegName);
       boolean match = searchResult.stream().anyMatch(veggie -> veggie.getText().contains(veggieShortName));
        Assert.assertTrue(match);
    }

}
