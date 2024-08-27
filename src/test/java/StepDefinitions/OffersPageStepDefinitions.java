package StepDefinitions;

import PageObjects.LandingPge;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OffersPageStepDefinitions {
    public TestContextSetUp testContext;
    public String offerPageVegName;
    public PageObjectManager pageObjectManager;

    public OffersPageStepDefinitions(TestContextSetUp testContext){

        this.testContext = testContext;

    }

    @Then("^user searched for same shortname (.+) in offers page$")
    public void user_searched_for_same_shortname_in_offers_page(String veggieShortName) throws InterruptedException {
       testContext.pageObjectManager.getLandingPage().selectTopDealsPage();
        switchToChildWindow();
        OffersPage offerpage = testContext.pageObjectManager.getOffersPage();
        offerpage.searchItem(veggieShortName);
        List<WebElement> searchResult = offerpage.getSearchResults();
        List<WebElement> reqvegOnOfferPage = searchResult.stream().filter(s->s.getText().contains(veggieShortName)).collect(Collectors.toList());
        offerPageVegName = reqvegOnOfferPage.get(0).getText().trim();
        System.out.println("Name of the veggie on Offers page: "+offerPageVegName);
        boolean match = searchResult.stream().anyMatch(veggie -> veggie.getText().contains(veggieShortName));
        Assert.assertTrue(match);
    }

    public void switchToChildWindow(){
        //LandingPge landingpage = testContext.pageObjectManager.getLandingPage();
        if(testContext.genericUtils.getPageUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers")){
            System.out.println("Already on Child page");
        }
        else {
            System.out.println("moving to Child page");
            testContext.genericUtils.switchWindowsToChild();
        }
    }
    @Then("Validate veg name on homepage and offer page")
    public void validate_veg_name_on_homepage_and_offer_page() {
        Assert.assertEquals(testContext.homePageVegName,offerPageVegName);
    }


}
