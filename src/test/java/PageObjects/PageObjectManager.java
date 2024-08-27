package PageObjects;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LandingPge landingPge;
    public OffersPage offerPage;
    public CheckoutPage checkoutPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
    this.driver=driver;
    }

    public LandingPge getLandingPage(){
        landingPge = new LandingPge(driver);
        return landingPge;
    }
    
    public OffersPage getOffersPage(){
        offerPage= new OffersPage(driver);
        return offerPage;
    }

    public CheckoutPage getCheckOutPage(){

        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;

    }
}
