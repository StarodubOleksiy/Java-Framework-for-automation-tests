package tests;

import data.ChangeInstrument;
import data.NotificationTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static data.LoggedUserData.*;

public class BuySell extends BaseTestWithBrowserRetention {

    private final static String amount = "100";

    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);
        sleep(6000);
    }

    @TestCaseId("TC_BuySell_001")
    @Description("Verify successful buy sell flow on Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSuccessfulBuySellFlow() throws Exception {
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard();
        WatchlistWidget().verifyWatchlistWidgetPresent();
        OrdersWidget().verifyOrdersWidgetTitleIsPresent();

        WatchlistWidget().clickFirstTab();

        WatchlistWidget().verifyWatchlistWidgetPresent()
                .clickFirstTab()
                .clickMakeAnOrder();

        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(TicketWidget().getCurrentInstrument());

        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("I.O.C")
                //   .clickOnAutomaticButton()
                .clickOnManualButton()
                .clickSellButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST , expectedMessage.toString());

        OrdersWidget().clickHeader()
                .verifyNewPosition(ChangeInstrument.itemAUDCHF);
    }
}
