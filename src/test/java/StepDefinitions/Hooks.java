package StepDefinitions;

import Utils.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    public TestContextSetUp testContext;
    public Hooks(TestContextSetUp testContext){

        this.testContext = testContext;
    }
    @After
    public void AfterScenario() throws IOException {
        testContext.testBase.webDriverManager().quit();
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContext.testBase.webDriverManager();
        if(scenario.isFailed()){
           File sourcePath =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           byte[] fileContent =  FileUtils.readFileToByteArray(sourcePath);
           scenario.attach(fileContent, "image/png", "image");
        }
    }
}
