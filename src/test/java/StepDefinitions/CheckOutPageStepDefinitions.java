package StepDefinitions;

import PageObjects.CheckoutPage;
import PageObjects.LandingPge;
import Utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOutPageStepDefinitions {
public WebDriver driver;
public String expectedSerachResult = "Tomato";
public String homePageVegName;
public String offerPageVegName;
public TestContextSetUp testContext;
public CheckoutPage checkoutPage;

public CheckOutPageStepDefinitions(TestContextSetUp testContext){
    this.testContext = testContext;
    this.checkoutPage = testContext.pageObjectManager.getCheckOutPage();
}

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
    checkoutPage.increseItemCount(quantity);
    checkoutPage.addItemToCart();
    }
    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String shortName) {
        checkoutPage.proceedToCheckOut();
        List<WebElement> cartItems = checkoutPage.getCartItems();
        List<WebElement> ReqitemnamesInCart = cartItems.stream().filter(item->item.getText().contains(shortName)).collect(Collectors.toList());
        String nameOfItemInCart = ReqitemnamesInCart.get(0).getText().split("-")[0];
        System.out.println("Name of the Veggie on CheckOut Page: "+nameOfItemInCart);
        boolean match = ReqitemnamesInCart.stream().anyMatch(veggie -> veggie.getText().contains(shortName));
    }
    @Then("very user has ability to enter promo code and place the order")
    public void very_user_has_ability_to_enter_promo_code_and_plce_the_order() {
    Assert.assertTrue(checkoutPage.VerifyPromoBtn());
    Assert.assertTrue(checkoutPage.VerifyPlaceOrderBtn());

    }

}
