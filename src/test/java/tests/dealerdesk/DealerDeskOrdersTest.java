package tests.dealerdesk;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.LoggedUserData.defaultPassword;
import static data.LoggedUserData.defaultVerificationCode;
import static data.LoggedUserData.userPhone5;

public class DealerDeskOrdersTest extends BaseTestWithBrowserRetention {

    private boolean verifyFilter = false;

    @BeforeClass
    public void login() {
        STELoginPage()
                .quickLoginOnDealerDesk(userPhone5, defaultPassword);
        sleep(6000);
        DealerDeskOrders()
                .clickOnOrdersLink();
    }

    @TestCaseId("TC_Dealer_Desk_Orders_Tab_001")
    @Description("Verify column switcher on orders link")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test1EnablingDisablingColumns() throws Exception {
        DealerDeskOrders()
                .clickOnOwnTab()
                .verifyColumnSwitcher();
    }

    @TestCaseId("TC_Dealer_Desk_Orders_Tab_002")
    @Description("Verify order type filter")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test2OrderType() throws Exception {
        verifyFilter = true;
        DealerDeskOrders()
                .clickOnOwnTab();
        sleep(1000);
        int ordersSizeBefore = DealerDeskDashboard().getSize();
        DealerDeskOrders()
                .clickOrderTypeList()
                .clickOnMarketType();
        sleep(1000);
        int ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickOrderTypeList()
                .clickOnLimitType();
        sleep(1000);
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickOrderTypeList()
                .clickOnStopType();
        sleep(1000);
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickOrderTypeList()
                .clickOnStopLimitType();
        sleep(1000);
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
    }

    @TestCaseId("TC_Dealer_Desk_Orders_Tab_003")
    @Description("Verify side type filter")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test3SideType() throws Exception {
        verifyFilter = true;
        DealerDeskOrders()
                .clickOnOwnTab();
        int ordersSizeBefore = DealerDeskDashboard().getSize();
        DealerDeskOrders()
                .clickSideTypeList()
                .clickOnBuyType();
        int ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickSideTypeList()
                .clickOnSellType();
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);

    }

    @TestCaseId("TC_Dealer_Desk_Orders_Tab_004")
    @Description("Verify Time in force type filter")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test4TimeInForceType() throws Exception {
        verifyFilter = true;
        DealerDeskOrders()
                .clickOnOwnTab();
        sleep(1000);
        int ordersSizeBefore = DealerDeskDashboard().getSize();
        DealerDeskOrders()
                .clickTimeInForceTypeList()
                .clickOnFillOrKillType();
        sleep(1000);
        int ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickTimeInForceTypeList()
                .clickOnGTCType();
        sleep(1000);
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickTimeInForceTypeList()
                .clickOnDayType();
        sleep(1000);
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
        DealerDeskOrders()
                .clickCloseType()
                .clickTimeInForceTypeList()
                .clickOnIOCType();
        sleep(1000);
        ordersSizeAfter = DealerDeskDashboard().getSize();
        Assert.assertNotEquals(ordersSizeBefore, ordersSizeAfter);
    }

    @TestCaseId("TC_Dealer_Desk_Orders_Tab_005")
    @Description("Verify pagination on orders tab")
    @Features("Stone Edge Trading Trading board")
    @Test(enabled = false)
    public void test5VerifyPagination() throws Exception {
        DealerDeskOrders()
                .clickOnOwnTab()
                .verifyPagination();
    }

    @TestCaseId("TC_Dealer_Desk_Orders_Tab_006")
    @Description("Verify pagination on orders tab")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void test6CancelOrder() throws Exception { //TODO click cancel and verify status has changed
        DealerDeskOrders()
                .clickOnOwnTab()
                .clickCancelOrderButton()
                .clickCancelPopupButton();
    }

    @AfterMethod
    public void after() {
        if (verifyFilter)
            DealerDeskOrders()
                    .clickCloseType();
        verifyFilter = false;
    }

}
