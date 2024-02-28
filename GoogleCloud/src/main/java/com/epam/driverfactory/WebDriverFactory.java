package com.epam.driverfactory;


import com.epam.exception.NotADefaultBrowserException;
import com.epam.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private WebDriverFactory(){

    }
    public static WebDriver createWebDriver(String browser) {
        BrowserType browserType;
        try {
            browserType = BrowserType.valueOf(browser.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new NotADefaultBrowserException("Not a Default Browser: " + browser);
        }
        return switch (browserType) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
        };
    }
}