package tests.widgets;

import data.ChangeInstrument;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.util.Date;

import static data.LoggedUserData.*;


public class ManageWidgetsTest extends BaseTestWithBrowserRetention {

    String boardName = Long.toString(new Date().getTime());

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);
        STEDashboardPage().closeAllTabs();
    }

    @BeforeMethod
    public void beforeEach() {
        sleep(1000);
        STEDashboardPage()
                .addNewBoard(boardName)
                .clickAddWidgetButton();
    }

    @AfterMethod
    public void after() {
        STEDashboardPage()
                .closeSelectedBoard();
    }

    @TestCaseId("TC_Widget_001")
    @Description("Verify adding/resizing/moving/removing Ticket widget")
    @Features("Stone Edge Trading Widgets")
    @Test()
    public void test1TicketWidget() throws Exception {
        AddWidgetPopUp()
                .clickTicketWidgetButton()
                .selectInstrument(ChangeInstrument.pathFxAlfaAUDCHF1, null);

        AddWidgetPopUp().clickAddWidgetPopUpButton();

        TicketWidget()
                .verifyTicketWidgetPresent();

//        STEDashboardPage()
//                .verifyWidgetCanBeMoved(100, 100);

        TicketWidget().clickCloseButton();
    }


    @TestCaseId("TC_Widget_002")
    @Description("Verify adding/resizing/moving/removing Chart widget")
    @Features("Stone Edge Trading Widgets")
    @Test(enabled = false)//TODO enable after chart will be fixed
    public void test2ChartWidget() throws Exception {
        AddWidgetPopUp()
                .clickChartWidgetButton()
                .selectInstrument(ChangeInstrument.pathFxAlfaAUDCHF1, null);

        AddWidgetPopUp().clickAddWidgetPopUpButton();

        ChartWidget().verifyChartTitleIsPresent();
        STEDashboardPage()
                .verifyWidgetCanBeMoved(-100, -100)
                .verifyWidgetCanBeResized();
        ChartWidget().clickCloseButton();
    }

    @TestCaseId("TC_Widget_003")
    @Description("Verify adding/resizing/moving/removing Market depth widget")
    @Features("Stone Edge Trading Widgets")
    @Test()
    public void test3MarketDepthWidget() throws Exception {
        AddWidgetPopUp()
                .clickMarketDepthWidgetButton()
                .selectInstrument(ChangeInstrument.pathFxAlfaAUDCHF1, null);

        AddWidgetPopUp().clickAddWidgetPopUpButton();

        MarketDepthWidget().verifyMarketDepthWidgetPresent();
        STEDashboardPage()
                .verifyWidgetCanBeMoved(100, 100);
        MarketDepthWidget().clickTitle();
                //.verifyWidgetCanBeResized();
        MarketDepthWidget().clickCloseButton();
    }

    @TestCaseId("TC_Widget_004")
    @Description("Verify adding/resizing/moving/removing News widget")
    @Features("Stone Edge Trading Widgets")
    @Test()
    public void test4NewsWidget() throws Exception {
        AddWidgetPopUp()
                .clickNewsWidgetButton()
                .clickAddWidgetPopUpButton();

        NewsWidget().verifyNewsWidgetPresent();
        STEDashboardPage()
                .verifyWidgetCanBeMoved(-100, -100)
                .verifyWidgetCanBeResized();
        NewsWidget().clickCloseButton();
    }

    @TestCaseId("TC_Widget_005")
    @Description("Verify adding/resizing/moving/removing Watchlist widget")
    @Features("Stone Edge Trading Widgets")
    @Test()
    public void test5WatchlistWidget() throws Exception {
        AddWidgetPopUp()
                .clickWatchlistWidgetButton()
                .clickAddWidgetPopUpButton();

        WatchlistWidget().verifyWatchlistWidgetPresent();
        STEDashboardPage()
                .verifyWidgetCanBeMoved(-200, 200)
                .verifyWidgetCanBeResized();
        WatchlistWidget().clickCloseButton();
    }

    @TestCaseId("TC_Widget_006")
    @Description("Verify adding/resizing/moving/removing Positions And Orders widget")
    @Features("Stone Edge Trading Widgets")
    @Test()
    public void test6PositionsAndOrdersWidget() throws Exception {
        AddWidgetPopUp()
                .clickPositionsAndOrdersWidgetButton()
                .clickAddWidgetPopUpButton();

        PositionsAndOrdersWidget().verifyPositionsAndOrdersWidgetPresent();
        STEDashboardPage()
                .verifyWidgetCanBeMoved(100, -100)
                .verifyWidgetCanBeResized();
        PositionsAndOrdersWidget().clickCloseButton();

    }
}

