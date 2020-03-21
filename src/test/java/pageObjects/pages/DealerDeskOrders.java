package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class DealerDeskOrders extends PageFactoryInitializer {

    @FindBy(xpath = "//span[contains(text(),'Orders')]")
    private WebElement ordersLink;

    @FindBy(xpath = "//a[contains(text(),'Own')]")
    private WebElement ownTab;

    @FindBy(xpath = "//div[contains(text(),'Order type...')]")
    private WebElement orderTypeList;

    @FindBy(xpath = "//div[contains(text(),'Market')]")
    private WebElement marketType;

    @FindBy(xpath = "//div[contains(text(),'Limit')]")
    private WebElement limitType;

    @FindBy(xpath = "//div[contains(text(),'Stop')]")
    private WebElement stopType;

    @FindBy(xpath = "//div[contains(text(),'Stop-Limit')]")
    private WebElement stopLimitType;

    @FindBy(xpath = "//div[contains(text(),'Side...')]")
    private WebElement sideTypeList;

    @FindBy(xpath = "//div[contains(text(),'Buy')]")
    private WebElement buyType;

    @FindBy(xpath = "//div[contains(text(),'Sell')]")
    private WebElement sellType;

    @FindBy(xpath = "//div[contains(text(),'Status...')]")
    private WebElement statusTypeList;

    @FindBy(xpath = "//div[contains(text(),'Time in force...')]")
    private WebElement timeInForceList;

    @FindBy(xpath = "//div[contains(text(),'Fill or kill')]")
    private WebElement fillOrKillType;

    @FindBy(xpath = "//div[contains(text(),'G.T.C.')]")
    private WebElement gtcType;

    @FindBy(xpath = "//div[contains(text(),'Day')]")
    private WebElement dayType;

    @FindBy(xpath = "//div[contains(text(),'I.O.C.')]")
    private WebElement iocType;

    @FindBy(xpath = "//div[contains(text(),'Columns')]")
    private WebElement columnsSwitcher;

    @FindBy(xpath = "//button[contains(text(),'Apply changes')]")
    private WebElement applyChangesButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private List<WebElement> cancelOrderButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//label[@id='linstrument']")
    private WebElement instrumentTypeCheckbox;

    @FindBy(xpath = "//label[@id='laccountId']")
    private WebElement accountIDTypeCheckbox;

    @FindBy(xpath = "//label[@id='lorderQty']")
    private WebElement orderQtyTypeCheckbox;

    @FindBy(xpath = "//label[@id='lleavesQty']")
    private WebElement leavesQtyTypeCheckbox;

    @FindBy(xpath = "//label[@id='lcumQty']")
    private WebElement cumQtyTypeCheckbox;

    @FindBy(xpath = "//label[@id='lorderPx']")
    private WebElement orderPriceTypeCheckbox;

    @FindBy(xpath = "//label[@id='lavgPx']")
    private WebElement avgPriceTypeCheckbox;

    @FindBy(xpath = "//label[@id='lstopPx']")
    private WebElement stopPriceTypeCheckbox;

    @FindBy(xpath = "//label[@id='lcreated']")
    private WebElement createdTypeCheckbox;

    @FindBy(xpath = "//label[@id='lupdated']")
    private WebElement updatedTypeCheckbox;

    @FindBy(xpath = "//label[@id='lcomment']")
    private WebElement commentTypeCheckbox;

    @FindBy(xpath = "//label[@id='lorigOrderId']")
    private WebElement origOrderIdCheckbox;

    @FindBy(xpath = "//label[@id='lworkingIndicator']")
    private WebElement stopTrigeredTypeCheckbox;

    @FindBy(xpath = "//label[@id='lhandlInst']")
    private WebElement executiveTypeCheckbox;

    @FindBy(xpath = "//label[@id='lside']")
    private WebElement sideTypeCheckbox;

    @FindBy(xpath = "//label[@id='lstatus']")
    private WebElement statusTypeCheckbox;

    @FindBy(xpath = "//label[@id='ltimeInForce']")
    private WebElement timeInForceTypeCheckbox;

    @FindBy(xpath = "//label[@id='lorderType']")
    private WebElement orderTypeCheckbox;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Instrument')]")
    private WebElement instrumentTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Account ID')]")
    private WebElement accountIDTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Order QTY')]")
    private WebElement orderQTYTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Leaves QTY')]")
    private WebElement leavesQTYColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Cum QTY')]")
    private WebElement cumQTYTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Order price')]")
    private WebElement orderPriceTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Avg. price')]")
    private WebElement avgPriceTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Stop price')]")
    private WebElement stopPriceTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Created')]")
    private WebElement createdTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Updated')]")
    private WebElement updatedTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Comment')]")
    private WebElement commentTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Orig. order ID')]")
    private WebElement origOrderIDColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Stop triggered')]")
    private WebElement stopTriggeredTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Execution type')]")
    private WebElement executionTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Side')]")
    private WebElement sideTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Status')]")
    private WebElement statusTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Time in force')]")
    private WebElement timeInForceTypeColumn;

    @FindBy(xpath = "//div[contains(@class,'SortArrows')][contains(text(),'Type')]")
    private WebElement typeColumn;

    @FindBy(xpath = "//div[contains(@class,'react-select__multi-value__remove')]")
    private WebElement closeType;

    @FindBy(xpath = "//tr[contains(@class,'Components-Table-___style__tr')]")
    private List<WebElement> ordersList;

    @FindBy(xpath = "//li[contains(@class,'style__pagination-page___2rNBi')]//a[@role='button']")
    private List<WebElement> pages;

    @Step("Click on <<Orders>> link")
    public DealerDeskOrders clickOnOrdersLink() {
        ordersLink.click();
        return this;
    }

    @Step("Click on order type list")
    public DealerDeskOrders clickOrderTypeList() {
        orderTypeList.click();
        return this;
    }

    @Step("Click on <<Market>> type")
    public DealerDeskOrders clickOnMarketType() {
        marketType.click();
        return this;
    }

    @Step("Click on <<Limit>> type")
    public DealerDeskOrders clickOnLimitType() {
        limitType.click();
        return this;
    }

    @Step("Click on <<Stop>> type")
    public DealerDeskOrders clickOnStopType() {
        stopType.click();
        return this;
    }

    @Step("Click on <<Stop-Limit>> type")
    public DealerDeskOrders clickOnStopLimitType() {
        stopLimitType.click();
        return this;
    }

    @Step("Click on side type list")
    public DealerDeskOrders clickSideTypeList() {
        sideTypeList.click();
        return this;
    }

    @Step("Click on <<Buy>> type")
    public DealerDeskOrders clickOnBuyType() {
        buyType.click();
        return this;
    }

    @Step("Click on <<Sell>> type")
    public DealerDeskOrders clickOnSellType() {
        sellType.click();
        return this;
    }

    @Step("Click on status type list")
    public DealerDeskOrders clickStatusTypeList() {
        statusTypeList.click();
        return this;
    }

    @Step("Click on time in force type list")
    public DealerDeskOrders clickTimeInForceTypeList() {
        timeInForceList.click();
        return this;
    }

    @Step("Click on <<Fill or kill>> type")
    public DealerDeskOrders clickOnFillOrKillType() {
        fillOrKillType.click();
        return this;
    }

    @Step("Click on <<G.T.C.>> type")
    public DealerDeskOrders clickOnGTCType() {
        gtcType.click();
        return this;
    }

    @Step("Click on <<Day>> type")
    public DealerDeskOrders clickOnDayType() {
        dayType.click();
        return this;
    }

    @Step("Click on <<I.O.C>> type")
    public DealerDeskOrders clickOnIOCType() {
        iocType.click();
        return this;
    }

    @Step("Click on <<Apply changes>> button")
    public DealerDeskOrders clickOnApplyChangesButton() {
        applyChangesButton.click();
        return this;
    }

    @Step("verify column switcher on delearDesk tab Orders")
    public DealerDeskOrders verifyColumnSwitcher() {
        String[] configurableHeaders = {"Instrument", "Account ID", "Order QTY", "Leaves QTY", "Cum QTY", "Order price",
                "Avg. price", "Created", "Updated", "Comment", "Orig. order ID", "Stop triggered", "Execution type", "Side",
                "Status", "Time in force", "Type"};
        scrollIntoView(columnsSwitcher);
        columnsSwitcher.click();
        scrollIntoView(instrumentTypeCheckbox);
        instrumentTypeCheckbox.click();
        scrollIntoView(accountIDTypeCheckbox);
        accountIDTypeCheckbox.click();
        scrollIntoView(orderQtyTypeCheckbox);
        orderQtyTypeCheckbox.click();
        scrollIntoView(leavesQtyTypeCheckbox);
        leavesQtyTypeCheckbox.click();
        scrollIntoView(cumQtyTypeCheckbox);
        cumQtyTypeCheckbox.click();
        scrollIntoView(avgPriceTypeCheckbox);
        avgPriceTypeCheckbox.click();
        scrollIntoView(orderPriceTypeCheckbox);
        orderPriceTypeCheckbox.click();
        scrollIntoView(stopPriceTypeCheckbox);
        stopPriceTypeCheckbox.click();
        scrollIntoView(createdTypeCheckbox);
        createdTypeCheckbox.click();
        scrollIntoView(updatedTypeCheckbox);
        updatedTypeCheckbox.click();
        scrollIntoView(commentTypeCheckbox);
        commentTypeCheckbox.click();
        scrollIntoView(origOrderIdCheckbox);
        origOrderIdCheckbox.click();
        scrollIntoView(stopTrigeredTypeCheckbox);
        stopTrigeredTypeCheckbox.click();
        scrollIntoView(executiveTypeCheckbox);
        executiveTypeCheckbox.click();
        scrollIntoView(sideTypeCheckbox);
        sideTypeCheckbox.click();
        scrollIntoView(statusTypeCheckbox);
        statusTypeCheckbox.click();
        scrollIntoView(timeInForceTypeCheckbox);
        timeInForceTypeCheckbox.click();
        scrollIntoView(orderTypeCheckbox);
        orderTypeCheckbox.click();
        scrollIntoView(applyChangesButton);
        applyChangesButton.click();
        for (String header : configurableHeaders) {
            Assert.assertFalse(isElementPresent(String.format("div[contains(@class,'SortArrows-___style__label')][contains(text(),'%s')]", header)));
        }
        scrollIntoView(columnsSwitcher);
        columnsSwitcher.click();
        scrollIntoView(instrumentTypeCheckbox);
        instrumentTypeCheckbox.click();
        scrollIntoView(accountIDTypeCheckbox);
        accountIDTypeCheckbox.click();
        scrollIntoView(orderQtyTypeCheckbox);
        orderQtyTypeCheckbox.click();
        scrollIntoView(leavesQtyTypeCheckbox);
        leavesQtyTypeCheckbox.click();
        scrollIntoView(cumQtyTypeCheckbox);
        cumQtyTypeCheckbox.click();
        scrollIntoView(avgPriceTypeCheckbox);
        avgPriceTypeCheckbox.click();
        scrollIntoView(orderPriceTypeCheckbox);
        orderPriceTypeCheckbox.click();
        scrollIntoView(stopPriceTypeCheckbox);
        stopPriceTypeCheckbox.click();
        scrollIntoView(createdTypeCheckbox);
        createdTypeCheckbox.click();
        scrollIntoView(updatedTypeCheckbox);
        updatedTypeCheckbox.click();
        scrollIntoView(commentTypeCheckbox);
        commentTypeCheckbox.click();
        scrollIntoView(origOrderIdCheckbox);
        origOrderIdCheckbox.click();
        scrollIntoView(stopTrigeredTypeCheckbox);
        stopTrigeredTypeCheckbox.click();
        scrollIntoView(executiveTypeCheckbox);
        executiveTypeCheckbox.click();
        scrollIntoView(sideTypeCheckbox);
        sideTypeCheckbox.click();
        scrollIntoView(statusTypeCheckbox);
        statusTypeCheckbox.click();
        scrollIntoView(timeInForceTypeCheckbox);
        timeInForceTypeCheckbox.click();
        scrollIntoView(orderTypeCheckbox);
        orderTypeCheckbox.click();
        scrollIntoView(applyChangesButton);
        applyChangesButton.click();
        scrollIntoView(instrumentTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Instrument')]"));
        scrollIntoView(accountIDTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Account ID')]"));
        scrollIntoView(orderQTYTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Order QTY')]"));
        scrollIntoView(leavesQTYColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Leaves QTY')]"));
        scrollIntoView(cumQTYTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Cum QTY')]"));
        scrollIntoView(avgPriceTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Avg. price')]"));
        scrollIntoView(orderPriceTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Order price')]"));
        scrollIntoView(stopPriceTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Stop price')]"));
        scrollIntoView(createdTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Created')]"));
        scrollIntoView(updatedTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Updated')]"));
        scrollIntoView(commentTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Comment')]"));
        scrollIntoView(origOrderIDColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Orig. order ID')]"));
        scrollIntoView(stopTriggeredTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Stop triggered')]"));
        scrollIntoView(executionTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Execution type')]"));
        scrollIntoView(sideTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Side')]"));
        scrollIntoView(statusTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Status')]"));
        scrollIntoView(timeInForceTypeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Time in force')]"));
        scrollIntoView(typeColumn);
        Assert.assertTrue(isElementPresent("//div[contains(@class,'SortArrows')][contains(text(),'Type')]"));
        return this;
    }

    @Step("Click to close current type")
    public DealerDeskOrders clickCloseType() {
        closeType.click();
        return this;
    }

    @Step("Click on <<Own>> tab")
    public DealerDeskOrders clickOnOwnTab() {
        ownTab.click();
        return this;
    }

    @Step("Click on <<Cancel>> order button")
    public DealerDeskOrders clickCancelOrderButton() {
        cancelOrderButton.get(0).click();
        return this;
    }

    @Step("Click on <<Cancel>> button on Pop-Up  window")
    public DealerDeskOrders clickCancelPopupButton() {
        cancelButton.click();
        return this;
    }

    @Step("Verify pages on dealer desk accounts")
    public DealerDeskOrders verifyPagination() {
        int index;
        for (index = 0; index < pages.size(); ++index)
            pages.get(index).click();
        index++;
        Assert.assertTrue(pages.get(pages.size() - 1).getAttribute("aria-label").contains(Integer.toString(index)));
        pages.get(0).click();
        Assert.assertTrue(pages.get(0).getAttribute("aria-label").contains(Integer.toString(1)));
        return this;
    }


}
