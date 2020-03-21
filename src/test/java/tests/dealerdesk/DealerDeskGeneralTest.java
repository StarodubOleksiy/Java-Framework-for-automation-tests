package tests.dealerdesk;

import data.ChangeInstrument;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.pages.StoneEdgeTradingDashboard;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static data.LoggedUserData.defaultPassword;
import static data.LoggedUserData.userPhone5;

public class DealerDeskGeneralTest extends BaseTestWithBrowserRetention {

    private static final String dataWindowName = "ticket";
    private final static String amount = "100";

    @BeforeClass
    public void login() {
        STELoginPage()
                .quickLoginOnDealerDesk(userPhone5, defaultPassword);
        sleep(6000);
    }

    @BeforeMethod
    public void before() {
        DealerDeskDashboard()
                .clickOnAccounts();
    }

    @TestCaseId("TC_Dealer_General_Desk_001")
    @Description("Test setting button")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test1SettingButton() throws Exception {
        DealerDeskAccounts()
                .clickSettingButton();
        SettingsPage()
                .verifySettingWindow()
                .clickCancelIcon();
    }

    @TestCaseId("TC_Dealer_General_Desk_002")
    @Description("Test change accounts button")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test2ChangeAccountButton() throws Exception {
        DealerDeskAccounts().clickSettingButton();
        String firstName = SettingsPage().getFirstName();
        String lastName = SettingsPage().getLastName();
        SettingsPage().clickCancelIcon();
        DealerDeskAccounts().clickChangeAccountButton();
        Assert.assertTrue(DealerDeskAccounts().getFirstLastName().contains(firstName));
        Assert.assertTrue(DealerDeskAccounts().getFirstLastName().contains(lastName));
        STELoginPage().clickDealerDeskMember();
    }

    @TestCaseId("TC_Dealer_General_Desk_003")
    @Description("Test notification button")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test3NotificationButton() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        DealerDeskAccounts()
                .clickOnViewButton();
        TicketWidget()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDJPY);
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickSellButton()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDCHF);
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickSellButton()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemEURUSD);
        TicketWidget()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession(amount)
                .selectDuration("Fill or kill")
                .clickSellButton();
        DealerDeskAccounts()
                .clickOnAccountsLink();
        DealerDeskAccounts()
                .clickNotificationButton()
                .verifyNotificationDate(text)
                .clickOKButton();
    }

    @TestCaseId("TC_Dealer_General_Desk_004")
    @Description("Test Log out button")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test4LogOutButton() throws Exception {
        DealerDeskAccounts()
                .clickLogOutButton();
        sleep(2000);
        STELoginPage()
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .clickDealerDeskMember();
    }
}
