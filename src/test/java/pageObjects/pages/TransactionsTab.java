package pageObjects.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.pages.registration.CustomerInfoForm;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class TransactionsTab extends PageFactoryInitializer {

    @FindBy(xpath = "//a[contains(text(),'Transactions')]")
    private WebElement transactionsLink;

    @FindBy(xpath = "//div[contains(@class,'app-components-Window-___style__header-title___bur5l')]")
    private WebElement transactionsTitle;

    @FindBy(xpath = "//div[label[contains(text(),'From')]]//input")
    private WebElement fromDatePicker;

    @FindBy(xpath = "//div[label[contains(text(),To')]]//input")
    private WebElement toDatePicker;

    @FindBy(xpath = "//div[@class='Select-control']//input")
    private WebElement filter;

    @FindBy(xpath = "//div[contains(@class,'containers-Transactions')]//span[contains(text(),'Today')]")
    private WebElement todaySpan;

    @FindBy(xpath = "//div[contains(@class,'containers-Transactions')]//span[contains(text(),'Yesterday')]")
    private WebElement yesterdaySpan;

    @FindBy(xpath = "//div[contains(@class,'containers-Transactions')]//span[contains(text(),'Last week')]")
    private WebElement lastWeekSpan;

    @FindBy(xpath = "//div[contains(@class,'containers-Transactions')]//span[contains(text(),'Last month')]")
    private WebElement lastMonthSpan;

    @FindBy(xpath = "//div[contains(@class,'TransactionsList-___styles__small-cell')]")
    private List<WebElement> transactionsList;

    @Step("Click on transactions link ")
    public TransactionsTab clickTransactionsLink() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, transactionsLink);
        transactionsLink.click();
        return this;
    }

    @Step("Enter date From {0}")
    public TransactionsTab enterDateFrom(String date) {
        fromDatePicker.sendKeys(date);
        return this;
    }

    @Step("Clear field datepicker From field")
    public TransactionsTab clearDateFrom() {
        sleep(2000);
        scrollIntoView(fromDatePicker);
        this.clearInput(fromDatePicker);
        return this;
    }

    @Step("Clear field datepicker From field")
    public TransactionsTab clearDateTo() {
        sleep(2000);
        scrollIntoView(toDatePicker);
        this.clearInput(toDatePicker);
        return this;
    }

    @Step("Enter date To {0}")
    public TransactionsTab enterDateTo(String date) {
        toDatePicker.sendKeys(date);
        return this;
    }

    @Step("Set withdraw to {0}")
    public TransactionsTab setFilter(String payment) {
        scrollIntoView(filter);
        sleep(1000); //TODO remove this later
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, filter);
        filter.sendKeys(payment + Keys.ENTER);
        return this;
    }

    @Step("Click on transactions title")
    public TransactionsTab clickTransactionsTitle() {
        transactionsTitle.click();
        return this;
    }

    @Step("Click on Today span")
    public TransactionsTab clickToday() {
        sleep(2000);
        todaySpan.click();
        return this;
    }

    @Step("Click on Yesterday span")
    public TransactionsTab clickYesterday() {
        sleep(2000);
        yesterdaySpan.click();
        return this;
    }

    @Step("Click on Last week span")
    public TransactionsTab clickLastWeek() {
        sleep(2000);
        lastWeekSpan.click();
        return this;
    }

    @Step("Click on Last month span")
    public TransactionsTab clickLastMonth() {
        sleep(2000);
        lastMonthSpan.click();
        return this;
    }


    public int getTransactionsNumber() {
        return transactionsList.size();
    }

    @Step("verify if transactions are updated {0} {1}")
    public TransactionsTab verifyTransactionsAreUpdated(int firstNumber, int secondNumber) {
        Assert.assertNotEquals(firstNumber, secondNumber);
        return this;
    }

    @Step("verify if date on datepicker <<from>> is right {0}")
    public TransactionsTab verifyDatePicker(String date) {
        Assert.assertEquals(fromDatePicker.getAttribute("value"), date);
        return this;
    }

    @Step("verify if no available transactions")
    public TransactionsTab noTransactionsAreAvailable() {
        Assert.assertEquals(transactionsList.size(), 0);
        return this;
    }

    @Step("verify if there are available transactions")
    public TransactionsTab transactionsAreAvailable() {
        Assert.assertNotEquals(transactionsList.size(), 0);
        return this;
    }

}
