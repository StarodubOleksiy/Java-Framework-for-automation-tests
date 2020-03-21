package tests.widgets;

import data.ChangeInstrument;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.util.Date;

import static data.LoggedUserData.*;

public class MarketDepthWidgetTest extends BaseTestWithBrowserRetention {

    private static final String dataWindowName = "marketDepth";
    private static String currentInstrument;
    String boardName = Long.toString(new Date().getTime());

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode)
                .clickTrainingBoardButton();
        sleep(6000);
        STEDashboardPage()
                .addNewBoard(boardName)
                .clickAddWidgetButton();
        currentInstrument = ChangeInstrument.itemAUDCHF;
        AddWidgetPopUp()
                .clickMarketDepthWidgetButton()
                .selectInstrument(ChangeInstrument.findPathToItem.get(currentInstrument), null);
        AddWidgetPopUp().clickAddWidgetPopUpButton();
    }

    @TestCaseId("TC_MarketDepthWidget_001")
    @Description("Verify market depth widget is present on trading board and how it works")
    @Features("Stone Edge Trading widget market depth page")
    @Test
    public void testMarketDepthWidgetOnTradingBoard() throws Exception {
        MarketDepthWidget()
                .verifyMarketDepthWidgetPresent()
                .verifyMarketDepthContent()
                .clickInstruments();
        ChangeInstrumentPopUp()
                .verifyInstrumentCard();
        sleep(1000);
        MarketDepthWidget()
                .clickInstruments();
        ChangeInstrumentPopUp()
                .verifyInstrument(dataWindowName, currentInstrument);

    }

    @TestCaseId("TC_MarketDepthWidget_002")
    @Description("To change instruments on market depth widget")
    @Features("Stone Edge Trading widget market depth page")
    @Test()
    public void testMarketDepthWidgetOnTradingBoardChangeInstruments() throws Exception {
        MarketDepthWidget()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemUSDRUB)
                .verifyInstrument(dataWindowName, ChangeInstrument.itemUSDRUB);
    }

    @AfterClass
    public void closeThisDashboard() throws Exception {
        STEDashboardPage()
                .closeSelectedBoard();
     }


}
