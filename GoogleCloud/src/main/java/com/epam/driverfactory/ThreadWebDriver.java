package com.epam.driverfactory;

import org.openqa.selenium.WebDriver;

public class ThreadWebDriver {
    private ThreadWebDriver(){

    }
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getInstance(String browser) {
        WebDriver driver = webDriverThreadLocal.get();
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver(browser);
            webDriverThreadLocal.set(driver);
        }
        return driver;
    }

    public static void closeInstance() {
        WebDriver driver = webDriverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            webDriverThreadLocal.remove();
        }
    }
}
