package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.pages.registration.CRSSelfCertificationForm;
import pageObjects.pages.registration.CustomerInfoForm;
import pageObjects.pages.registration.IndividualVerificationBase;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;
import utils.FluentWaiting;

public class ChartWidget extends IndividualVerificationBase {

    @FindBy(xpath = "//div[@data-window-name='overview']//div[contains(text(),'Chart')]")
    private WebElement chartWidgetTitle;

    @FindBy(xpath = "//div[@data-window-name='overview']//span[contains(text(),'Change instrument')]")
    private WebElement changeInstrumentButton;

    @FindBy(xpath = "//span[contains(text(),'Trade')]")
    private WebElement tradeButton;

    @FindBy(xpath = "//div[@data-window-name='overview']//span[contains(@class,'instrument-selector-instrument___AI0TA')]")
    private WebElement instruments;

    @FindBy(xpath = "//table[contains(@class,'chart-markup-table')]")
    private WebElement chart;

    @FindBy(xpath = "//div[@data-window-name='overview']//div[contains(@class,'Select-input')]")
    private WebElement timeFrame;

    @FindBy(xpath = "//div[@data-window-name='overview']//span[contains(@class,'Select-value-label')]")
    private WebElement timeFrameSpan;

    @FindBy(xpath = "//div[contains(text(),'Add indicator')]")
    private WebElement addIndicatorDiv;

    @FindBy(xpath = "//span[div[contains(.,'Add indicator')]]//input")
    private WebElement addIndicator;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement orderAmountInput;

    @FindBy(xpath = "//input[@name='price']")
    private WebElement orderPriceInput;

    @FindBy(xpath = "//span[contains(text(),'Place buy  order')]")
    private WebElement buyOrderButton;

    @FindBy(xpath = "//span[contains(text(),'Place sell order')]")
    private WebElement sellOrderButton;

    @FindBy(xpath = "//span[contains(@class,'Select-value-label')]")
    private WebElement verifyTimeFrameSpan;

    @FindBy(xpath = "//div[@data-window-name='overview']//i[@class='icon-icon-cancel']")
    private WebElement closeButton;

    @FindBy(xpath = "//button[contains(@class,'app-components-GUI-___style__button___3bWxw app-components-GUI-___style__primary___3tcGx app-components-GUI-___style__big___1mEKv')]")
    private WebElement changeOnInstrumentButton;

    @Step("To click button on change instrument panel")
    public ChartWidget clickChangeOnInstruments() throws InterruptedException {
        scrollIntoView(changeOnInstrumentButton);
        makeElementVisible(changeOnInstrumentButton);
        Thread.sleep(1000);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, changeInstrumentButton);
        changeOnInstrumentButton.click();
        return this;
    }

    @Step("Verify if chart widget is present")
    public ChartWidget verifyChartsWidgetPresent() {
        Assert.assertEquals(chartWidgetTitle.getText(), "Chart");
        return this;
    }

    @Step("Set time frame")
    public ChartWidget selectTimeFrame(String time) {
        scrollIntoView(timeFrame);
        makeElementVisible(timeFrame);
        sleep(1000); //TODO remove this later
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, timeFrame);
        timeFrame.sendKeys(time + Keys.ENTER);
        return this;
    }



    @Step("Set time frame")
    public ChartWidget addIndicator(String indicator) {
        scrollIntoView(addIndicator);
        makeElementVisible(addIndicator);
        sleep(1000); //TODO remove this later
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, addIndicator);
        addIndicator.sendKeys(indicator + Keys.ENTER);
        return this;
    }

    @Step("Verify if chart widget contains time frame")
    public ChartWidget verifyTimeFrameSpanPresent() {
        Assert.assertEquals(timeFrameSpan.isDisplayed(), true);
        return this;
    }

    @Step("Verify if chart widget contains add indicator")
    public ChartWidget verifyAddIndicatorDivPresent() {
        Assert.assertEquals(addIndicatorDiv.isDisplayed(), true);
        return this;
    }

    @Step("Verify if button change instrument is present")
    public ChartWidget verifyChangeInstrumentPresent() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(changeInstrumentButton, 30, "Change instrument");
        return this;
    }

    @Step("Verify if button trade is present")
    public ChartWidget verifyTradeButtonPresent() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradeButton, 30, "Trade");
        return this;
    }

    @Step("Verify if chart is present")
    public ChartWidget verifyChartPresent() {
        Assert.assertEquals(chart.isDisplayed(), true);
        return this;
    }

    @Step("Click on instrument span")
    public ChartWidget clickInstruments() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, instruments);
        instruments.click();
        return this;
    }

    @Step("To click on Trade button")
    public ChartWidget clickTradeButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, tradeButton);
        tradeButton.click();
        return this;
    }

    @Step("Enter order ticket amount")
    public ChartWidget enterAmount(String amount) {
        orderAmountInput.sendKeys(amount);
        return this;
    }

    @Step("Enter order ticket price")
    public ChartWidget enterPrice(String price) {
        orderPriceInput.sendKeys(price);
        return this;
    }

    @Step("To click on place buy order button")
    public ChartWidget clickBuyOrderButton() throws InterruptedException {
        FluentWaiting.waitUntillElementToBeClickable(60, 500, buyOrderButton);
        buyOrderButton.click();
        return this;
    }

    @Step("To click on place sell order button")
    public ChartWidget clickSellOrderButton() throws InterruptedException {
        FluentWaiting.waitUntillElementToBeClickable(60, 500, sellOrderButton);
        sellOrderButton.click();
        return this;
    }

    @Step("To click on change instruments button")
    public ChartWidget clickChangeInstruments() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, changeInstrumentButton);
        changeInstrumentButton.click();
        return this;
    }


    @Step("Verify if chart is present")
    public ChartWidget verifyTimeFrame(String time) {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(verifyTimeFrameSpan, 30, time);
        return this;
    }

    public String getTimeFrame() {
        return verifyTimeFrameSpan.getText();
    }

    public String getCurrentInstrument() {
        return instruments.getText();
    }

    @Step("Verify if chart title is present")
    public ChartWidget verifyChartTitleIsPresent() {
        Assert.assertEquals(chartWidgetTitle.isDisplayed(), true);
        return this;
    }

    @Step("Click chart close button")
    public ChartWidget clickCloseButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, closeButton);
        scrollIntoView(closeButton);
        makeElementVisible(closeButton);
        closeButton.click();
        return this;
    }

    @Step("Verify if current indicator is present on chart widget")
    public ChartWidget indicatorIsPresent(String instrumentName) {
        WebElement element = getWebDriver().findElement(By.xpath(String.format("//div[contains(text(),'%s')]", instrumentName)));
        Assert.assertEquals(instrumentName, element.getText());
        return this;
    }


}
