package Utils;

import org.apache.maven.surefire.shared.lang3.SystemProperties;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {

        Properties globalproperties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"/src/test/Resources/global.properties");
        globalproperties.load(fis);
        String url = globalproperties.getProperty("QAurl");
        String browser = globalproperties.getProperty("browser");
        //String browser_maven = System.getProperty("browser");
        // Java ternary operator (conditional statement)
       // String browser = browser_maven!=null ? browser_maven : browser_properties;
        if (driver == null) {

            if(browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }
            else if(browser.equalsIgnoreCase("edge")){
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
            return driver;
        }
    }

