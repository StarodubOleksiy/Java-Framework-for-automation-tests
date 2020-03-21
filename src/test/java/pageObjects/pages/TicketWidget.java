package pageObjects.pages;

import data.NotificationTitle;
import data.TicketDuration;
import data.TicketType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.FluentWaiting;

import java.util.regex.Pattern;

public class TicketWidget extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@data-window-name='ticket']//div[contains(text(),'Ticket')]")
    private WebElement ticketWidgetTitle;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Market is closed')]")
    private WebElement marketClosedSpan;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Market')]")
    private WebElement market;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Limit')]")
    private WebElement limit;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Amount')]")
    private WebElement amountSpan;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Duration')]")
    private WebElement durationSpan;

    @FindBy(xpath = "//div[@data-window-name='ticket']//div[contains(@class,'react-select__control')]")
    private WebElement duration;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Price')]")
    private WebElement priceSpan;

    @FindBy(xpath = "//div[@data-window-name='ticket']//input[@name='orderPx']")
    private WebElement price;

    @FindBy(xpath = "//div[@data-window-name='ticket']//input[@name='orderQty']")
    private WebElement amountOnMarketSession;

    @FindBy(xpath = "//div[@data-window-name='ticket']//input[@name='amount']")
    private WebElement amountOnOrderSession;

    @FindBy(xpath = "//div[@data-window-name='ticket']//input[@name='stopPx']")
    private WebElement stopPrice;

    @FindBy(xpath = "//div[@data-window-name='ticket']//input[@name='expectedPrice']")
    private WebElement expectedPrice;

    @FindBy(xpath = "//div[@data-window-name='ticket']//th[contains(text(),'Trading details')]")
    private WebElement tradingDetailsTable;

    @FindBy(xpath = "//div[@data-window-name='ticket']//th[contains(text(),'Buy')]")
    private WebElement buyColumn;

    @FindBy(xpath = "//div[@data-window-name='ticket']//th[contains(text(),'Sell')]")
    private WebElement sellColumn;

    @FindBy(xpath = "//div[@data-window-name='ticket']//th[contains(text(),'Nominal value')]")
    private WebElement nominalValueRow;

    @FindBy(xpath = "//div[@data-window-name='ticket']//th[contains(text(),'Margin impact')]")
    private WebElement marginImpactRow;

    @FindBy(xpath = "//div[@data-window-name='ticket']//th[contains(text(),'Margin after trade')]")
    private WebElement marginAfterTrade;

    @FindBy(xpath = "//div[@data-window-name='ticket']//button[contains(@class,'Ticket-___style__sell')]")
    private WebElement sellButton;

    @FindBy(xpath = "//div[@data-window-name='ticket']//button[contains(@class,'Ticket-___style__buy')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Sell')]")
    private WebElement sellOrderButton;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Buy')]")
    private WebElement buyOrderButton;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(text(),'Change instrument')]")
    private WebElement changeInstrumentSpan;

    @FindBy(xpath = "//div[@data-window-name='ticket']//i[@class='icon-icon-search']")
    private WebElement changeInstrumentButton;

    @FindBy(xpath = "//div[@data-window-name='ticket']//span[contains(@class,'selector-instrument___AI0TA')]")
    private WebElement instrument;

    @FindBy(xpath = "//div[@data-window-name='ticket']//i[@class='icon-icon-cancel']")
    private WebElement closeButton;

    @FindBy(xpath = "//span[text()='Manual']")
    private WebElement manualButton;

    @FindBy(xpath = "//span[text()='Automatic']")
    private WebElement automaticButton;

    @FindBy(xpath = "//span[text()='Any']")
    private WebElement anyButton;

    @Step("Verify if ticket widget is present")
    public TicketWidget verifyTicketWidgetWithDataPresent() {
        Assert.assertEquals(ticketWidgetTitle.getText(), "Ticket");
        scrollIntoView(market);
        Assert.assertEquals(changeInstrumentSpan.getText(), "Change instrument");
        Assert.assertEquals(market.getText(), "Market");
        Assert.assertEquals(limit.getText(), "Limit");
        Assert.assertEquals(amountSpan.getText(), "Amount");
        Assert.assertEquals(durationSpan.getText(), "Duration");
        scrollIntoView(tradingDetailsTable);
        Assert.assertEquals(tradingDetailsTable.getText(), "Trading details");
        String actualMessage = String.valueOf(buyColumn.getText().toCharArray(), 0, "Buy".length());
        Assert.assertEquals(actualMessage, "Buy");
        actualMessage = String.valueOf(sellColumn.getText().toCharArray(), 0, "Sell".length());
        Assert.assertEquals(actualMessage, "Sell");
        scrollIntoView(manualButton);
        Assert.assertEquals(manualButton.getText(), "Manual");
        scrollIntoView(automaticButton);
        Assert.assertEquals(automaticButton.getText(), "Automatic");
        scrollIntoView(anyButton);
        Assert.assertEquals(anyButton.getText(), "Any");
        scrollIntoView(nominalValueRow);
        Assert.assertEquals(nominalValueRow.getText(), "Nominal value");
        Assert.assertEquals(marginImpactRow.getText(), "Margin impact");
        scrollIntoView(marginAfterTrade);
        Assert.assertEquals(marginAfterTrade.getText(), "Margin after trade");
        return this;
    }

    @Step("Verify if ticket widget is present")
    public TicketWidget verifyTicketWidgetPresent() {
        Assert.assertEquals(ticketWidgetTitle.getText(), "Ticket");
        return this;
    }

    @Step("Verify if market is open")
    public TicketWidget verifyMarketIsOpen() {
        Assert.assertFalse(isElementPresent("//span[contains(text(),'Market is closed')]"));
        return this;
    }

    @Step("Specify all tickets type answers in (Market, Limit)  {0}")
    public TicketWidget specifyTicket(String ticketType) throws Exception {
        switch (ticketType) {
            case "Market":
                clickDynamicElement(By.xpath("//label[span[.='Market']]"));
                sleep(500);
                break;
            case "Limit":
                clickDynamicElement(By.xpath("//label[span[.='Limit']]"));
                sleep(500);
                break;
            case "Stop":
                clickDynamicElement(By.xpath("//label[span[.='Stop']]"));
                sleep(500);
                break;
            case "Stop-Limit":
                clickDynamicElement(By.xpath("//label[span[.='Stop-Limit']]"));
                sleep(500);
                break;
            default:
                break;
        }
        return this;
    }

    @Step("To click on Sell button on Market tab")
    public TicketWidget clickMarketButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, market);
        market.click();
        return this;
    }

    @Step("To click on Sell button on Market tab")
    public TicketWidget clickLimitButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, limit);
        limit.click();
        return this;
    }

    @Step("Verify if all buttons are present on tab  Market")
    public TicketWidget verifyIfComponentsButtonsPresentTabMarket() throws Exception {
        specifyTicket("Market");
        Assert.assertEquals(sellButton.getText(), "Sell");
        Assert.assertEquals(buyButton.getText(), "Buy");
        return this;
    }

    @Step("Verify if all buttons are present on tab  Limit")
    public TicketWidget verifyIfComponentsButtonsPresentTabLimit() throws Exception {
        specifyTicket("Limit");
        Assert.assertEquals(priceSpan.getText(), "Price");
        Assert.assertEquals(sellButton.getText(), "Sell order");
        Assert.assertEquals(buyButton.getText(), "Buy order");
        return this;
    }

    @Step("Click on duration list")
    public TicketWidget clickOnDuration() {
        duration.click();
        return this;
    }


    @Step("Set duration {0}")
    public TicketWidget selectDuration(String durationName) {
        WebElement input = getWebDriver().findElement(By.xpath("//div[@data-window-name='ticket']//div[contains(@class,'react-select__control')]//input"));
        input.sendKeys(durationName);
        WebElement element = getWebDriver().findElement(By.xpath(String.format("//div[@data-window-name='ticket']//div[contains(@class,'react-select__menu')]")));// //span[contains(text(),'%s')]",durationName)));
        sleep(2000);
        element.click();
        return this;
    }

    @Step("Fill in amount market session {0}")
    public TicketWidget enterAmountOnMarketSession(String amountName) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, amountOnMarketSession);
        makeElementVisible(amountOnMarketSession);
        amountOnMarketSession.sendKeys(amountName);
        return this;
    }

    @Step("Fill in amount on order session {0}")
    public TicketWidget enterAmountOnOrderSession(String amountName) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, amountOnOrderSession);
        makeElementVisible(amountOnOrderSession);
        amountOnOrderSession.sendKeys(amountName);
        return this;
    }

    @Step("Fill in stop price {0}")
    public TicketWidget enterStopPrice(String amountName) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, stopPrice);
        makeElementVisible(stopPrice);
        stopPrice.sendKeys(amountName);
        return this;
    }

    @Step("Fill in price {0}")
    public TicketWidget enterPrice(String priceName) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, price);
        price.sendKeys(priceName);
        return this;
    }

    @Step("Fill in expected price {0}")
    public TicketWidget enterExpectedPrice(String priceName) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, expectedPrice);
        expectedPrice.sendKeys(priceName);
        return this;
    }

    @Step("To click on Sell button on Market tab")
    public TicketWidget clickSellButton() {
        sellButton.click();
        return this;
    }

    @Step("To click on Buy button on Market tab")
    public TicketWidget clickBuyButton() {
        scrollIntoView(buyButton);
        makeElementVisible(buyButton);
        buyButton.click();
        return this;
    }

    @Step("To click on Sell button on Limit tab")
    public TicketWidget clickSellOrderButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, sellButton);
        sellOrderButton.click();
        return this;
    }

    @Step("To click on Buy button on Limit tab")
    public TicketWidget clickBuyOrderButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, buyButton);
        buyOrderButton.click();
        return this;
    }

    @Step("Verify if buttons sell and buy are disabled")
    public TicketWidget verifyIfButtonsAreDisabled() {
        Assert.assertFalse(sellButton.isEnabled());
        Assert.assertFalse(buyButton.isEnabled());
        return this;
    }

    @Step("Verify if message is appeared in top right corner when you sell or buy a ticket {0}")
    public TicketWidget verifyTicketMessageAppeared(NotificationTitle notificationTitle, String expectedAmountInstrumentMessage) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);
       // wait.until(ExpectedConditions.textToBePresentInElement(getWebDriver().findElement(By.cssSelector(".notification-title")), notificationTitle.getName()));
        WebElement amountInstrumentMessage = getWebDriver().findElement(By.xpath("//div[contains(@class,'notification-visible')]/div"));
        Assert.assertTrue(amountInstrumentMessage.getText().contains(expectedAmountInstrumentMessage));

        return this;
    }


    @Step("Clear field amount which is on Forex instrument")
    public TicketWidget clearAmountOnMarketSession() {
        sleep(2000);
        scrollIntoView(amountOnMarketSession);
        this.clearInput(amountOnMarketSession);
        return this;
    }

    @Step("Clear field amount on order session")
    public TicketWidget clearAmountOnOrderSessionField() {
        sleep(2000);
        scrollIntoView(amountOnOrderSession);
        this.clearInput(amountOnOrderSession);
        return this;
    }

    @Step("Clear field price")
    public TicketWidget clearPriceField() {
        this.clearInput(price);
        return this;
    }

    @Step("Clear field stop price")
    public TicketWidget clearStopPriceField() {
        this.clearInput(stopPrice);
        return this;
    }

    @Step("Clear field expected price")
    public TicketWidget clearExpectedPriceField() {
        this.clearInput(expectedPrice);
        return this;
    }

    @Step("Click on change instrument tool")
    public TicketWidget clickChangeInstruments() {
        scrollIntoView(changeInstrumentButton);
        FluentWaiting.waitUntillElementToBeVisible(60, 500, changeInstrumentButton);
        changeInstrumentButton.click();
        return this;
    }

    @Step("Click on instrument span")
    public TicketWidget clickInstruments() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, instrument);
        instrument.click();
        return this;
    }

    public String getCurrentInstrument() {
        return instrument.getText();
    }

    @Step("Click ticket close button")
    public TicketWidget clickCloseButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, closeButton);
        scrollIntoView(closeButton);
        makeElementVisible(closeButton);
        sleep(5000);
        closeButton.click();
        return this;
    }

    @Step("Click on title to make ticket widget visible")
    public TicketWidget makeTicketWidgetVisible() {
        sleep(1000);
        makeElementVisible(ticketWidgetTitle);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, ticketWidgetTitle);
        ticketWidgetTitle.click();
        return this;
    }

    @Step("Click on <<Manual>> button")
    public TicketWidget clickOnManualButton() {
        manualButton.click();
        return this;
    }

    @Step("Click on <<Automatic>> button")
    public TicketWidget clickOnAutomaticButton() {
        automaticButton.click();
        return this;
    }

    @Step("Click on <<Any>> button")
    public TicketWidget clickOnAnyButton() {
        anyButton.click();
        return this;
    }

}
