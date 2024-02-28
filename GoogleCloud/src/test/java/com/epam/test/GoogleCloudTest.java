package com.epam.test;


import com.epam.driverfactory.ThreadWebDriver;
import com.epam.page.GoogleCloudPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

public class GoogleCloudTest{
    WebDriver webDriver;
    GoogleCloudPage googleCloudPage;
    @BeforeClass
    public void setUp(@Optional("chrome")String browser){
        webDriver = ThreadWebDriver.getInstance(browser);
        googleCloudPage = new GoogleCloudPage(webDriver);
    }

    @AfterClass
    public void tearDown(){
        ThreadWebDriver.closeInstance();
        googleCloudPage = null;
    }
}

