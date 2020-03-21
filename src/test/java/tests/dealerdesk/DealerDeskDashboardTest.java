package tests.dealerdesk;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.util.Date;

import static data.LoggedUserData.defaultPassword;
import static data.LoggedUserData.userPhone5;

public class DealerDeskDashboardTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage()
                .quickLoginOnDealerDesk(userPhone5, defaultPassword);
        sleep(6000);
    }

    @TestCaseId("TC_Dealer_Desk_Dashboard_001")
    @Description("Test create a new board and delete it")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testCreateDeleteBoard() throws Exception {
        String boardName = Long.toString(new Date().getTime());
        DealerDeskDashboard()
                .clickOnSaveAsANewBoardButton()
                .enterNameOfNewBoard(boardName)
                .clickOnSaveButton()
                .isBoardPresent(boardName);
    }

    @TestCaseId("TC_Dealer_Desk_Dashboard_002")
    @Description("Test edit board")
    @Features("Stone Edge Trading Trading board")
    @Test
    public void testEditBoard() throws Exception {
        DealerDeskAccounts()
                .clickManagmentTypeList()
                .clickOnPortfolioManagementType();
        String filter = DealerDeskDashboard().getFilterText();
        String boardName = Long.toString(new Date().getTime());
        DealerDeskDashboard()
                .clickOnSaveAsANewBoardButton()
                .enterNameOfNewBoard(boardName)
                .clickOnSaveButton()
                .clickOnNewBoard(boardName)
                .isFilterPresent(filter);
        DealerDeskAccounts()
                .clickCloseType()
                .clickManagmentTypeList()
                .clickOnCurrentType();
        DealerDeskDashboard()
                .clickOnSaveBoardButton();
        filter = DealerDeskDashboard().getFilterText();
        DealerDeskAccounts()
                .clickOnOwnTab();
        DealerDeskDashboard()
                .clickOnNewBoard(boardName)
                .isFilterPresent(filter);
    }

    @AfterClass
    public void after() {
        DealerDeskDashboard()
                .deleteAllBoards();
    }
}
