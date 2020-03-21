package tests.widgets;

import data.ChangeInstrument;
import data.NotificationTitle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.LoggedUserData.*;

public class PositionsAndOrdersWidgetTest extends BaseTestWithBrowserRetention {

    private final static String amount = "100";
    private final static String price = "10";

    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLoginOneAccount(userPhone6, defaultPassword, defaultVerificationCode);
        sleep(6000);
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .clickTrainingBoardButton();
        StringBuilder expectedMessage1 = new StringBuilder();
        expectedMessage1.append(amount).append(" ").append(ChangeInstrument.itemAUDCHF);

        StringBuilder expectedMessage2 = new StringBuilder();
        expectedMessage2.append(amount).append(" ").append(ChangeInstrument.itemAUDJPY);

        WatchlistWidget()
                .verifyWatchlistWidgetPresent()
                .clickFirstTab()
                .clickMakeAnOrder();
        sleep(500);

        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                //.clickOnAutomaticButton()
                .clickOnManualButton()
                .clickBuyButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage1.toString());
        sleep(2000);

        WatchlistWidget().clickFirstTab()
                .clickMakeAnOrder();
        sleep(500);

        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickOnAnyButton()
                // .clickOnManualButton()
                .clickBuyButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage1.toString());
        sleep(2000);

        WatchlistWidget()
                .clickFirstTab()
                .clickMakeAnOrderOnLastInstrument();
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("I.O.C")
                // .clickOnAutomaticButton()
                .clickOnManualButton()
                .clickBuyButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage2.toString());

        WatchlistWidget()
                .clickFirstTab()
                .clickMakeAnOrderOnLastInstrument();

        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("I.O.C")
                .clickOnAnyButton()
                //  .clickOnManualButton()
                .clickBuyButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage2.toString());

        sleep(8000);
        TicketWidget().clickCloseButton();
    }


    @TestCaseId("TC_PositionsOrdersWidget_001")
    @Description("Verify if positions widget is present on trading board")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test11PositionsWidget() throws Exception {
        OrdersWidget().clickHeader();
        PositionsWidget()
                .clickOnPositionsButton()
                .verifyPositionsWidgetIsPresent();
    }

    @TestCaseId("TC_PositionsOrdersWidget_002")
    @Description("Verify if orders widget is present on trading board")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test12OrdersWidget() throws Exception {
        OrdersWidget()
                .clickOnOrdersHeader()
                .verifyOrdersWidgetIsPresent();
    }

    @TestCaseId("TC_PositionsOrdersWidget_003")
    @Description("Verify close position")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test13ClosePosition() throws Exception {
        OrdersWidget().clickHeader();
        PositionsWidget()
                .clickOnPositionsButton()
                .clickOnCloseButton()
                .verifyClosePositionPopUpWindow()
                .clickOnCancelButtonPopUpWindow();
    }

    @TestCaseId("TC_PositionsOrdersWidget_004")
    @Description("Verify edit order")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test14EditOrders() throws Exception {
        OrdersWidget()
                .clickHeader()
                .clickOnOrdersHeader()
                .clickOnEditButton();
        EditOrderRequestPopUpWindow()
//                .verifyOrderTicketPopUpWindow()
//                .clearAmountField()
//                .clearPriceField()
//                .verifyIfButtonEditOrderIsDisabled()
//                .enterAmount("50")
//                .verifyIfButtonEditOrderIsDisabled()
//                .clearAmountField()
//                .enterPrice("20")
//                .verifyIfButtonEditOrderIsDisabled()
//                .enterAmount("50")
                .clickEditBuyOrderButton();
//                .verifyEditOrderMessageAppeared("Order was updated");
    }

    @TestCaseId("TC_PositionsOrdersWidget_005")
    @Description("Verify sorting positions")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test15PositionListSorting() throws Exception {
        PositionsWidget()
                .clickOnPositionsButton()
                .verifyPositionSorting();
    }

    @TestCaseId("TC_PositionsOrdersWidget_006")
    @Description("Verify switcher (+FX/-FX) positions rows on positions widget")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test16PositionsSwitcherForColumns() throws Exception {
        PositionsWidget()
                .clickOnPositionsButton()
                .verifyPositionsColumnOpenButton();
    }

    @TestCaseId("TC_PositionsOrdersWidget_007")
    @Description("Verify column switcher")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void test17SwitcherForColumns() throws Exception {
        PositionsWidget()
                .verifyColumnSwitcher();
    }

}
