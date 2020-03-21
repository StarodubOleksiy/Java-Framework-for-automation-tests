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
import static data.Status.*;
import static data.Status.EXPIRED;

public class HistoryTradesTest extends BaseTestWithBrowserRetention {

    private static final String dataWindowName = "ticket";
    private final static String amount = "100";
    private final static String price = "10";
    private int sizeTradesAllTypes;
    private boolean retrieveSizeOfAllTrades = true;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate date = LocalDate.now();
    private String lastYear = date.minusYears(1).format(formatter);
    private String today = date.format(formatter);
    private String lastMonth = date.minusMonths(1).format(formatter);

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
        HistoryTrades()
                .clickTradesLink();
    }

    @BeforeMethod
    public void resetAllFilters() {
        HistoryTrades()
                .clickOnResetAllFiltersButton();
    }

    private void countSizeOfAllTrades() {
        HistoryTrades()
                .clickTradesLink()
                .clearDateFrom()
                .enterDateFrom(lastYear)
                .clickTradesLink();
        sizeTradesAllTypes = HistoryTrades().getAllTradesNumber();
        retrieveSizeOfAllTrades = false;
    }

    @TestCaseId("TC_History_Trades_001")
    @Description("Verify if date on datepicker is changed then different period of time will be selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test1dateRangedIsChanged() throws Exception {
        String yesterday = date.minusDays(1).format(formatter);
        String lastWeek = date.minusWeeks(1).format(formatter);
        HistoryTrades()
                .clickToday()
                .verifyDatePicker(today)
                .clickYesterday()
                .verifyDatePicker(yesterday)
                .clickLastWeek()
                .verifyDatePicker(lastWeek)
                .clickLastMonth()
                .verifyDatePicker(lastMonth);
    }

    @TestCaseId("TC_History_Trades_002")
    @Description("reset all filters")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test2ResetAllFilters() throws Exception {
        HistoryTrades()
                .setInstrument(ChangeInstrument.itemAUDCHF)
                .clickToday()
                .clickOnResetAllFiltersButton()
                .verifyValuesWhenFilterIsReset(lastMonth);
    }

    @TestCaseId("TC_History_Trades_003")
    @Description("Verify if orders list is updated when datepicker is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test3datePickerIsChanged() throws Exception {
        if (retrieveSizeOfAllTrades)
            countSizeOfAllTrades();
        HistoryTrades()
                .clearDateFrom()
                .enterDateFrom(today)
                .clickTradesLink();
        int sizeAfter = HistoryTrades().getTradesNumber();
        HistoryOrders()
                .verifyOrdersAreUpdated(sizeTradesAllTypes, sizeAfter);
    }

    @TestCaseId("TC_History_Trades_004")
    @Description("Verify if trades list is updated when instrument of trades is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test4InstrumentIsChanged() throws Exception {
        if (retrieveSizeOfAllTrades)
            countSizeOfAllTrades();
        HistoryTrades()
                .setInstrument(ChangeInstrument.itemAUDCHF);
        sleep(2000);
        HistoryTrades()
                .verifyTradesAreUpdated(sizeTradesAllTypes, HistoryOrders().getOrdersNumber())
                .setInstrument(ChangeInstrument.itemAUDJPY);
        sleep(2000);
//        HistoryTrades()
//                .verifyTradesAreUpdated(sizeTradesAllTypes, HistoryOrders().getOrdersNumber())
//                .setInstrument(ChangeInstrument.itemUSDRUB);
//        sleep(2000);
        HistoryTrades()
                .verifyTradesAreUpdated(sizeTradesAllTypes, HistoryOrders().getOrdersNumber())
                .setInstrument(ChangeInstrument.itemEURUSD);
        sleep(2000);
        HistoryTrades()
                .verifyTradesAreUpdated(sizeTradesAllTypes, HistoryOrders().getOrdersNumber());
    }

    @TestCaseId("TC_History_Orders_005")
    @Description("Verify if orders list is updated when side of trades is changed")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test5SideIsChanged() throws Exception {
        if (retrieveSizeOfAllTrades)
            countSizeOfAllTrades();
        HistoryTrades()
                .clickSellSide()
                .verifyTradesAreUpdated(sizeTradesAllTypes, HistoryOrders().getOrdersNumber())
                .clickBuySide()
                .verifyTradesAreUpdated(sizeTradesAllTypes, HistoryOrders().getOrdersNumber());
    }

    @TestCaseId("TC_History_Trades_006")
    @Description("search trades by id")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test6FindNotificationById() throws Exception {
        HistoryTrades()
                .enterId(HistoryTrades().getId())
                .verifyTradesSize(1)
                .clearId()
                .verifyTradesAreUpdated(0, HistoryTrades().getTradesNumber());
    }

}
