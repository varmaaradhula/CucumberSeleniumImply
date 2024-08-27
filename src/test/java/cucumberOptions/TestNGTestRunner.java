package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/java/Features", glue="StepDefinitions", monochrome = true, tags=" @SearchProduct",
plugin={"html:target/cucumber.html","json:target/cucumberjason.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"})
//@CucumberOptions(features="src/test/java/Features", glue="StepDefinitions", monochrome = true, dryRun = true)
//@CucumberOptions(features="src/test/java/Features", glue="StepDefinitions", monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){

        return super.scenarios();
    }


}
