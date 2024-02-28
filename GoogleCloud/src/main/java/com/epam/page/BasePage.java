package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/?hl=en";
    public static final String CLOUD_CALCULATOR_URL = "https://cloud.google.com/products/calculator-legacy";
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }
    protected void waitAndSendKeys(WebElement element, String keys) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(keys);
    }

    protected void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void selectDropdownOption(WebElement dropdown, WebElement option) {
        waitAndClick(dropdown);
        waitAndClick(option);
    }
}
