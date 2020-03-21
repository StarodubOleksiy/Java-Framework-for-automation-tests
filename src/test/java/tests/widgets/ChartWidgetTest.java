package tests.widgets;

import data.ChangeInstrument;
import data.IndicatorsOnChartWidget;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.util.Date;

import static data.LoggedUserData.*;

public class ChartWidgetTest extends BaseTestWithBrowserRetention {

    private String firstTime;
    private final String dataWindowName = "overview";
    private String currentInstrument;
    String boardName = Long.toString(new Date().getTime());

    @BeforeClass
    public void login() throws Exception {
        STELoginPage().quickLogin(userPhone3, defaultPassword, defaultVerificationCode);
        sleep(6000);
        STEDashboardPage()
                .addNewBoard(boardName)
                .clickAddWidgetButton();
        currentInstrument = ChangeInstrument.itemAUDCHF;
        AddWidgetPopUp()
                .clickChartWidgetButton()
                .selectInstrument(ChangeInstrument.findPathToItem.get(currentInstrument), null);
        AddWidgetPopUp().clickAddWidgetPopUpButton();
        sleep(8000);
        ChartWidget().verifyChartTitleIsPresent();

//        STEDashboardPage()
//                .verifyWidgetCanBeMoved(-100, -100);
        firstTime = ChartWidget().getTimeFrame();
    }

    @TestCaseId("TC_ChartWidget_001")
    @Description("Verify chart widget is present on trading board and how it works")
    @Features("Stone Edge Trading widget chart page")
    @Test
    public void testChartWidgetOnTradingBoard() throws Exception {
        ChartWidget()
                .verifyChartsWidgetPresent()
                .verifyTimeFrameSpanPresent()
                // .verifyAddIndicatorDivPresent()
                .verifyChangeInstrumentPresent()
                .verifyChartPresent()
                .clickInstruments();
        ChangeInstrumentPopUp()
                .verifyInstrumentCard();
        Thread.sleep(1000);
        ChartWidget()
                .clickInstruments();

        ChangeInstrumentPopUp()
                .verifyInstrument(dataWindowName, currentInstrument);
    }

    @TestCaseId("TC_ChartWidget_002")
    @Description("Verify chart widget is present on trading board and how it works if time frame will be changed")
    @Features("Stone Edge Trading widget chart page")
    @Test
    public void testChartWidgetOnTradingBoardChangeATimeFrame() throws Exception {
        //TODO change timeFame and verify span is set to value you have set
        String timeFrameToSelect;
        if (!firstTime.equals("6 hours"))
            timeFrameToSelect = "6 hours";
        else timeFrameToSelect = "15 minutes";
        ChartWidget()
                .selectTimeFrame(timeFrameToSelect)
                .verifyTimeFrame(timeFrameToSelect)
                .verifyChartsWidgetPresent()
                .verifyChangeInstrumentPresent()
                .verifyAddIndicatorDivPresent()
                .verifyChartPresent()
                .clickInstruments();
        ChangeInstrumentPopUp()
                .verifyInstrumentCard();
        Thread.sleep(1000);
        ChartWidget()
                .clickInstruments();
        Thread.sleep(1000);
        String actualInstrumentName = String.valueOf(ChartWidget().getCurrentInstrument().toCharArray()
                , 0, currentInstrument.length());
        ChangeInstrumentPopUp()
                .verifyInstrument(dataWindowName, actualInstrumentName);
    }

    @TestCaseId("TC_ChartWidget_003")
    @Description("To change instruments on chart widget")
    @Features("Stone Edge Trading widget chart page")
    @Test
    public void testChartWidgetOnTradingBoardChangeInstruments() throws Exception {
        ChartWidget()
                .clickChangeInstruments();
        ChangeInstrumentPopUp()
                .changeInstrument(dataWindowName, ChangeInstrument.itemAUDJPY);
        sleep(8000);
        ChangeInstrumentPopUp()
                .verifyInstrument(dataWindowName, ChangeInstrument.itemAUDJPY);
    }

    @TestCaseId("TC_ChartWidget_004")
    @Description("Verify chart widget indicator")
    @Features("Stone Edge Trading widget chart page")
    @Test(enabled = false)
    public void testChartWidgetOnTradingBoardAddIndicator() throws Exception {
        ChartWidget()
                .addIndicator(IndicatorsOnChartWidget.EMA.toString())
                .indicatorIsPresent(IndicatorsOnChartWidget.EMA.toString())
                .addIndicator(IndicatorsOnChartWidget.SMA.toString())
                .indicatorIsPresent(IndicatorsOnChartWidget.SMA.toString())
                .addIndicator(IndicatorsOnChartWidget.WMA.toString())
                .indicatorIsPresent(IndicatorsOnChartWidget.WMA.toString())
                .addIndicator(IndicatorsOnChartWidget.TMA.toString())
                .indicatorIsPresent(IndicatorsOnChartWidget.TMA.toString())
                .addIndicator(IndicatorsOnChartWidget.BollingerBand.toString())
                .indicatorIsPresent(IndicatorsOnChartWidget.BollingerBand.toString());
    }

    @AfterMethod
    public void waitAfterTestCase() throws Exception {
        Thread.sleep(2000);
    }

    @AfterClass
    public void setFirstDateLikeBeforeTest() throws Exception {
        STEDashboardPage()
                .closeSelectedBoard();
    }

}
