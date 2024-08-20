package mx.com.kapitalbank.qa.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "mx.com.kapitalbank.qa.automation.page",
        features = "classpath:features/unitary/openpage.feature",
        plugin = {"pretty"}
)
public class IT_Page extends AbstractTestNGCucumberTests {
}
