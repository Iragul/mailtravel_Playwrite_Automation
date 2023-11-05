package Runner;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.Before;
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
        features = "src/main/resources/Feature/Test.feature",
        glue = {"org.Practicum.playwright"},
        plugin = "html:target/cucumber-report.html"
)
public class RunTest {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    @BeforeClass
    public static void beforescenorio(){
        ReportManager.startReport();
        ReportManager.createTest("Mail Travel");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        new MailTravelHomePage(page);

    }
    @AfterClass
    public static void Afterscenorio(){
        browser.close();
        playwright.close();
        ReportManager.flushReport();

    }
}
