package tests;

import data.ChangeInstrument;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.pages.HistoryOrders;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import javax.sound.midi.Instrument;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static data.LoggedUserData.*;
import static data.Status.*;

public class HistoryOrdersTest extends BaseTestWithBrowserRetention {

    private static final String dataWindowName = "ticket";
    private final static String amount = "100";
    private final static String price = "10";
    private int sizeOrdersAllTypes;
    private boolean retrieveSizeOfAllOrders = true;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate date = LocalDate.now();
    private String today = date.format(formatter);
    private String yesterday = date.minusDays(1).format(formatter);
    private String lastMonth = date.minusMonths(1).format(formatter);

    private void countSizeOfAllOrders() {
               HistoryOrders()
                .clickOrdersLink()
                .clearDateFrom()
                .enterDateFrom(today)
                .clickOrdersLink();
        sizeOrdersAllTypes = HistoryOrders().getAllOrdersNumber();
        retrieveSizeOfAllOrders = false;
    }


    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLoginOneAccount(userPhone4, defaultPassword, defaultVerificationCode);
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
                .clickSellButton()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDCHF);
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
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
                .clickSellButton()
                .clickChangeInstruments();
        STEDashboardPage()
                .clickHistoryLink();
    }

    @BeforeMethod
    public void resetAllFilters() {
        HistoryOrders()
                .clickOnResetAllFiltersButton();
    }

    @TestCaseId("TC_History_Orders_001")
    @Description("Verify if date on datepicker is changed then different period of time will be selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test1DateRangedIsChanged() throws Exception {
        String yesterday = date.minusDays(1).format(formatter);
        String lastWeek = date.minusWeeks(1).format(formatter);
        HistoryOrders()
                .clickToday()
                .verifyDatePicker(today)
                .clickYesterday()
                .verifyDatePicker(yesterday)
                .clickLastWeek()
                .verifyDatePicker(lastWeek)
                .clickLastMonth()
                .verifyDatePicker(lastMonth);
    }

    @TestCaseId("TC_History_Orders_002")
    @Description("reset all filters")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test2ResetAllFilters() throws Exception {
        HistoryOrders()
                .setStatus(FILLED.toString())
                .setInstrument(ChangeInstrument.itemAUDCHF)
                .clickToday()
                .clickOnResetAllFiltersButton()
                .verifyValuesWhenFilterIsReset(lastMonth);
    }

    @TestCaseId("TC_History_Orders_003")
    @Description("Verify if orders list is updated when datepicker is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test3DatePickerIsChanged() throws Exception {
        HistoryOrders()
                .clickOrdersLink()
                .clearDateFrom()
                .enterDateFrom(lastMonth)
                .clickOrdersLink();
        sizeOrdersAllTypes = HistoryOrders().getAllOrdersNumber();
        HistoryOrders()
                .clearDateFrom()
                .enterDateFrom(today)
                .clickOrdersLink();
        int sizeAfter = HistoryOrders().getOrdersNumber();
        HistoryOrders()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, sizeAfter);
    }

    @TestCaseId("TC_History_Orders_004")
    @Description("Verify if orders list is updated when instrument of orders is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test4InstrumentIsChanged() throws Exception {
        if (retrieveSizeOfAllOrders)
            countSizeOfAllOrders();
        HistoryOrders()
                .setInstrument(ChangeInstrument.itemAUDCHF);
        sleep(2000);
        HistoryOrders()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .setInstrument(ChangeInstrument.itemAUDJPY);
        sleep(2000);
        HistoryOrders()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .setInstrument(ChangeInstrument.itemEURUSD);
        sleep(2000);
        HistoryOrders()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber());
    }

    @TestCaseId("TC_History_Orders_005")
    @Description("Verify if orders list is updated when type of orders is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test5TypeIsChanged() throws Exception {
        if (retrieveSizeOfAllOrders)
            countSizeOfAllOrders();
        HistoryOrders()
                .clickMarketType()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .clickLimitType()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .clickStopType()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .clickStopLimitType()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber());
    }

    @TestCaseId("TC_History_Orders_006")
    @Description("Verify if orders list is updated when side of orders is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test6SideIsChanged() throws Exception {
        if (retrieveSizeOfAllOrders)
            countSizeOfAllOrders();
        HistoryOrders()
                .clickSellSide()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .clickBuySide()
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber());
    }


    @TestCaseId("TC_History_Orders_007")
    @Description("Verify if orders list is updated when status of orders is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test7StatusIsChanged() throws Exception {
        if (retrieveSizeOfAllOrders)
            countSizeOfAllOrders();
        HistoryOrders()
                .setStatus(FILLED.toString())
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .setStatus(CANCELED.toString())
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .setStatus(REPLACED.toString())
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .setStatus(REJECTED.toString())
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber())
                .setStatus(EXPIRED.toString())
                .verifyOrdersAreUpdated(sizeOrdersAllTypes, HistoryOrders().getOrdersNumber());
    }

    @TestCaseId("TC_History_Orders_008")
    @Description("search notification by id")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test8FindNotificationById() throws Exception {
        HistoryOrders()
                .enterId(HistoryOrders().getId())
                .verifyOrdersSize(1)
                .clearId()
                .verifyOrdersAreUpdated(0, HistoryOrders().getOrdersNumber());
    }


}
