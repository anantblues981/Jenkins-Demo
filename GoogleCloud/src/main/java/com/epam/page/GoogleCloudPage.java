package com.epam.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPage extends BasePage{

    @FindBy(className = "YSM5S")
    private WebElement searchButton;
    @FindBy(id = "i5")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='K5hUy' and @track-metadata-eventdetail='cloud.google.com/products/calculator-legacy']")
    private WebElement googleCalculatorLink;


    public GoogleCloudPage(WebDriver webDriver){
        super(webDriver);
    }


    public GoogleCloudPage launchGoogleCloud(){
        webDriver.manage().window().maximize();
        webDriver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public GoogleCloudPage search(){
        searchButton.click();
        searchField.sendKeys("price calculator");
        searchField.sendKeys(Keys.RETURN);
        return this;
    }

    public GooglePriceCalculator navigateToPriceCalculator(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(googleCalculatorLink));
        googleCalculatorLink.click();
        return new GooglePriceCalculator(webDriver);
    }



}
