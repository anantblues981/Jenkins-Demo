package com.epam.test;

import com.epam.driverfactory.ThreadWebDriver;
import com.epam.page.GooglePriceCalculator;
import com.epam.utility.TakeScreenshot;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class GooglePriceCalculatorTest {
    WebDriver webDriver;
    GooglePriceCalculator calculatorPage;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        webDriver = ThreadWebDriver.getInstance(browser);
        calculatorPage = new GooglePriceCalculator(webDriver);
    }

    @Test(description = "Verify that the number of instances field is correctly set to 4")
    public void verifyInstanceField() {
        Assert.assertEquals(calculatorPage.launchPriceCalculator().switchToFormFrame().setNumberOfInstances(4), "4");
    }

    @Test(description = "Verify the selection of the operating system", dependsOnMethods = {"verifyInstanceField"})
    public void verifyOperatingSystemsSelection() {
        Assert.assertEquals(calculatorPage.selectOperatingSystem(), "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
    }

    @Test(description = "Verify the selection of the series type", dependsOnMethods = {"verifyOperatingSystemsSelection"})
    public void verifySeriesSelection() {
        Assert.assertEquals(calculatorPage.selectSeriesType(), "N1");
    }

    @Test(description = "Verify the selection of the machine type", dependsOnMethods = {"verifySeriesSelection"})
    public void verifyMachineSelection() {
        Assert.assertEquals(calculatorPage.selectMachineType(), "n1-standard-8 (vCPUs: 8, RAM: 30GB)");
    }

    @Test(description = "Verify the Add GPU checkbox", dependsOnMethods = {"verifyMachineSelection"})
    public void verifyAddGpuCheckbox() {
        Assert.assertTrue(calculatorPage.addGpu());
    }

    @Test(description = "Verify the selection of the GPU type", dependsOnMethods = {"verifyAddGpuCheckbox"})
    public void verifyGpuTypeSelection() {
        Assert.assertEquals(calculatorPage.selectGpuType(), "NVIDIA Tesla T4");
    }

    @Test(description = "Verify the selection of the number of GPUs", dependsOnMethods = {"verifyGpuTypeSelection"})
    public void verifyGpuNumberSelection() {
        Assert.assertEquals(calculatorPage.setNumberOfGpus(), "1");
    }

    @Test(description = "Verify the selection of the local SSD type", dependsOnMethods = {"verifyGpuNumberSelection"})
    public void verifyLocalSsdSelection() {
        Assert.assertEquals(calculatorPage.selectLocalSsdType(), "2x375 GB");
    }

    @Test(description = "Verify the selection of the data center location", dependsOnMethods = {"verifyLocalSsdSelection"})
    public void verifyDataLocationSelection() {
        Assert.assertEquals(calculatorPage.selectDataCenterLocation(), "Frankfurt (europe-west3)");
    }

    @Test(description = "Verify the selection of the commitment usage period", dependsOnMethods = {"verifyDataLocationSelection"})
    public void verifyCommitmentUsageSelection() {
        Assert.assertEquals(calculatorPage.selectCommitmentUsagePeriod(), "1 Year");
    }



    @AfterMethod
    public void afterMethod(ITestResult result)throws IOException{
        if(result.getStatus() == ITestResult.FAILURE){
            File screenshot = TakeScreenshot.takeWebDriverScreenshot(webDriver,result);
            Allure.addAttachment("Page ScreenShot", FileUtils.openInputStream(screenshot));
        }
    }

    @AfterClass
    public void tearDown() {
        ThreadWebDriver.closeInstance();
        calculatorPage = null;
    }
}
