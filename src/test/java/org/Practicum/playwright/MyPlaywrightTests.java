package org.Practicum.playwright;

import com.microsoft.playwright.*;
import org.Practicum.Report.ReportManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MyPlaywrightTests {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    @BeforeAll
    public static void setUp() {
        ReportManager.startReport();
        ReportManager.createTest("Mail Travel");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

    }

    @AfterAll
    public static void tearDown() {
        browser.close();
        playwright.close();
        ReportManager.flushReport();
    }

    @Test
    public void myTest() {
        MailTravelHomePage mailTravelHomePage = new MailTravelHomePage(page);
        mailTravelHomePage.step1();
        mailTravelHomePage.step2("india");
        mailTravelHomePage.step3();
        mailTravelHomePage.step4();
        mailTravelHomePage.step5();
        mailTravelHomePage.step6();
        mailTravelHomePage.step7();
    }

}
