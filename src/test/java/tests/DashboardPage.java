package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.Date;
import java.util.List;

import static data.LoggedUserData.*;


public class DashboardPage extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);
        sleep(6000);
        STEDashboardPage().closeAllTabs();

    }

    @TestCaseId("TC_Dashboard_001")
    @Description("Verify if variables are changed when several orders are different on trading board when ticket limit is sold")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void checking1VariablesOnTradingBoardWhenTicketIsSold() throws Exception {
        List<WebElement> firstVariablesList = STEDashboardPage().getVariablesList();
        TicketWidget()
                .verifyTicketWidgetPresent()
                .makeTicketWidgetVisible()
//                .specifyTicket("Limit")
//                .specifyTicket("Limit")//I have added this line because very often it switchs to tab market again after limit
//                .clearAmountField()
//                .enterAmount("100")
//                .selectDuration("G.T.C.")
//                .clearPriceField()
//                .enterPrice("10")
//                .clickSellOrderButton();
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession("100")
                .selectDuration("Fill or kill")
                .clickSellButton();
        STEDashboardPage().checkingVariablesAreSameOnTradingBoard(firstVariablesList);
    }

    @TestCaseId("TC_Dashboard_002")
    @Description("Verify if variables are changed when several orders are different on trading board when ticket limit is bought")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void checking2VariablesOnTradingBoardWhenTicketIsBought() throws Exception {
        List<WebElement> firstVariablesList = STEDashboardPage().getVariablesList();
        TicketWidget()
                .verifyTicketWidgetPresent()
                .makeTicketWidgetVisible()
//                .specifyTicket("Limit")
//                .specifyTicket("Limit")//I have added this line because very often it switchs to tab market again after limit
//                .clearAmountField()
//                .enterAmount("100")
//                .selectDuration("G.T.C.")
//                .clearPriceField()
//                .enterPrice("10")
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession("100")
                .selectDuration("Fill or kill")
                .clickBuyButton();
        STEDashboardPage().checkingVariablesAreSameOnTradingBoard(firstVariablesList);
    }

    @TestCaseId("TC_Dashboard_003")
    @Description("Verify notifications trading board")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void checking3NotificationsOnTradingBoard() throws Exception {
        TicketWidget()
                .verifyTicketWidgetPresent()
                .makeTicketWidgetVisible()
                .specifyTicket("Market")
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession("100")
                .selectDuration("Fill or kill")
                .clickSellButton()
                .clearAmountOnMarketSession()
                .enterAmountOnMarketSession("100")
                .selectDuration("I.O.C");

        sleep(2000);

        TicketWidget().clickBuyButton();

        sleep(7000); //This line is required because pop up message appears in top right corner.
        STEDashboardPage()
                .clickOnNotificationsButton()
                .clickOnNotificationsOkButton()
                .clickOnNotificationsButton()
                .verifyIfNotificationsOkButtonIsNotPresent()
                .clickOnNotificationsButton();
    }

    @TestCaseId("TC_Dashboard_004")
    @Description("Verify adding/renaming/removing tabs on dashboard in Stone Edge Trading application")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test4Tabs() {
        String tabName = Long.toString(new Date().getTime());
        String newTabName = tabName + "new";

        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .addNewBoard(tabName)
                .verifyBoardPresent(tabName)
                .renameActiveBoard("new")
                .verifyBoardPresent(newTabName)
                .closeSelectedBoard()
                .verifyBoardNotPresent(newTabName);
    }

    @TestCaseId("TC_Dashboard_005")
    @Description("Verify if fields are present on trading board")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test5VerifyFieldsOnTradingBoard() {
        STEDashboardPage().verifyFieldsOnTradingBoard();
    }


    @TestCaseId("TC_Dashboard_006")
    @Description("Verify adding boards limit")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test6AddBoardLimit() {
        for (int i = 0; i < 4; ++i)
            STEDashboardPage()
                    .addNewBoard(String.valueOf(i));
        STEDashboardPage()
                .checkAddBoardButtonNotPresent();
    }

    @TestCaseId("TC_Dashboard_007")
    @Description("Verify adding/renaming/removing tabs on dashboard in Stone Edge Trading application")
    @Features("Stone Edge Trading Dashboard page")
    @Test(enabled = false) //TODO enable after fix
    public void test7ExpandCollapse() {
        STEDashboardPage().clickHideHeader();
        Assert.assertFalse(STEDashboardPage().isHeaderVisible());

        STEDashboardPage().clickShowHeader();
        Assert.assertTrue(STEDashboardPage().isHeaderVisible());
    }

    @AfterClass
    public void cleanUp() {
        if (!STEDashboardPage().isHeaderVisible())
            STEDashboardPage().clickShowHeader();

        STEDashboardPage().closeAllTabs();
    }

}
