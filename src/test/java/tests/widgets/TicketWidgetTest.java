package tests.widgets;

import data.ChangeInstrument;
import data.NotificationTitle;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.util.Date;

import static data.LoggedUserData.*;

public class TicketWidgetTest extends BaseTestWithBrowserRetention {
    private final static String amount = "100";
    private final static String price = "10";
    private final static String minimalPrice = "0.1";
    private static final String dataWindowName = "ticket";
    private static String currentInstrument;
    String boardName = Long.toString(new Date().getTime());

    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);
        sleep(6000);
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .clickTrainingBoardButton();
        STEDashboardPage()
                .addNewBoard(boardName)
                .clickAddWidgetButton();
        currentInstrument = ChangeInstrument.itemAUDCHF;
        AddWidgetPopUp()
                .clickTicketWidgetButton()
                .selectInstrument(ChangeInstrument.findPathToItem.get(currentInstrument), null);
        AddWidgetPopUp().clickAddWidgetPopUpButton();
    }

    @TestCaseId("TC_TicketWidget_001")
    @Description("Verify buy ticket on tab Market")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test01ManualMarketIOCSell() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(TicketWidget().getCurrentInstrument());
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("I.O.C")
                .clickOnManualButton()
                .clickSellButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_002")
    @Description("Verify sell ticket on tab Market")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test02ManualMarketFillOrKillSell() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("-").append(amount).append(" ").append(ChangeInstrument.itemAUDCHFDesc);
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickOnManualButton()
                .clickSellButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_003")
    @Description("Verify buy ticket on tab Market")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test03ManualMarketDayBuy() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(ChangeInstrument.itemAUDCHFDesc);
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Day")
                .clickOnManualButton()
                .clickBuyButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_004")
    @Description("Verify buy order on tab Limit")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test04ManualLimitIOCBuy() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(TicketWidget().getCurrentInstrument());
        TicketWidget()
                .specifyTicket("Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clickOnDuration()
                .selectDuration("I.O.C.")
                .clearPriceField()
                .enterPrice(price)
                .clickOnManualButton()
                .clickBuyOrderButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_005")
    @Description("Verify buy order on tab Market")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test05ManualLimitFillOrKillSell() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("-").append(amount).append(" ").append(ChangeInstrument.itemAUDCHFDesc).append("@").append(minimalPrice);
        TicketWidget()
                .specifyTicket("Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clickOnDuration()
                .selectDuration("Fill or kill")
                .clearPriceField()
                .enterPrice(minimalPrice)
                .clickOnManualButton()
                .clickSellOrderButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_006")
    @Description("Verify buy order on tab Market")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test06ManualLimitDaySell() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(ChangeInstrument.itemAUDCHFDesc).append("@").append(price);
        TicketWidget()
                .specifyTicket("Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Day")
                .clearPriceField()
                .enterPrice(price)
                .clickOnManualButton()
                .clickSellOrderButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_007")
    @Description("Verify buy order on tab Market")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test07ManualLimitGTCBuy() throws Exception {
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(ChangeInstrument.itemAUDCHFDesc).append("@").append(price);
        TicketWidget()
                .specifyTicket("Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("G.T.C.")
                .clearPriceField()
                .enterPrice(price)
                .clickOnManualButton()
                .clickBuyOrderButton()
                .verifyTicketMessageAppeared(NotificationTitle.ORDER_REQUEST, expectedMessage.toString());
    }

    @TestCaseId("TC_TicketWidget_008")
    @Description("Verify buy ticket on tab Stop duration I.O.C")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test08StopIOCBuy() throws Exception {
        TicketWidget()
                .specifyTicket("Stop")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(price)
                .selectDuration("I.O.C.")
                .clickBuyButton();
    }

    @TestCaseId("TC_TicketWidget_009")
    @Description("Verify sell ticket on tab Stop")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test09StopFillOrKillSell() throws Exception {
        TicketWidget()
                .specifyTicket("Stop")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(price)
                .selectDuration("Fill or kill")
                .clickSellButton();
    }

    @TestCaseId("TC_TicketWidget_010")
    @Description("Verify sell ticket on tab Stop duration Day")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test10StopDaySell() throws Exception {
        TicketWidget()
                .specifyTicket("Stop")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(price)
                .selectDuration("Day")
                .clickSellButton();
    }

    @TestCaseId("TC_TicketWidget_011")
    @Description("Verify buy ticket on tab Stop")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test11StopGTCBuy() throws Exception {
        TicketWidget()
                .specifyTicket("Stop")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(price)
                .selectDuration("G.T.C.")
                .clickBuyButton();
    }

    @TestCaseId("TC_TicketWidget_012")
    @Description("Verify buy ticket on tab Stop Limit")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test12TStopLimitIOCBuy() throws Exception {
        TicketWidget()
                .specifyTicket("Stop-Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(minimalPrice)
                .selectDuration("I.O.C.")
                .clearPriceField()
                .enterPrice(price)
                .clickBuyButton();
    }


    @TestCaseId("TC_TicketWidget_013")
    @Description("Verify sell ticket on tab Stop Limit")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test13StopLimitFillOrKillSell() throws Exception {
        TicketWidget()
                .specifyTicket("Stop-Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(minimalPrice)
                .selectDuration("Fill or kill")
                .clearPriceField()
                .enterPrice(price)
                .clickSellButton();
    }


    @TestCaseId("TC_TicketWidget_014")
    @Description("Verify sell ticket on tab Stop Limit")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test14StopLimitDaySell() throws Exception {
        TicketWidget()
                .specifyTicket("Stop-Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(minimalPrice)
                .selectDuration("Day")
                .clearPriceField()
                .enterPrice(price)
                .clickSellButton();
    }

    @TestCaseId("TC_TicketWidget_015")
    @Description("Verify buy ticket on tab Stop Limit")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test15StopLimitGTCBuy() throws Exception {
        TicketWidget()
                .specifyTicket("Stop-Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .clearStopPriceField()
                .enterStopPrice(minimalPrice)
                .selectDuration("G.T.C.")
                .clearPriceField()
                .enterPrice(price)
                .clickBuyButton();
    }

    @TestCaseId("TC_TicketWidget_016")
    @Description("Verify ticket widget is present on trading board and how it works")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test16TicketWidgetOnTradingBoard() throws Exception {
        TicketWidget()
                .verifyTicketWidgetPresent()
                .verifyTicketWidgetWithDataPresent()
                .clickInstruments();
        ChangeInstrumentPopUp()
                .verifyInstrumentCard();
        Thread.sleep(1000);
        TicketWidget()
                .clickInstruments()
                .verifyIfComponentsButtonsPresentTabMarket()
                .verifyIfComponentsButtonsPresentTabLimit();
        ChangeInstrumentPopUp()
                .verifyInstrument(dataWindowName, currentInstrument);
    }

    @TestCaseId("TC_TicketWidget_017")
    @Description("Verify if buttons are disabled on market tab when field Amount is empty ")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test17TicketWidgetIfButtonsAreDisabledWhenAmountEmptyTabMarket() throws Exception {
        TicketWidget()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .verifyIfButtonsAreDisabled();
    }

    @TestCaseId("TC_TicketWidget_018")
    @Description("Verify if buttons are disabled on limit tab when field Price is empty ")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test18TicketWidgetIfButtonsAreDisabledWhenPriceEmptyTabLimit() throws Exception {
        TicketWidget()
                .specifyTicket("Limit")
                .clearPriceField()
                .verifyIfButtonsAreDisabled();
    }

    @TestCaseId("TC_TicketWidget_019")
    @Description("Verify if buttons are disabled on limit tab when field Amount is empty ")
    @Features("Stone Edge Trading ticket widget page")
    @Test
    public void test19TicketWidgetIfButtonsAreDisabledWhenAmountEmptyTabLimit() throws Exception {
        TicketWidget()
                .specifyTicket("Limit")
                .clearAmountOnMarketSession()
                .enterPrice("10")
                .verifyIfButtonsAreDisabled();
    }

    @TestCaseId("TC_Ticket_Widget_020")
    @Description("To change instruments on market depth widget")
    @Features("Stone Edge Trading widget ticket page")
    @Test()
    public void test20TicketWidgetOnTradingBoardChangeInstruments() throws Exception {
        TicketWidget()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDJPY)
                .verifyInstrument(dataWindowName, ChangeInstrument.itemAUDJPY);
    }


    @AfterClass
    public void closeBoard() throws Exception {
        STEDashboardPage()
                .closeSelectedBoard();
    }
}
