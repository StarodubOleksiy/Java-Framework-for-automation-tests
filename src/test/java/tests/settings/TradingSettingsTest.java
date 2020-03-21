package tests.settings;

import data.ChangeInstrument;
import data.Currency;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.Currency.*;
import static data.LoggedUserData.*;

public class TradingSettingsTest extends BaseTestWithBrowserRetention {


    Currency firstCurrency;
    boolean isMultiplierChanged = false;
    boolean isCurrencyChanged = false;
    boolean positionsCloseConfirmationChanged = false;

    private final static String amount = "100";


    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLoginOneAccount(userPhone4, defaultPassword, defaultVerificationCode);
        firstCurrency = Currency.getCurrency(STEDashboardPage().getCurrency());

        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .clickTrainingBoardButton();
        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append(amount).append(" ").append(ChangeInstrument.itemAUDCHF).append("(.*)").append("@");

        WatchlistWidget()
                .verifyWatchlistWidgetPresent()
                .clickFirstTab()
                .clickMakeAnOrder();

        TicketWidget().verifyTicketWidgetPresent();

        sleep(3000);

        TicketWidget()
                .specifyTicket("Limit")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("G.T.C")
                .clearPriceField()
                .enterPrice("500")
                .clickSellOrderButton();


    }

    @TestCaseId("TC_Trading_Setting_001")
    @Description("Test verification currency")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test1verifyCurrency() throws Exception {
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab();

        isCurrencyChanged = true;
        SettingsPage()
                .clickUSDCurrency()
                .clickCancelIcon();
        STEDashboardPage()
                .verifyCurrencyOnBoard(USD.toString())
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab()
                .clickEURCurrency()
                .clickCancelIcon();
        STEDashboardPage()
                .verifyCurrencyOnBoard(EUR.toString())
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab()
                .clickRUBCurrency()
                .clickCancelIcon();
        STEDashboardPage()
                .verifyCurrencyOnBoard(RUB.toString())
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab()
                .clickGBPCurrency()
                .clickCancelIcon();
        STEDashboardPage()
                .verifyCurrencyOnBoard(GBP.toString());
    }

    @TestCaseId("TC_Trading_Setting_002")
    @Description("Test verification trading amount setting")
    @Features("Stone Edge Trading Dashboard page")
    @Test(enabled = false)//Trading amount input fields do not clears and changes.
    public void test2verifyTradingAmounts() throws Exception {
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab();

        SettingsPage()
                .clearTradingAmount(0)
                .enterTradingAmount(0, "7")
                .verifyTradingAmount(0, "7")
                .clickCancelIcon();
        WatchlistWidget()
                .setAmountOnInstrument("7");
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab()
                .clearTradingAmount(0)
                .enterTradingAmount(0, "1")
                .verifyTradingAmount(0, "1")
                .clearTradingAmount(6)
                .enterTradingAmount(6, "800000000")
                .verifyTradingAmount(6, "800M")
                .clickCancelIcon();
        WatchlistWidget()
                .setAmountOnInstrument("800M");
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab()
                .clearTradingAmount(6)
                .enterTradingAmount(6, "100000000");
    }

    @TestCaseId("TC_Trading_Setting_003")
    @Description("Test trading multipliers")
    @Features("Stone Edge Trading Dashboard page")
    @Test
    public void test3verifyTradingMultipliers() {
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab();
        isMultiplierChanged = true;
        for (int i = 1; i < 6; ++i)
            SettingsPage()
                    .selectTradingMultiplier("1K", i);
        SettingsPage()
                .clickCancelIcon();
        WatchlistWidget().verifyAmountSpan("1K");
        sleep(4000);
          }


    @TestCaseId("TC_Trading_Setting_004")
    @Description("Test close confirmation switcher")
    @Features("Stone Edge Trading Dashboard page")
    @Test
    public void test4verifyPositionsCloseConfirmation() throws Exception {
        positionsCloseConfirmationChanged = true;
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab();
        boolean isPositionCloseConfirmationSwitchedOn = SettingsPage().isPositionCloseConfirmationSwitchedOn();
        SettingsPage()
                .clickCloseConfirmationSwitcher()
                .clickCancelIcon();
        TicketWidget()
                .makeTicketWidgetVisible()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession("100")
                .selectDuration("I.O.C")
                .clickBuyButton();
        OrdersWidget()
                .clickHeader();
        if (isPositionCloseConfirmationSwitchedOn) {
            PositionsWidget()
                    .clickOnPositionsButton()
                    .clickOnCloseButton();
        } else {
            PositionsWidget()
                    .clickOnPositionsButton()
                    .clickOnCloseButton()
                    .clickOnCloseButtonPopUpWindow();
        }
        sleep(8000);
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickTradingTab();
    }

    @AfterClass
    public void after() {
        if (isMultiplierChanged) {
            for (int i = 1; i < 6; ++i)
                SettingsPage()
                        .selectTradingMultiplier("1M", i);
            isMultiplierChanged = false;
        }
        if (isCurrencyChanged) {
            switch (firstCurrency) {
                case USD:
                    SettingsPage()
                            .clickUSDCurrency();
                    break;
                case EUR:
                    SettingsPage()
                            .clickEURCurrency();
                    break;
                case RUB:
                    SettingsPage()
                            .clickRUBCurrency();
                    break;
                default:
                    SettingsPage()
                            .clickGBPCurrency();
                    break;
            }
            isCurrencyChanged = false;
        }
        if (positionsCloseConfirmationChanged) {
            SettingsPage()
                    .clickCloseConfirmationSwitcher();
            positionsCloseConfirmationChanged = false;
        }
    }


}
