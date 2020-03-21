package pageObjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class HistoryNotifications extends PageFactoryInitializer {

    @FindBy(xpath = "//a[contains(text(),'Notifications')]")
    private WebElement notificationsLink;

    @FindBy(xpath = "//div[label[contains(text(),'From')]]//input")
    private WebElement fromDatePicker;

    @FindBy(xpath = "//div[label[contains(text(),To')]]//input")
    private WebElement toDatePicker;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Notifications')]//span[contains(text(),'Today')]")
    private WebElement todaySpan;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Notifications')]//span[contains(text(),'Yesterday')]")
    private WebElement yesterdaySpan;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Notifications')]//span[contains(text(),'Last week')]")
    private WebElement lastWeekSpan;

    @FindBy(xpath = "//div[contains(@class,'HistoryPage-containers-Notifications')]//span[contains(text(),'Last month')]")
    private WebElement lastMonthSpan;

    @FindBy(xpath = "//div[contains(@class,'Notifications-___styles__notification___2b9mZ')]")
    private List<WebElement> notificationsList;

    @FindBy(xpath = "//div[contains(@class,'Notifications-___styles__new___2GsK4')]")
    private List<WebElement> unreadNotificationsList;

    @FindBy(xpath = "//button[contains(text(),'Reset all filters')]")
    private WebElement resetAllFiltersButton;

    @FindBy(xpath = "//button[contains(text(),'Mark all as read')]")
    private WebElement markAllAsReadButton;

    @Step("Click on notifications link ")
    public HistoryNotifications clickNotificationsLink() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, notificationsLink);
        notificationsLink.click();
        return this;
    }

    @Step("Enter date From {0}")
    public HistoryNotifications enterDateFrom(String date) {
        fromDatePicker.sendKeys(date);
        return this;
    }

    @Step("Clear field datepicker From field")
    public HistoryNotifications clearDateFrom() {
        sleep(2000);
        scrollIntoView(fromDatePicker);
        this.clearInput(fromDatePicker);
        return this;
    }

    @Step("Clear field datepicker To field")
    public HistoryNotifications clearDateTo() {
        sleep(2000);
        scrollIntoView(toDatePicker);
        this.clearInput(toDatePicker);
        return this;
    }

    @Step("Enter date To {0}")
    public HistoryNotifications enterDateTo(String date) {
        toDatePicker.sendKeys(date);
        return this;
    }

    @Step("Click on Today span")
    public HistoryNotifications clickToday() {
        sleep(2000);
        todaySpan.click();
        return this;
    }

    @Step("Click on Yesterday span")
    public HistoryNotifications clickYesterday() {
        sleep(2000);
        yesterdaySpan.click();
        return this;
    }

    @Step("Click on Last week span")
    public HistoryNotifications clickLastWeek() {
        sleep(2000);
        lastWeekSpan.click();
        return this;
    }

    @Step("Click on Last month span")
    public HistoryNotifications clickLastMonth() {
        sleep(2000);
        lastMonthSpan.click();
        return this;
    }

    public int getAllNotificationsNumber() {
        int size;
        for (size = 0; size < notificationsList.size(); ++size) {
            scrollIntoView(notificationsList.get(size));
            scrollIntoView(notificationsList.get(0));
            if (size > 100)
                size = 100;
            break;
        }
        return size;
    }

    public int getNotificationsNumber() {
        return notificationsList.size();
    }

    @Step("verify if notifications are updated . size before {0}, size after {1}")
    public HistoryNotifications verifyNotificationsAreUpdated(int listSizeBefore, int listSizeAfter) {
        sleep(3000);
        if (notificationsList.size() > 0)
            Assert.assertNotEquals(listSizeBefore, listSizeAfter);
        else
            Assert.assertEquals(notificationsList.size(), 0);
        return this;
    }


    public HistoryNotifications verifyNotificationsSize(int size) {
        Assert.assertEquals(notificationsList.size(), size);
        return this;
    }


    @Step("verify if date on datepicker <<from>> is right {0}")
    public HistoryNotifications verifyDatePicker(String date) {
        Assert.assertEquals(fromDatePicker.getAttribute("value"), date);
        return this;
    }

    @Step("verify if no available notifications")
    public HistoryNotifications noNotificationsAreAvailable() {
        Assert.assertEquals(notificationsList.size(), 0);
        return this;
    }

    @Step("verify if there are available notifications")
    public HistoryNotifications tradesAreAvailable() {
        sleep(5000);
        Assert.assertNotEquals(notificationsList.size(), 0);
        return this;
    }

    @Step("Click on <<Reset all filters>> button")
    public HistoryNotifications clickOnResetAllFiltersButton() {
        sleep(2000);
        resetAllFiltersButton.click();
        return this;
    }

    @Step("Click on <<Mark all as read>> button")
    public HistoryNotifications clickOnMarkAllAsReadButton() {
        sleep(2000);
        markAllAsReadButton.click();
        return this;
    }

    @Step("Verify datepicker and instrument")
    public HistoryNotifications verifyValuesWhenFilterIsReset(String date) {
        Assert.assertEquals(fromDatePicker.getAttribute("value"), date);
        return this;
    }

    @Step("Verify if list of new notifications is not empty")
    public HistoryNotifications isNewNotificationsListNotEmpty() {
        Assert.assertNotEquals(unreadNotificationsList.size(), 0);
        return this;
    }

    @Step("Verify if list of new notifications is empty")
    public HistoryNotifications isNewNotificationsListEmpty() {
        Assert.assertEquals(unreadNotificationsList.size(), 0);
        return this;
    }

    public int countSizeOfAllTrades(String lastYear) {
        HistoryNotifications()
                .clickNotificationsLink()
                .clearDateFrom()
                .enterDateFrom(lastYear)
                .clickNotificationsLink();
        return getAllNotificationsNumber();
    }

}
