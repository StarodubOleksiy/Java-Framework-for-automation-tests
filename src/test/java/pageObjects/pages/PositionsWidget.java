package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsWidget extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@data-window-name='positions'][contains(text(),'Positions')]")
    private WebElement positionsButton;

    @FindBy(xpath = "//div[contains(text(),'Instrument')]")
    private WebElement instrumentColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Amount')]")
    private WebElement amountColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'AVP')]")
    private WebElement avpColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Breakeven')]")
    private WebElement breakevenColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Last swap')]")
    private WebElement swapColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Market Price')]")
    private WebElement marketPriceColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Unrealized P/L')]")
    private WebElement unrealizedPLColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Realized P/L')]")
    private WebElement realizedPLColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Closed P/L')]")
    private WebElement closedPLColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Total P/L')]")
    private WebElement totalPLColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Fee')]")
    private WebElement feeColumn;

    @FindBy(xpath = "//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'Accrued Interest')]")
    private WebElement accrdInterestColumn;

    @FindBy(xpath = "//button[contains(text(),'Close All')]")
    private WebElement closeAllButton;

    @FindBy(xpath = "//button[contains(text(),'Chat')]")
    private WebElement chatButton;

    @FindBy(xpath = "//div[contains(@class,'Positions-___style__button-close___3dYIH')]")
    private WebElement closeDiv;

    @FindBy(xpath = "//div[contains(@class,'Positions-___style__cell____bcRf')]//div[contains(@class,'style__button-close___3dYIH')]")
    private List<WebElement> closeButtons;

    @FindBy(xpath = "//div[@class='app-components-Popup-___style__content___9oLFP']//span[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='app-components-Popup-___style__content___9oLFP']//span[contains(text(),'Close')]")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Are you sure you want to close position?')]")
    private WebElement closePositionPopUpWindow;

    @FindBy(xpath = "//span[contains(@class,'positions__open')]")
    private WebElement positionsOpenButton;

    @FindBy(xpath = "//div[@class='_active app-pages-TradingPage-containers-Positions-___style__row___ugA4V']")
    private List<WebElement> positionsList;

    @FindBy(xpath = "//div[@data-window-name='positions']//i[contains(@class,'icon-icon-block-view')]")
    private WebElement columnSwither;

    @FindBy(xpath = "//label[@id='lamount']")
    private WebElement amountCheckbox;

    @FindBy(xpath = "//label[@id='lavp']")
    private WebElement avpCheckbox;

    @FindBy(xpath = "//label[@id='lbreakeven']")
    private WebElement breakevenCheckbox;

    @FindBy(xpath = "//label[@id='lswapInCur']")
    private WebElement swapCheckbox;

    @FindBy(xpath = "//label[@id='lmarketRate']")
    private WebElement marketPriceCheckbox;

    @FindBy(xpath = "//label[@id='lunrealizedPl']")
    private WebElement unrealizedPlCheckbox;

    @FindBy(xpath = "//label[@id='lrealizedPl']")
    private WebElement realizedPlCheckbox;

    @FindBy(xpath = "//label[@id='lclosedPl']")
    private WebElement closedPlCheckbox;

    @FindBy(xpath = "//label[@id='ltotalPl']")
    private WebElement totalPlCheckbox;

    @FindBy(xpath = "//label[@id='lfee']")
    private WebElement feeCheckbox;

    @FindBy(xpath = "//label[@id='laccruedInterest']")
    private WebElement accruedInterestCheckbox;


    @Step("verify column switcher on positions widget")
    public PositionsWidget verifyColumnSwitcher() {
        String[] configurableHeaders = {"Amount", "AVP", "Breakeven", "Last swap",
                "Market Price", "Unrealized P/L", "Realize P/L",
                "Closed P/L", "Total P/L", "Fee", "Accrued Interest"};

        this.clickOnPositionsButton();
        getWebDriver().findElement(By.cssSelector("div[class*='app-pages-TradingPage-containers-Positions-___style__header']")).click();
        this.clickOnColumnSwitcher();
        amountCheckbox.click();
        avpCheckbox.click();
        breakevenCheckbox.click();
        swapCheckbox.click();
        marketPriceCheckbox.click();
        unrealizedPlCheckbox.click();
        realizedPlCheckbox.click();
        closedPlCheckbox.click();
        totalPlCheckbox.click();
        feeCheckbox.click();
        accruedInterestCheckbox.click();
        this.clickOnPositionsButton();
        sleep(2000);

        for (String header : configurableHeaders) {
            Assert.assertFalse(isElementPresent(String.format("//div[@data-window-name='positions']//div[contains(@class,'SortArrow')][contains(text(),'%s')]", header)));
        }

        this.clickOnColumnSwitcher();
        amountCheckbox.click();
        avpCheckbox.click();
        breakevenCheckbox.click();
        swapCheckbox.click();
        marketPriceCheckbox.click();
        unrealizedPlCheckbox.click();
        realizedPlCheckbox.click();
        closedPlCheckbox.click();
        totalPlCheckbox.click();
        feeCheckbox.click();
        accruedInterestCheckbox.click();
        this.clickOnPositionsButton();

        sleep(1000);

        scrollIntoView(amountColumn);
        Assert.assertTrue(amountColumn.isDisplayed());
        scrollIntoView(avpColumn);
        Assert.assertTrue(avpColumn.isDisplayed());
        scrollIntoView(breakevenColumn);
        Assert.assertTrue(breakevenColumn.isDisplayed());
        scrollIntoView(swapColumn);
        Assert.assertTrue(swapColumn.isDisplayed());
        scrollIntoView(marketPriceColumn);
        Assert.assertTrue(marketPriceColumn.isDisplayed());
        scrollIntoView(unrealizedPLColumn);
        Assert.assertTrue(unrealizedPLColumn.isDisplayed());
        scrollIntoView(realizedPLColumn);
        Assert.assertTrue(realizedPLColumn.isDisplayed());
        scrollIntoView(closedPLColumn);
        Assert.assertTrue(closedPLColumn.isDisplayed());
        scrollIntoView(totalPLColumn);
        Assert.assertTrue(totalPLColumn.isDisplayed());
        scrollIntoView(feeColumn);
        Assert.assertTrue(feeColumn.isDisplayed());
        scrollIntoView(accrdInterestColumn);
        Assert.assertTrue(accrdInterestColumn.isDisplayed());

        return this;
    }

    @Step("Click on positions button")
    public PositionsWidget clickOnPositionsButton() {
        sleep(1000);
        makeElementVisible(positionsButton);
        scrollIntoView(positionsButton);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, positionsButton);
        positionsButton.click();
        return this;
    }

    @Step("Click on positions open button (+)")
    public PositionsWidget clickOnPositionsOpenButton() {
        scrollIntoView(positionsOpenButton);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, positionsOpenButton);
        positionsOpenButton.click();
        return this;
    }

    @Step("verify positions open button switcher for positions rows(+/-)")
    public PositionsWidget verifyPositionsColumnOpenButton() {
        Assert.assertNotEquals(positionsList.size(), 0);
        scrollIntoView(positionsOpenButton);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, positionsOpenButton);
        positionsOpenButton.click();
        Assert.assertEquals(positionsList.size(), 0);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, positionsOpenButton);
        positionsOpenButton.click();
        return this;
    }


    @Step("Verify positions widget is present")
    public PositionsWidget verifyPositionsWidgetIsPresent() {
        scrollIntoView(instrumentColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(instrumentColumn, 30, "Instrument");
        scrollIntoView(amountColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(amountColumn, 30, "Amount");
        scrollIntoView(avpColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(avpColumn, 30, "AVP");
        scrollIntoView(breakevenColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(breakevenColumn, 30, "Breakeven");
        scrollIntoView(swapColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(swapColumn, 30, "Last swap");
        scrollIntoView(marketPriceColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(marketPriceColumn, 30, "Market Price");
        scrollIntoView(unrealizedPLColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(unrealizedPLColumn, 30, "Unrealized P/L");
        scrollIntoView(realizedPLColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(realizedPLColumn, 30, "Realized P/L");
        scrollIntoView(closedPLColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(closedPLColumn, 30, "Closed P/L");
        scrollIntoView(totalPLColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(totalPLColumn, 30, "Total P/L");
        scrollIntoView(feeColumn);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(feeColumn, 30, "Fee");
        scrollIntoView(closeAllButton);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(closeAllButton, 30, "Close All");
        scrollIntoView(closeDiv);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(closeButtons.get(0), 30, "Close");
        return this;
    }

    @Step("Click on close button")
    public PositionsWidget clickOnCloseButton() {
        scrollIntoView(closeButtons.get(0));
        closeButtons.get(0).click();
        return this;
    }

    @Step("Click on cancel button on pop up window")
    public PositionsWidget clickOnCancelButtonPopUpWindow() {
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, cancelButton);
        cancelButton.click();
        return this;
    }

    @Step("Click on close button on pop up window")
    public PositionsWidget clickOnCloseButtonPopUpWindow() {
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, closeButton);
        closeButton.click();
        return this;
    }

    @Step("Verify close position pop up window")
    public PositionsWidget verifyClosePositionPopUpWindow() {
        Assert.assertTrue(closePositionPopUpWindow.isDisplayed());
        return this;
    }

    @Step("verify positions sorting")
    public PositionsWidget verifyPositionSorting() throws Exception {
        this.checkingSortingByLinks("Instrument");
        this.checkingSortingByLinks("Amount");
        this.checkingSortingByLinks("AVP");
        this.checkingSortingByLinks("Breakeven");
        this.checkingSortingByLinks("Last swap");
        this.checkingSortingByLinks("Market Price");
        this.checkingSortingByLinks("Unrealized P/L");
        this.checkingSortingByLinks("Realized P/L");
        this.checkingSortingByLinks("Closed P/L");
        this.checkingSortingByLinks("Total P/L");
        this.checkingSortingByLinks("Fee");
        this.checkingSortingByLinks("Accrued Interest");
        return this;

    }

    private void checkingSortingByLinks(String columnName) throws Exception {
        WebElement element = getWebDriver().findElement(By.xpath(String.format("//div[contains(@class,'SortArrows')][contains(text(),'%s')]", columnName)));
        scrollIntoView(element);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, element);
        element.click();
        scrollIntoView(positionsList.get(0));
        List<String> positions = Arrays.asList(positionsList.get(0).getText().split("\\n"));
        String firstString = positions.get(2);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, element);
        element.click();
        scrollIntoView(positionsList.get(positionsList.size() - 1));
        positions = Arrays.asList(positionsList.get(positionsList.size() - 1).getText().split("\\n"));
        String secondString = positions.get(2);

        Assert.assertTrue(firstString.contains(getWholeAmount(secondString)));
    }

    @Step("Click on column switcher")
    public PositionsWidget clickOnColumnSwitcher() {
        scrollIntoView(columnSwither);
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, columnSwither);
        columnSwither.click();
        return this;
    }


}
