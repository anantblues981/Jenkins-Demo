package com.epam.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {

    public static File takeWebDriverScreenshot(WebDriver driver, ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String testName = result.getMethod().getMethodName();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotsPath = new File("src/test/resources/screenshots").getAbsolutePath();
        String fileName = screenshotsPath + File.separator + "screenshot_" + testName + "_" + timeStamp + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
        return screenshot;
    }
    public static File takeElementScreenshot(WebElement webElement) {
        File screenshot = webElement.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotsPath = new File("src/test/resources/screenshots").getAbsolutePath();
        String fileName = screenshotsPath + File.separator + "screenshot_" + timeStamp + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
        return screenshot;
    }
}
