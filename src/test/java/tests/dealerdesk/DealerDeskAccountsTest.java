package tests.dealerdesk;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;


import static data.LoggedUserData.*;

public class DealerDeskAccountsTest extends BaseTestWithBrowserRetention {

    private boolean verifyFilter = false;

    @BeforeClass
    public void login() {
        STELoginPage()
                .quickLoginOnDealerDesk(userPhone5, defaultPassword);
        sleep(6000);
    }

    @TestCaseId("TC_Dealer_Desk_001")
    @Description("Verify management type filter")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testManagementType() throws Exception {
        verifyFilter = true;
        int accountSizeBefore = DealerDeskDashboard().getSize();

        DealerDeskAccounts()
                .clickManagmentTypeList()
                .clickOnCurrentType();
        sleep(1000);
        int accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickManagmentTypeList()
                .clickOnPortfolioManagementType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickManagmentTypeList()
                .clickOnBrokerageType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickManagmentTypeList()
                .clickOnClientBrokerageType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
    }

    @TestCaseId("TC_Dealer_Desk_002")
    @Description("Verify account type filter")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testAccountType() throws Exception {
        verifyFilter = true;
        int accountSizeBefore = DealerDeskDashboard().getSize();
        DealerDeskAccounts()
                .clickAccountTypeList()
                .clickOnRealType();
        sleep(1000);
        int accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickAccountTypeList()
                .clickOnPersonalType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickAccountTypeList()
                .clickOnNominalType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
    }

    @TestCaseId("TC_Dealer_Desk_003")
    @Description("Verify client profile filter")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testClientProfileType() throws Exception {
        verifyFilter = true;
        int accountSizeBefore = DealerDeskDashboard().getSize();

        DealerDeskAccounts()
                .clickClientProfileTypeList()
                .clickOnRetailType();
        sleep(1000);
        int accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickClientProfileTypeList()
                .clickOnProfessionalType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickClientProfileTypeList()
                .clickOnTestType();
        sleep(1000);
        accountSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(accountSizeBefore, accountSizeAfter);
    }


    @TestCaseId("TC_Dealer_Desk_004")
    @Description("Verify column switcher")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testEnablingDisablingColumns() throws Exception {
        DealerDeskAccounts()
                .verifyColumnSwitcher();
    }

    @TestCaseId("TC_Delear_Desk_005")
    @Description("Test account views")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testAccountViews() throws Exception {
        String accountName = DealerDeskAccounts().getAccountId();
        DealerDeskAccounts()
                .clickOnViewButton();
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .verifyAccount(accountName);
        DealerDeskAccounts()
                .clickOnAccountsLink();
    }

    @TestCaseId("TC_Delear_Desk_006")
    @Description("Test filter currency")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testFilterCurrency() throws Exception {
        DealerDeskAccounts()
                .clickUSDCurrency();
        String firstTotalAssert = DealerDeskAccounts().getTotalAssert();
        DealerDeskAccounts()
                .clickEURCurrency();
        String nextTotalAssert = DealerDeskAccounts().getTotalAssert();
        Assert.assertNotEquals(firstTotalAssert, nextTotalAssert);
        DealerDeskAccounts()
                .clickRUBCurrency();
        nextTotalAssert = DealerDeskAccounts().getTotalAssert();
        Assert.assertNotEquals(firstTotalAssert, nextTotalAssert);
        DealerDeskAccounts()
                .clickGBPCurrency();
        nextTotalAssert = DealerDeskAccounts().getTotalAssert();
        Assert.assertNotEquals(firstTotalAssert, nextTotalAssert);
    }


    @AfterMethod
    public void after() {
        DealerDeskDashboard().clickOnAccounts();

        if (verifyFilter) {
            DealerDeskAccounts()
                    .clickCloseType();
            verifyFilter = false;
        }
    }


}
