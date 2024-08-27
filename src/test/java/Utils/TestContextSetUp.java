package Utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetUp {

    public WebDriver driver;
    public String expectedSerachResult = "Tomato";
    public String homePageVegName;
    public String offerPageVegName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetUp() throws IOException {
        testBase = new TestBase();
        pageObjectManager=new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());

    }
}
