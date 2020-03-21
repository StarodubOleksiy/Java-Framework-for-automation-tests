package tests;

import data.ChangeInstrument;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static data.LoggedUserData.*;
import static data.Status.FILLED;

public class HistoryNotificationsTest extends BaseTestWithBrowserRetention {

    private static final String dataWindowName = "ticket";
    private final static String amount = "100";
    private final static String price = "10";
    private int sizeNotificationsListAllTypes;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate date = LocalDate.now();
    private String lastYear = date.minusYears(1).format(formatter);
    private String today = date.format(formatter);
    private String lastMonth = date.minusMonths(1).format(formatter);


    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLoginOneAccount(userPhone4, defaultPassword, defaultVerificationCode);
        sleep(6000);

        WatchlistWidget().clickMakeAnOrderOnLastInstrument();

        TicketWidget()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDJPY);
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickOnManualButton()
                .clickSellButton()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDCHF);
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickOnManualButton()
                .clickSellButton()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemEURUSD);
//        TicketWidget()
//                .clearAmountOnOrderSessionField()
//                .enterAmountOnOrderSession(amount)
//                .clearExpectedPriceField()
//                .enterExpectedPrice(price)
//                .clickBuyOrderButton();
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickOnManualButton()
                .clickSellButton()
                .clickChangeInstruments();
        STEDashboardPage()
                .clickHistoryLink();
        HistoryNotifications()
                .clickNotificationsLink();
    }

    @TestCaseId("TC_History_Notifications_001")
    @Description("Verify new unread notifications and <<mark all as read>> button")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test1NewUnreadNotifications() throws Exception {
        sleep(6000);
        HistoryNotifications()
                .isNewNotificationsListNotEmpty()
                .clickOnMarkAllAsReadButton();
        sleep(2000);
        HistoryNotifications()
                .isNewNotificationsListEmpty();
    }

    @TestCaseId("TC_History_Notifications_002")
    @Description("Verify if date on datepicker is changed then different period of time will be selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test2DateRangedIsChanged() throws Exception {
        String yesterday = date.minusDays(1).format(formatter);
        String lastWeek = date.minusWeeks(1).format(formatter);
        HistoryNotifications()
                .clickToday()
                .verifyDatePicker(today)
                .clickYesterday()
                .verifyDatePicker(yesterday)
                .clickLastWeek()
                .verifyDatePicker(lastWeek)
                .clickLastMonth()
                .verifyDatePicker(lastMonth);
    }

    @TestCaseId("TC_History_Notifications_003")
    @Description("reset all filters")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test3ResetAllFilters() throws Exception {
        HistoryNotifications()
                .clickToday()
                .clickOnResetAllFiltersButton()
                .verifyValuesWhenFilterIsReset(lastMonth);
    }

    @TestCaseId("TC_History_Notifications_004")
    @Description("Verify if trades list is updated when datepicker is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test4datePickerIsChanged() throws Exception {
        sizeNotificationsListAllTypes = HistoryNotifications().countSizeOfAllTrades(lastYear);
        HistoryNotifications()
                .clearDateFrom()
                .enterDateFrom(today)
                .clickNotificationsLink();
        sleep(1000);
        int sizeAfter = HistoryNotifications().getNotificationsNumber();
        HistoryNotifications()
                .verifyNotificationsAreUpdated(sizeNotificationsListAllTypes, sizeAfter);
    }


}
