package mx.com.kapitalbank.qa.automation.runners.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "mx.com.kapitalbank.qa.automation.steps.unitary",
        features = "classpath:features/unitary/openpage.feature",
        plugin = {"pretty"}
)
public class IT_OpenPage extends AbstractTestNGCucumberTests {
}
