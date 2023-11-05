package org.Practicum.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ReportManager {
    private static ExtentReports extent;
    private static List<ExtentTest> extentTestList = new ArrayList<>();
    public static String dir = System.getProperty("user.dir");
    public static void startReport() {
            String reportpath=dir + "\\src\\main\\resources\\Extent_Report\\Report.html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportpath);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        extentTestList.add(extentTest);
    }

    public static void logStep(String message) {
        getCurrentTest().info(message);
    }

    public static void logValidation(String message, boolean status) {
        if (status) {
            getCurrentTest().pass(message);
        } else {
            getCurrentTest().fail(message);
        }
    }

    public static void logFailure(String message) {
        getCurrentTest().fail(message);

    }
    public static void logPass(String message) {
        getCurrentTest().pass(message);
    }
    public static void flushReport() {
            extent.flush();

    }


    static ExtentTest getCurrentTest() {
        return extentTestList.get(extentTestList.size() - 1);
    }
/*
    public static void captureScreenshot(String logType, String info) throws IOException {
        File srcFile = ((TakesScreenshot) Logindemo.driver).getScreenshotAs(OutputType.FILE);
        FileInputStream fileInputStreamReader = new FileInputStream(srcFile);
        byte[] bytes = new byte[(int)srcFile.length()];
        fileInputStreamReader.read(bytes);
        String encodedImage = new String(Base64.encodeBase64(bytes), "UTF-8");
        switch(logType) {
            case "PASS":
                if(info==null) {
                    logPass(info+"<img src='data:image/png;base64," + encodedImage + "' height='400'");

                }else {
                    logPass(info+"<br><img src='data:image/png;base64," + encodedImage + "' height='400'");

                }
                break;
            case "FAIL":
                if(info==null) {
                    logFailure(info+"<img src='data:image/png;base64," + encodedImage + "' height='400'");
                }else {
                    logFailure(info+"<br><img src='data:image/png;base64," + encodedImage + "' height='400'");
                }
                break;
            case "INFO":
                if(info==null) {
                    logStep(info+"<img src='data:image/png;base64," + encodedImage + "' height='400'");
                }else {
                    logStep(info+"<br><img src='data:image/png;base64," + encodedImage + "' height='400'");
                }
                break;
        }
    }*/




}
