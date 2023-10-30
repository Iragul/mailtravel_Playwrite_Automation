package org.Practicum.mainframe;

import org.Practicum.subframe.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public static WebDriver driver = null;

    public static void waitforelement(String locator) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Waiting for the element");
            if (driver.findElement(By.xpath(locator)) != null) {
                break;
            } else {
                Thread.sleep(3000);
            }
        }
    }
    public static void click(String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
            System.out.println("Click operation done.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Click operation failed.");
        }
    }
    public static void insertdata(String Xpath, String updatedtext)
    {
        WebElement textBox =driver.findElement(By.xpath(Xpath));
        textBox.clear();
        textBox.sendKeys(updatedtext);
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
    }
    public static WebDriver opendriver() throws InterruptedException {
        String driverPath=System.getProperty("user.dir")+ Property.getProperty("driverpath");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        return driver;
    }
    public static String Readelement(String name)
    {
        String Status=driver.findElement(By.xpath(Property.getProperty(name))).getText();

        return Status;
    }
    public static String removeCommas(String input) {
        return input.replaceAll(",", "");
    }
}
