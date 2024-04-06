package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                plugin = {
                        "pretty", "html:target/cucumberHtmlReport",
                        "html:target/reports/cucumber/cucumber.html",     //  for html result
                        "json:target/cucumber.json"   // for json result
                },
                features = "src/test/java/feature/",
                glue = "steps"
        )

public class TestRunner extends AbstractTestNGCucumberTests {
}

