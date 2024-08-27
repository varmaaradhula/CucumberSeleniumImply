package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }


    By itemInCart = By.xpath("//table[@class='cartTable']/tbody/tr/td[2]");
    By CartImg = By.xpath("//img[@alt='Cart']");
    By proceedtoChkOutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By promoApplyBtn = By.cssSelector(".promoBtn");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
    By incrementBtn = By.cssSelector(".increment");
    By addToCartBtn = By.xpath("//button[contains(text(),'ADD TO CART')]");


    public List<WebElement> getCartItems(){
        List<WebElement> cartItems = driver.findElements(itemInCart);
        return cartItems;
    }

    public void proceedToCheckOut(){
        driver.findElement(CartImg).click();
        driver.findElement(proceedtoChkOutBtn).click();
    }

    public boolean VerifyPromoBtn(){

        return driver.findElement(promoApplyBtn).isDisplayed();
    }

    public boolean VerifyPlaceOrderBtn(){

        return driver.findElement(placeOrderBtn).isDisplayed();
    }

    public void addItemToCart(){

        driver.findElement(addToCartBtn).click();
    }

    public void increseItemCount(String number){
        int requiredCount = Integer.parseInt(number);
        for(int i=1; i<requiredCount; i++){
            driver.findElement(incrementBtn).click();
        }
    }


}
