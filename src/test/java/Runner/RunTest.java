package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.Practicum.Report.ReportManager;
import org.Practicum.playwright.MailTravelHomePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.microsoft.playwright.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Feature",
        glue = "org.Practicum.playwright",
        plugin = "html:target/cucumber-report.html"
)
public class RunTest {



    @BeforeClass
    public static void setUp() {
        ReportManager.startReport();
        ReportManager.createTest("Mail Travel");
    }

    @AfterClass
    public static void tearDown() {
        MailTravelHomePage.browser.close();
        MailTravelHomePage.playwright.close();
        ReportManager.flushReport();
    }
}
