package org.Practicum.subframe;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Practicum.mainframe.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Locator {
    public static WebDriver newdriver = null;

@When("Open webpage")
public static void openwebpage() throws Exception {
    newdriver=Base.opendriver();
    newdriver.get(Property.getProperty("url"));
}
@And("Accept All Cookies")
public void acceptcookies() throws InterruptedException {
    Thread.sleep(3000);
   Base.waitforelement(Property.getProperty("Acceptcookies"));
   Base.click(Property.getProperty("Acceptcookies"));
}
@And("Enter the search text {string}")
public void searchtext(String search) throws InterruptedException {
    Thread.sleep(2000);
    Base.waitforelement(Property.getProperty("SearchTextBox"));
    Base.insertdata(Property.getProperty("SearchTextBox"),search);

}

@And("Click Search Button")
public void clicksearch() throws InterruptedException {
    Thread.sleep(2000);
    Base.waitforelement(Property.getProperty("Searchoption"));
    Base.click(Property.getProperty("Searchoption"));
}

@And("Verify page Title {string}")
public  void  titleverification(String title)
{
    String pageTitle = newdriver.getTitle();
    assertEquals("Page title doesn't match", title, pageTitle);
}
@And("scroll to calender")
public void Scrolltocalender()
{
    WebElement element = newdriver.findElement(By.xpath(Property.getProperty("Calender")));
    Base.scrollToElement(newdriver,element);
}
@And("Select First Avaliable Date")
public void selectdate() throws InterruptedException {
    Thread.sleep(2000);
    Base.waitforelement(Property.getProperty("Firstdate"));
    Base.click(Property.getProperty("Firstdate"));
}
@And("Select the Adult Count {string}")
public void  selectadult(String Adult) throws InterruptedException {
    Thread.sleep(2000);
    Base.waitforelement(Property.getProperty("Adultcount"));
    WebElement dropdown = newdriver.findElement(By.xpath(Property.getProperty("Adultcount")));
    Select select = new Select(dropdown);
    select.selectByVisibleText(Adult);

}
@And("Select Accommodation")
public void selectroom() throws InterruptedException {
    Thread.sleep(5000);
    Base.waitforelement(Property.getProperty("roomchoose"));
    WebElement dropdown= newdriver.findElement(By.xpath(Property.getProperty("roomchoose")));
    Select select=new Select(dropdown);
    select.selectByVisibleText("1");
    Thread.sleep(2000);
    Base.waitforelement(Property.getProperty("selectroom"));
    Base.click(Property.getProperty("selectroom"));
    Thread.sleep(5000);
    Base.waitforelement(Property.getProperty("withoutextra"));
    Base.click(Property.getProperty("withoutextra"));

}
@And("Validate price")
public void pricevalidate()
{
    String oneadultprice=Base.Readelement("Firstprice");
    String oneadultpricewithoutsymbol = oneadultprice.substring(1);
    String oneadultWithoutComma = Base.removeCommas(oneadultpricewithoutsymbol);
    int number = Integer.parseInt(oneadultWithoutComma);

    String totalprice=Base.Readelement("Totalprice");
    String totalpricewithoutsymbol= totalprice.substring(1);
    String totalpriceWithoutComma = Base.removeCommas(totalpricewithoutsymbol);
    int actual=Integer.parseInt(totalpriceWithoutComma);
    assertEquals(number*2,actual);
}
@And("Click Book online button")
public void bookonline() throws InterruptedException {
    Thread.sleep(3000);
    Base.waitforelement(Property.getProperty("BookOnline"));
    Base.click(Property.getProperty("BookOnline"));
}
@And("Fill passanger Details and click Continue Button")
public void passengerdetails() throws InterruptedException {
    Thread.sleep(5000);

    Base.waitforelement(Property.getProperty("title1"));
    WebElement dropdown= newdriver.findElement(By.xpath(Property.getProperty("title1")));
    Select select=new Select(dropdown);
    select.selectByVisibleText("Mr");


    Base.waitforelement(Property.getProperty("fistname1"));
    Base.insertdata(Property.getProperty("fistname1"),"firstname");

    Base.waitforelement(Property.getProperty("Lastname1"));
    Base.insertdata(Property.getProperty("Lastname1"),"lastname");

    Thread.sleep(2000);

    Base.waitforelement(Property.getProperty("dobd1"));
    WebElement date= newdriver.findElement(By.xpath(Property.getProperty("dobd1")));
    Select dateselect=new Select(date);
    dateselect.selectByValue("10");

    Base.waitforelement(Property.getProperty("dobm1"));
    WebElement month= newdriver.findElement(By.xpath(Property.getProperty("dobm1")));
    Select monthselect=new Select(month);
    monthselect.selectByValue("10");

    WebElement year= newdriver.findElement(By.xpath(Property.getProperty("doby1")));
    Select yearselect=new Select(year);
    yearselect.selectByVisibleText("1989");

    Base.waitforelement(Property.getProperty("title2"));
    WebElement dropdown2= newdriver.findElement(By.xpath(Property.getProperty("title2")));
    Select select2=new Select(dropdown2);
    select2.selectByVisibleText("Mrs");


    Base.waitforelement(Property.getProperty("fistname2"));
    Base.insertdata(Property.getProperty("fistname2"),"firsts");

    Base.waitforelement(Property.getProperty("Lastname2"));
    Base.insertdata(Property.getProperty("Lastname2"),"lasts");

    Thread.sleep(2000);

    Base.waitforelement(Property.getProperty("dobd2"));
    WebElement date2= newdriver.findElement(By.xpath(Property.getProperty("dobd2")));
    Select dateselect2=new Select(date2);
    dateselect2.selectByValue("12");

    Base.waitforelement(Property.getProperty("dobm2"));
    WebElement month2= newdriver.findElement(By.xpath(Property.getProperty("dobm2")));
    Select monthselect2=new Select(month2);
    monthselect2.selectByValue("12");

    WebElement year2= newdriver.findElement(By.xpath(Property.getProperty("doby2")));
    Select yearselect2=new Select(year2);
    yearselect2.selectByVisibleText("1989");

    Base.waitforelement(Property.getProperty("mobilenumber"));
        Base.insertdata(Property.getProperty("mobilenumber"),"07474747474");

    Base.waitforelement(Property.getProperty("email"));
    Base.insertdata(Property.getProperty("email"),"testing@gmail.com");

    Base.waitforelement(Property.getProperty("Addressline1"));
    Base.insertdata(Property.getProperty("Addressline1"),"addr1");

    Base.waitforelement(Property.getProperty("Addressline2"));
    Base.insertdata(Property.getProperty("Addressline2"),"add2");

    Base.waitforelement(Property.getProperty("city"));
    Base.insertdata(Property.getProperty("city"),"city");

    Base.waitforelement(Property.getProperty("postcode"));
    Base.insertdata(Property.getProperty("postcode"),"postcode");

    WebElement pleaseselect= newdriver.findElement(By.xpath(Property.getProperty("pleaseselect")));
    Select select3=new Select(pleaseselect);
    select3.selectByVisibleText("Email");

    Base.waitforelement(Property.getProperty("continuebutton"));
    Base.click(Property.getProperty("continuebutton"));
}
@Then("Verify the Confirm Details + Book page and verify the Book Now button is enabled")
public  void confirmpagevalidation() throws InterruptedException {
    Thread.sleep(6000);
    Base.waitforelement(Property.getProperty("confirmpage"));
    String actualtext=Base.Readelement("confirmpage");
    assertEquals("Confirm Details + Book",actualtext);
     bookbuttonstatus();
}
public void bookbuttonstatus() throws  InterruptedException {
    Thread.sleep(2000);

    Base.waitforelement(Property.getProperty("bookbutton"));
    WebElement element = newdriver.findElement(By.xpath(Property.getProperty("bookbutton")));
    Base.scrollToElement(newdriver,element);
    By buttonLocator = By.xpath(Property.getProperty("bookbutton"));
    WebElement button = newdriver.findElement(buttonLocator);
    if (!button.isEnabled()) {
        throw new PendingException("Button is not enabled");
    }



}

}
