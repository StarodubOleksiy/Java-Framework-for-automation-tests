package tests;

import data.ChangeInstrument;
import data.RegistrationInfo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Random;

import static data.LoggedUserData.*;

public class InstrumentsTest extends BaseTestWithBrowserRetention {

    private final static String amount = "100";
    private final static String price = "10";
    private static final String dataWindowName = "ticket";
    private final static String instrumentBO = ChangeInstrument.item_MGS_5_8_Aug_2021;
    private final static String instrumentEQ = ChangeInstrument.itemCAPCLSE;
    private final static String instrumentFU = ChangeInstrument.item_RTS_FORTS_H2019;
    private final static String instrumentFX = ChangeInstrument.itemAUDCHF;

    RegistrationInfo registrationInfo = new RegistrationInfo();

    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLogin(userPhone2, defaultPassword, defaultVerificationCode);
        WatchlistWidget()
                .clickWatchlistWidgetHeader()
                .clickMakeAnOrderOnLastInstrument();
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .clickTrainingBoardButton();
        WatchlistWidget()
                .verifyWatchlistWidgetPresent()
                .clickFirstTab()
                .clickMakeAnOrder();
        sleep(3000);
        TicketWidget().verifyTicketWidgetPresent();

        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("I.O.C")
                .clickOnManualButton()
                .clickBuyButton()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, instrumentBO);
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clickOnDuration()
                .selectDuration("Fill or kill");
        sleep(2000);
        TicketWidget()
                .clickBuyButton();
        sleep(10000);
        TicketWidget()
                .clickChangeInstruments();

        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, instrumentEQ);
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clickOnDuration()
                .selectDuration("Day")
                .clickBuyButton();

        sleep(10000);
        TicketWidget()
                .clickCloseButton();
        OrdersWidget()
                .clickOnOrdersHeader();
    }


    @TestCaseId("TC_Instrument_001")
    @Description("Verify instrument  of EQ exchange which is on order widget")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void verifyEqInstrument() throws Exception {
        Random rand = new Random();
        int randomAmount = rand.nextInt(100) + 1;
        int randomPrice = rand.nextInt(100) + 1;
        String message = registrationInfo.getReason();
        OrdersWidget()
                .editCurrentOrder(instrumentEQ);
        EditOrderRequestPopUpWindow()
                .verifyFieldsOnEditOrderRequestEQ(instrumentEQ)
                .clickEditBuyOrderButton();
    }

    @TestCaseId("TC_Instrument_002")
    @Description("Verify instrument  of BO exchange which is on order widget")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test
    public void verifyBoInstrument() throws Exception {
        Random rand = new Random();
        int randomAmount = rand.nextInt(1000) + 1;
        String message = registrationInfo.getReason();
        OrdersWidget()
                .editCurrentOrder(instrumentBO);
        EditOrderRequestPopUpWindow()
                .verifyFieldsOnEditOrderRequest(instrumentBO)
                .clearAmountField()
                .isEditBuyOrderButtonDisabled()
                .enterAmount(String.valueOf(randomAmount))
                .clickEditBuyOrderButton();
        sleep(2000);
        OrdersWidget()
                .clickChatButton(instrumentBO);
        ChatOrderRequestPopUpWindow()
                .verifyFieldsOnChatOrderRequest(instrumentBO)
                .clearMessageField()
                .isSendButtonDisabled()
                .enterMessage(message)
                .clickSendButton()
                .verifyMessageAppearedOnChatArea(message)
                .clickCancelWindow();
    }

    @TestCaseId("TC_Instrument_003")
    @Description("Verify instrument  of FU exchange which is on order widget")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test(enabled = false)
    public void verifyFuInstrument() throws Exception {
        Random rand = new Random();
        int randomAmount = rand.nextInt(1000) + 1;
        int randomPrice = rand.nextInt(100) + 1;
        String message = registrationInfo.getReason();
        OrdersWidget()
                .editCurrentOrder(instrumentFU);
        EditOrderRequestPopUpWindow()
                .verifyFieldsOnEditOrderRequestEQ(instrumentFU)
                .clickEditBuyOrderButton();
    }

    @TestCaseId("TC_Instrument_004")
    @Description("Verify instrument of FX exchange which is on order widget")
    @Features("Stone Edge Trading positions and orders widget page")
    @Test()
    public void verifyFxInstrument() throws Exception {
        Random rand = new Random();
        int randomAmount = rand.nextInt(1000) + 1;
        int randomPrice = rand.nextInt(100) + 1;
        OrdersWidget()
                .editCurrentOrder(instrumentFX);
        EditOrderRequestPopUpWindow()
                .verifyFieldsOnEditOrderRequest(instrumentFX)
                .clickEditBuyOrderButton();
    }


    @AfterClass
    public void cancelOrders() throws Exception {
        sleep(2000);
        OrdersWidget()
                .clickOnOrdersHeader()
                .closeAllOrders();
    }

}



