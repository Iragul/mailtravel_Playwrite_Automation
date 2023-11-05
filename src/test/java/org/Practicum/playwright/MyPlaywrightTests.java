package org.Practicum.playwright;

import com.microsoft.playwright.*;
import org.Practicum.Report.ReportManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MyPlaywrightTests {



    @BeforeAll
    public static void setUp() {
        ReportManager.startReport();
        ReportManager.createTest("Mail Travel");


    }

    @AfterAll
    public static void tearDown() {
        MailTravelHomePage.browser.close();
        MailTravelHomePage.playwright.close();
        ReportManager.flushReport();
    }

    @Test
    public void myTest() {
        MailTravelHomePage mailTravelHomePage = new MailTravelHomePage();
        mailTravelHomePage.step1();
        mailTravelHomePage.step2("india");
        mailTravelHomePage.step3();
        mailTravelHomePage.step4();
        mailTravelHomePage.step5();
        mailTravelHomePage.step6();
        mailTravelHomePage.step7();
    }

}
