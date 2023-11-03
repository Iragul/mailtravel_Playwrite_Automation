package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Feature/Test.feature",
        glue = {"org.Practicum.mainframe", "org.Practicum.subframe"},
        plugin = "html:target/cucumber-report.html"
)
public class RunTest {
    // Add any additional setup or teardown methods if needed
}
