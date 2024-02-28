package com.epam.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePriceCalculator extends BasePage {

    @FindBy(id = "input_100")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    private WebElement mainFrame;

    @FindBy(id = "myFrame")
    private WebElement formFrame;

    @FindBy(id = "select_113")
    private WebElement osDropdown;

    @FindBy(id = "select_option_102")
    private WebElement freeOsOption;

    @FindBy(id = "select_125")
    private WebElement seriesDropdown;

    @FindBy(id = "select_option_224")
    private WebElement n1SeriesOption;

    @FindBy(id = "select_127")
    private WebElement machineType;

    @FindBy(id = "select_option_474")
    private WebElement n1MachineType;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[13]/div[1]/md-input-container/md-checkbox")
    private WebElement addGpu;

    @FindBy(id = "select_510")
    private WebElement gpuTypeDropdown;

    @FindBy(id = "select_option_518")
    private WebElement nvediaT4Gpu;

    @FindBy(id = "select_512")
    private WebElement numGpuDropdown;

    @FindBy(id = "select_option_520")
    private WebElement oneGpu;

    @FindBy(id = "select_469")
    private WebElement localSsdDropdown;

    @FindBy(id = "select_option_495")
    private WebElement localSsdOptions;

    @FindBy(id = "select_133")
    private WebElement datacenterLocationDropDown;

    @FindBy(id = "select_option_268")
    private WebElement dataCenter;

    @FindBy(id = "select_140")
    private WebElement commitmentUsageDropdown;

    @FindBy(id = "select_option_138")
    private WebElement oneYearCommitment;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button")
    private WebElement addToEstimate;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/div[1]/h2/b")
    private WebElement result;

    public GooglePriceCalculator(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public GooglePriceCalculator launchPriceCalculator() {
        webDriver.manage().window().maximize();
        webDriver.get(CLOUD_CALCULATOR_URL);
        return this;
    }
    public GooglePriceCalculator switchToFormFrame() {
        switchToFrame(mainFrame);
        switchToFrame(formFrame);
        return this;
    }

    public String setNumberOfInstances(int instances) {
        waitAndSendKeys(numberOfInstancesInput, String.valueOf(instances));
        return numberOfInstancesInput.getAttribute("value");
    }

    public String selectOperatingSystem() {
        selectDropdownOption(osDropdown, freeOsOption);
        return osDropdown.getText();
    }
    public String selectSeriesType() {
        selectDropdownOption(seriesDropdown, n1SeriesOption);
        return seriesDropdown.getText();
    }

    public String selectMachineType() {
        selectDropdownOption(machineType, n1MachineType);
        return machineType.getText();
    }
    public Boolean addGpu() {
        waitAndClick(addGpu);
        return Boolean.valueOf(addGpu.getAttribute("aria-checked"));
    }

    public String selectGpuType() {
        selectDropdownOption(gpuTypeDropdown, nvediaT4Gpu);
        return gpuTypeDropdown.getText();
    }

    public String setNumberOfGpus() {
        selectDropdownOption(numGpuDropdown, oneGpu);
        return numGpuDropdown.getText();
    }

    public String selectLocalSsdType() {
        selectDropdownOption(localSsdDropdown, localSsdOptions);
        return localSsdDropdown.getText();
    }

    public String selectDataCenterLocation() {
        selectDropdownOption(datacenterLocationDropDown, dataCenter);
        return datacenterLocationDropDown.getText();
    }

    public String selectCommitmentUsagePeriod() {
        selectDropdownOption(commitmentUsageDropdown, oneYearCommitment);
        return commitmentUsageDropdown.getText();
    }

    public WebElement getNumberOfInstancesInput() {
        return numberOfInstancesInput;
    }

    public WebElement getMainFrame() {
        return mainFrame;
    }

    public WebElement getFormFrame() {
        return formFrame;
    }

    public WebElement getOsDropdown() {
        return osDropdown;
    }

    public WebElement getFreeOsOption() {
        return freeOsOption;
    }

    public WebElement getSeriesDropdown() {
        return seriesDropdown;
    }

    public WebElement getN1SeriesOption() {
        return n1SeriesOption;
    }

    public WebElement getMachineType() {
        return machineType;
    }

    public WebElement getN1MachineType() {
        return n1MachineType;
    }

    public WebElement getAddGpu() {
        return addGpu;
    }

    public WebElement getGpuTypeDropdown() {
        return gpuTypeDropdown;
    }

    public WebElement getNvediaT4Gpu() {
        return nvediaT4Gpu;
    }

    public WebElement getNumGpuDropdown() {
        return numGpuDropdown;
    }

    public WebElement getOneGpu() {
        return oneGpu;
    }

    public WebElement getLocalSsdDropdown() {
        return localSsdDropdown;
    }

    public WebElement getLocalSsdOptions() {
        return localSsdOptions;
    }

    public WebElement getDatacenterLocationDropDown() {
        return datacenterLocationDropDown;
    }

    public WebElement getDataCenter() {
        return dataCenter;
    }

    public WebElement getCommitmentUsageDropdown() {
        return commitmentUsageDropdown;
    }

    public WebElement getOneYearCommitment() {
        return oneYearCommitment;
    }

    public WebElement getAddToEstimate() {
        return addToEstimate;
    }

    public WebElement getResult() {
        return result;
    }

    public GooglePriceCalculator addToEstimateButton() {
        waitAndClick(addToEstimate);
        return this;
    }
    public String finalEstimate(){
        return result.getText();
    }
    private void switchToFrame(WebElement frame) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}