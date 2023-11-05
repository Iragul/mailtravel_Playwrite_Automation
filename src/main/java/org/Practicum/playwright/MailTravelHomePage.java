package org.Practicum.playwright;

import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.hu.De;
import org.Practicum.Report.ReportManager;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class MailTravelHomePage {

    private final Page page;

    public MailTravelHomePage(Page page) {
        this.page = page;
    }
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void navigateTo(String url) {
        page.navigate(url);
        page.waitForLoadState();

    }


    public void acceptAllCookies() {
        page.click("id=onetrust-accept-btn-handler");
        sleep(3000);
    }
     @Given("Step 1")
    public void step1()
    {
        try {
            String url="https://www.mailtravel.co.uk/";
            navigateTo(url);
            ReportManager.logStep("Navigated to "+url);
            String title= getPageTitle();
            if (title.equals("Home Page | Mail Travel"))
            {
               ReportManager.logPass("Page title is correct");
            }else
            {
               ReportManager.logFailure("Failed on page title Validation");
            }
           // assertEquals("Home Page | Mail Travel",title);
            acceptAllCookies();
            ReportManager.logStep("Accepted all Cookies");
        }catch (Exception e)
        {
            ReportManager.logFailure("Failed on Step 1");
        }

    }
    @And("Step 2")
    public void step2(String searchText) {
        try {
            page.type("input[name='searchtext']", searchText);
            ReportManager.logStep("Entered "+searchText+" in search box");
            selectfirst();
            ReportManager.logStep("Selected "+searchText+" in dropdown");
        }catch (Exception e)
        {
            ReportManager.logFailure("Failed on Step 2");
        }

    }
    public  void selectfirst()
    {
        try {
            String firstLiSelector = String.format("#%s li:first-child", "as_ul");
            Locator firstListItemLocator = page.locator(firstLiSelector);
            for(int i=0;i<5;i++) {
                if (firstListItemLocator.count() > 0) {
                    firstListItemLocator.first().click();
                    break;
                } else {
                    sleep(3000);
                }
            }
        }catch (Exception e)
        {
             ReportManager.logFailure("Failed to select in Dropdown");
        }


    }
    @And("Step 3")
    public void step3(){
        try {
            String buttonSelector = "button[name='enterbookingflow']";
            Locator buttonLocator = page.locator(buttonSelector);
            buttonLocator.evaluate("element => element.scrollIntoView()");
            buttonLocator.click();
            ReportManager.logStep("Clicked the BookOnline Button");
        }catch (Exception e)
        {
            ReportManager.logFailure("Failed to click Bookonline Button");
        }


    }
    @And("Step 4")
    public void step4() {
        try {
            scrollIntoView("section[id=\"dates-and-prices\"]");
            page.click("input[name='seldate']");
            ReportManager.logStep("Selected the First Avaliable Date");
            page.selectOption("select[name=numAdults]", "2");
            ReportManager.logStep("Selected the 2 Adults");
            String calendarPrice = getTextContent(".nbf_tpl_pms_calendar_price");
            int expectedPrice = parseAndCleanPrice(calendarPrice) * 2;

            String totalPrice = getTextContent(".tour-price");
            int totalPriceAsInt = parseAndCleanPrice(totalPrice);
            if(totalPriceAsInt==expectedPrice)
            {
                ReportManager.logPass("Validation for 2 adult price is sucessfull");
            }else {
                ReportManager.logFailure("Failed");
            }
            //assertEquals(expectedPrice, totalPriceAsInt);
            page.click("div[id='book-button']");
            ReportManager.logStep("Clicked the Book Online Buuton");
        }catch (Exception e)
        {
            ReportManager.logFailure("Failed on Step 4");
        }
    }
    @And("Step 5")
    public void step5(){
        try {
            page.click("div[id='paxDepDateForm-container']");
            String Departure_Airport = getTextContent(".nbf_tpl_pms_bf_departure_value");
            assertEquals("London Heathrow (LHR) ", Departure_Airport);
            ReportManager.logPass("Details populated are valid");

            page.selectOption("select[data-roomtype='Twin']", "1");
            ReportManager.logStep("Selected the Accommodation");
            page.click(".nbf_tpl_pms_book_button");
            page.click("#extrasButton");
            ReportManager.logStep("Clicked on SELECT YOUR ROOMS AND CONTINUE");
        }catch (Exception e)
        {
            ReportManager.logFailure("Failed on Step 5");
        }


    }
    @And("Step 6")
    public void step6(){
        try {
            fillAdultDetails(1, "Mr", "firstname", "lastname", "10", "10", "1989");
            ReportManager.logStep("Updated Adult 1 Details");
            fillAdultDetails(2, "Mrs", "firsts", "lasts", "12", "12", "1989");
            ReportManager.logStep("Updated Adult 2 Details");
            fillconatctdetails("07474747474", "testing@gmail.com", "addr1", "addr2", "city", "postcode");
            ReportManager.logStep("Updated the contact Details");
            page.click("button:has-text('Continue')");
            ReportManager.logStep("Clicked on CONTINUE");
        }catch (Exception e)
        {
            ReportManager.logFailure("Faile on step 6");
        }

    }
    @And("Step 7")
    public void step7(){
        try {
            String headerText = page.textContent(".nbf_fancyimg_payment_pageheader");
            if (headerText.equals("Confirm Details + Book"))
            {
                ReportManager.logPass("Confirm Details + Book Avaliable");
            }else{
                ReportManager.logFailure("Confirm Details + Book Not Avaliable");
            }
           // assertEquals("Confirm Details + Book", headerText);
            boolean isButtonEnabled = page.isEnabled("#nbf_booknow_button");
            if(isButtonEnabled)
            {
                ReportManager.logPass("Book Now button is enabled");
            }
            else
            {
                ReportManager.logFailure("Book Now button is not enabled");
            }
        }catch (Exception e)
        {
            ReportManager.logFailure("Failed on Step 7");
        }
    }
    public void fillAdultDetails(int passengerNumber, String title, String firstName, String lastName, String day, String month, String year) {
        sleep(3000);
        String titleSelector = String.format("#pax-a-title-%d", passengerNumber);
        String firstNameSelector = String.format("#pax-a-first-%d", passengerNumber);
        String lastNameSelector = String.format("#pax-a-last-%d", passengerNumber);
        String daySelector = String.format("#pax-a-dobd-%d", passengerNumber);
        String monthSelector = String.format("#pax-a-dobm-%d", passengerNumber);
        String yearSelector = String.format("#pax-a-doby-%d", passengerNumber);

        page.selectOption(titleSelector, title);
        page.fill(firstNameSelector, firstName);
        page.fill(lastNameSelector, lastName);
        page.selectOption(daySelector, day);
        page.selectOption(monthSelector, month);
        page.selectOption(yearSelector, year);

    }
    public void fillconatctdetails(String mobilenumber,String email,String Address1,String Address2,String city,String passcode)
    {
        page.fill("input[name='contact-mobile']",mobilenumber);
        page.fill("input[name='contact-email']",email);
        page.fill("input[name='contact-address1']",Address1);
        page.fill("input[name='contact-address2']",Address2);
        page.fill("input[name='contact-city']",city);
        page.fill("input[name='contact-postcode']",passcode);
        page.selectOption("select[name='wheredidyouhear']","2");
    }

    private void scrollIntoView(String selector) {
        page.evaluate("document.querySelector('" + selector + "').scrollIntoView()");
    }

    private String getTextContent(String selector) {
        return page.textContent(selector);
    }

    private int parseAndCleanPrice(String priceString) {
        String cleanedPrice = priceString.replaceAll("[^\\d]", "");
        return Integer.parseInt(cleanedPrice);
    }




    public String getPageTitle() {
        return page.title();
    }
}
