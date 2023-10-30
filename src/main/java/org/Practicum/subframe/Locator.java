package org.Practicum.subframe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.Practicum.mainframe.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Locator {
    public static WebDriver newdriver = null;

@When("Open webpage")
public static void openwebpage() throws InterruptedException {
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
public static void main(String ags[]) throws InterruptedException {
    openwebpage();
}
}
