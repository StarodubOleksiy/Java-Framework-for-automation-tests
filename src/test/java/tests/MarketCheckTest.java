package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static data.LoggedUserData.*;

public class MarketCheckTest extends BaseTestWithBrowserRetention {


    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);
        sleep(6000);
        WatchlistWidget().clickMakeAnOrderOnLastInstrument();
    }

    @TestCaseId("TC_MarketCheck_001")
    @Description("Verify market is open on Stone Edge Trading application")
    @Features("Stone Edge Trading check market")
    @Test
    public void testMarketIsOpen() {
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard();

        TicketWidget().verifyTicketWidgetPresent()
                .verifyMarketIsOpen();
    }
}
