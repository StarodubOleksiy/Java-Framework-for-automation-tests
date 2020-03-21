package tests.widgets;

import data.ChangeInstrument;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.util.Date;

import static data.LoggedUserData.*;

public class WatchlistWidgetTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone3, defaultPassword, defaultVerificationCode)
                .clickTrainingBoardButton();
    }

    @TestCaseId("TC_WatchlistWidget_001")
    @Description("Verify watchlist widget is present on trading board and create/update of watchlist tabs")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test1WatchlistWidgetOnTradingBoard() {
        WatchlistWidget()
                .verifyWatchlistWidgetPresent()
                .clickNewWatchlist();

        CreateUpdateWatchlistPopUp()
                .enterWatchlistName(Long.toString(new Date().getTime()))
                .selectInstrument(ChangeInstrument.pathFxAlfaAUDCHF1, null);

        CreateUpdateWatchlistPopUp()
                .clickCreteUpdateWatchlistButton();
        sleep(3000);
        WatchlistWidget()
                .clickEditWatchlist();
        CreateUpdateWatchlistPopUp().enterWatchlistName("new")
                .clickCreteUpdateWatchlistButton();
        sleep(3000);
        WatchlistWidget()
                .clickDeleteWatchlist()
                .clickDeleteWatchlistConfirmation();
    }


    @TestCaseId("TC_WatchlistWidget_002")
    @Description("Verify making an order")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test2MakeAnOrder() throws Exception {
        WatchlistWidget()
                .clickFirstTab()
                .setAmountOnInstrument("4")
                .verifyWatchlistWidgetPresent()
                .clickMakeAnOrder();

        TicketWidget().verifyTicketWidgetPresent();
        STEDashboardPage().verifyExactWidgetCanBeMoved("ticket", -100, -100);
        TicketWidget().makeTicketWidgetVisible()
                .clickCloseButton();
    }

    @TestCaseId("TC_WatchlistWidget_003")
    @Description("Verify selecting Chart widget on Instrument menu")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test3InstrumentMenuChartWidget() throws Exception {
        WatchlistWidget()
                .clickFirstTab()
                .clickInstrumentMenu()
                .clickChartWidget();
        sleep(1000);

        ChartWidget().verifyChartTitleIsPresent();
        //    STEDashboardPage().verifyExactWidgetCanBeMoved("overview", -100, -100);
        // ChartWidget().clickCloseButton();
    }

    @TestCaseId("TC_WatchlistWidget_004")
    @Description("Verify selecting Market Depth widget on Instrument menu")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test4InstrumentMenuMarketDepthWidget() {
        WatchlistWidget()
                .clickFirstTab()
                .clickInstrumentMenu()
                .clickMarketDepthWidget();

        MarketDepthWidget().verifyMarketDepthWidgetPresent()
                .clickCloseButton();
    }

    @TestCaseId("TC_WatchlistWidget_005")
    @Description("Verify selecting Ticket widget on Instrument menu")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test5InstrumentMenuTicketWidget() throws Exception {
        WatchlistWidget()
                .clickFirstTab()
                .clickInstrumentMenu()
                .clickTicketWidget();

        TicketWidget().verifyTicketWidgetPresent();
        STEDashboardPage().verifyExactWidgetCanBeMoved("ticket", -100, -100);
        TicketWidget().clickCloseButton();
    }

    @TestCaseId("TC_WatchlistWidget_006")
    @Description("Verify amount switcher ")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test6SwitcherAmountWidget() {
        try {
            WatchlistWidget()
                    .verifyAmoutInputFieldIsPresentOnWatchlistWidget() //It is very likely that this method will throw a Exception
                    .clickAmountSwitcher()//If there is no amount field on switcher amount widget
                    .verifyAmountInputFieldIsNotPresentOnWatchListWidget();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            WatchlistWidget()
                    .clickAmountSwitcher()
                    .verifyAmoutInputFieldIsPresentOnWatchlistWidget()
                    .clickAmountSwitcher()
                    .verifyAmountInputFieldIsNotPresentOnWatchListWidget();
        }
    }

    @TestCaseId("TC_WatchlistWidget_007")
    @Description("Verify buttons list view and block view ")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test7ListAndBlockButtons() throws Exception {
        WatchlistWidget()
                .clickListView()
                .verifyMakeAnOrderButtonsAreNotPresentOnWatchListWidget()
                .clickBlockView()
                .verifyMakeAnOrderButtonsArePresentOnWatchListWidget();
    }

    @TestCaseId("TC_WatchlistWidget_008")
    @Description("Verify enter some number in amount input field ")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test8AmountInputField() {
        try {
            WatchlistWidget()
                    .verifyAmoutInputFieldIsPresentOnWatchlistWidget() //It is very likely that this method will throw a Exception
                    .clickAmountSwitcher()//If there is no amount field on switcher amount widget
                    .enterAmountInput("125")
                    .clickWatchlistWidgetHeader()
                    .verifySelectAmount("125")
                    .clickAmountSwitcher();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            WatchlistWidget()
                    .clickAmountSwitcher()
                    .enterAmountInput("125")
                    .clickWatchlistWidgetHeader()
                    .verifySelectAmount("125")
                    .clickAmountSwitcher();
        }
    }

    @TestCaseId("TC_WatchlistWidget_009")
    @Description("Verify Deletion of the instrument on watchist widget ")
    @Features("Stone Edge Trading Watchlist widget")
    @Test
    public void test9DeleteInstrumentOnWatchlistWidget() throws Exception {
        WatchlistWidget()
                .clickFirstTab()
                .clickEditWatchlist();

        CreateUpdateWatchlistPopUp()
                .selectInstrument(ChangeInstrument.findPathToItem.get(ChangeInstrument.itemCADJPY), null);
        CreateUpdateWatchlistPopUp()
                .clickCreteUpdateWatchlistButton();
        sleep(3000);
        WatchlistWidget()
                .deleteLastInstrument();
    }
}

