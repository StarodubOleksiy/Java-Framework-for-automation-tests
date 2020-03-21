package pageObjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HistoryOrders extends PageFactoryInitializer {

    @FindBy(xpath = "//a//b[contains(text(),'Orders')]")
    private WebElement ordersLink;

    @FindBy(xpath = "//div[div[contains(text(),'Instrument')]]//input")
    private WebElement instrumentFilter;

    @FindBy(xpath = "//div[div[contains(text(),'Status')]]//input")
    private WebElement statusFilter;

    @FindBy(xpath = "//div[div[contains(text(),'Instrument')]]//div[@class='Select-placeholder']")
    private WebElement instrumentValue;

    @FindBy(xpath = "//div[div[contains(text(),'Status')]]//div[@class='Select-placeholder']")
    private WebElement statusValue;

    @FindBy(xpath = "//div[label[contains(text(),'From')]]//input")
    private WebElement fromDatePicker;

    @FindBy(xpath = "//div[label[contains(text(),'To')]]//input")
    private WebElement toDatePicker;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Orders')]//span[contains(text(),'Today')]")
    private WebElement todaySpan;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Orders')]//span[contains(text(),'Yesterday')]")
    private WebElement yesterdaySpan;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Orders')]//span[contains(text(),'Last week')]")
    private WebElement lastWeekSpan;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Orders')]//span[contains(text(),'Last month')]")
    private WebElement lastMonthSpan;
  //@FindBy(xpath = "//div[contains(@class,'containers-Trades-___styles__trade___2Ip_H')]")
    @FindBy(xpath = "//div[contains(@class,'containers-Orders-___styles__order___3TJpg')]")
    private List<WebElement> ordersList;

    @FindBy(xpath = "//div[contains(@class,'styles__order___3TJpg')]//div[contains(@class,'styles__colored___1lp5i')]")
    private List<WebElement> idList;

    @FindBy(xpath = "//div[div[contains(text(),'Type')]]//span[contains(text(),'All')]")
    private WebElement allTypesSpan;

    @FindBy(xpath = "//div[contains(@class,'Switchers')]//span[text()='Market']")
    private WebElement marketTypesSpan;

    @FindBy(xpath = "//div[contains(@class,'Switchers')]//span[text()='Limit']")
    private WebElement limitTypesSpan;

    @FindBy(xpath = "//div[contains(@class,'Switchers')]//span[text()='Stop']")
    private WebElement stopTypesSpan;

    @FindBy(xpath = "//div[contains(@class,'Switchers')]//span[text()='Stop-Limit']")
    private WebElement stopLimitTypesSpan;

    @FindBy(xpath = "//div[div[contains(text(),'Side')]]//span[contains(text(),'All')]")
    private WebElement allSidesSpan;

    @FindBy(xpath = "//div[contains(@class,'Switchers')]//span[text()='Buy']")
    private WebElement buySideSpan;

    @FindBy(xpath = " //div[contains(@class,'Switchers')]//span[text()='Sell']")
    private WebElement sellSideSpan;

    @FindBy(xpath = "//button[contains(text(),'Reset all filters')]")
    private WebElement resetAllFiltersButton;

    @FindBy(xpath = "//input[@name='id']")
    private WebElement notificationId;

    @Step("Click on orders link ")
    public HistoryOrders clickOrdersLink() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, ordersLink);
        ordersLink.click();
        return this;
    }

    @Step("Enter date From {0}")
    public HistoryOrders enterDateFrom(String date) {
        fromDatePicker.sendKeys(date);
        return this;
    }

    @Step("Clear field datepicker From field")
    public HistoryOrders clearDateFrom() {
        sleep(2000);
        scrollIntoView(fromDatePicker);
        this.clearInput(fromDatePicker);
        return this;
    }

    @Step("Clear field datepicker To field")
    public HistoryOrders clearDateTo() {
        sleep(2000);
        scrollIntoView(toDatePicker);
        this.clearInput(toDatePicker);
        return this;
    }

    @Step("Enter date To {0}")
    public HistoryOrders enterDateTo(String date) {
        toDatePicker.sendKeys(date);
        return this;
    }

    @Step("Click on Today span")
    public HistoryOrders clickToday() {
        sleep(2000);
        todaySpan.click();
        return this;
    }

    @Step("Click on Yesterday span")
    public HistoryOrders clickYesterday() {
        sleep(2000);
        yesterdaySpan.click();
        return this;
    }

    @Step("Click on Last week span")
    public HistoryOrders clickLastWeek() {
        sleep(2000);
        lastWeekSpan.click();
        return this;
    }

    @Step("Click on Last month span")
    public HistoryOrders clickLastMonth() {
        sleep(2000);
        lastMonthSpan.click();
        return this;
    }

    @Step("Click on all types span")
    public HistoryOrders clickAllTypes() {
        sleep(2000);
        allTypesSpan.click();
        return this;
    }

    @Step("Click on market type span")
    public HistoryOrders clickMarketType() {
        sleep(2000);
        marketTypesSpan.click();
        return this;
    }

    @Step("Click on limit type span")
    public HistoryOrders clickLimitType() {
        sleep(2000);
        limitTypesSpan.click();
        return this;
    }

    @Step("Click on stop type span")
    public HistoryOrders clickStopType() {
        sleep(2000);
        stopTypesSpan.click();
        return this;
    }

    @Step("Click on stop-limit type span")
    public HistoryOrders clickStopLimitType() {
        sleep(2000);
        stopLimitTypesSpan.click();
        return this;
    }

    @Step("Click on all side span")
    public HistoryOrders clickAllSides() {
        sleep(2000);
        allSidesSpan.click();
        return this;
    }

    @Step("Click on buy side span")
    public HistoryOrders clickBuySide() {
        sleep(2000);
        buySideSpan.click();
        return this;
    }

    @Step("Click on sell side span")
    public HistoryOrders clickSellSide() {
        sleep(2000);
        sellSideSpan.click();
        return this;
    }
/*
   public int getAllTradesNumber() {
        int size;
        for (size = 0; size < tradesList.size(); ++size)
            scrollIntoView(tradesList.get(size));
        scrollIntoView(tradesList.get(0));
        return size;
    }

 */

    public int getAllOrdersNumber() {
        int size;
        for (size = 0; size < ordersList.size(); ++size)
            scrollIntoView(ordersList.get(size));
        scrollIntoView(ordersList.get(0));
        return size;
    }

    public int getOrdersNumber() {
        return ordersList.size();
    }

    @Step("verify if orders are updated . size before {0}, size after {1}")
    public HistoryOrders verifyOrdersAreUpdated(int listSizeBefore, int listSizeAfter) {
        sleep(3000);
        if (ordersList.size() > 0)
            Assert.assertNotEquals(listSizeBefore, listSizeAfter);
        else
            Assert.assertEquals(ordersList.size(), 0);
        return this;
    }


    public HistoryOrders verifyOrdersSize(int size) {
        Assert.assertEquals(ordersList.size(), size);
        return this;
    }


    @Step("verify if date on datepicker <<from>> is right {0}")
    public HistoryOrders verifyDatePicker(String date) {
        Assert.assertEquals(fromDatePicker.getAttribute("value"), date);
        return this;
    }

    @Step("verify if no available orders")
    public HistoryOrders noOrdersAreAvailable() {
        Assert.assertEquals(ordersList.size(), 0);
        return this;
    }

    @Step("verify if there are available orders")
    public HistoryOrders ordersAreAvailable() {
        sleep(5000);
        Assert.assertNotEquals(ordersList.size(), 0);
        return this;
    }

    @Step("Set instrument to {0}")
    public HistoryOrders setInstrument(String instrument) {
        scrollIntoView(instrumentFilter);
        instrumentFilter.sendKeys(instrument + Keys.ENTER);
        return this;
    }

    @Step("Set status to {0}")
    public HistoryOrders setStatus(String status) {
        scrollIntoView(statusFilter);
        statusFilter.sendKeys(status + Keys.ENTER);
        return this;
    }

    @Step("Enter the id {0}")
    public HistoryOrders enterId(String idString) {
        scrollIntoView(notificationId);
        notificationId.sendKeys(idString);
        return this;
    }


    @Step("Clear notification id field")
    public HistoryOrders clearId() {
        this.clearInput(notificationId);
        return this;
    }

    @Step("Click on <<Reset all filters>> button")
    public HistoryOrders clickOnResetAllFiltersButton() {
        sleep(6000);
        resetAllFiltersButton.click();
        return this;
    }

    @Step("get first id of order list")
    public String getId() {
        return idList.get(0).getText();
    }

    @Step("Verify datepicker, instrument and status")
    public HistoryOrders verifyValuesWhenFilterIsReset(String date) {
        Assert.assertEquals(fromDatePicker.getAttribute("value"), date);
        Assert.assertEquals(instrumentValue.getText(), "All");
        Assert.assertEquals(statusValue.getText(), "All");
        return this;
    }

}
