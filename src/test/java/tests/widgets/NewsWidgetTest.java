package tests.widgets;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static data.LoggedUserData.*;

public class NewsWidgetTest extends BaseTestWithBrowserRetention {

    String boardName = Long.toString(new Date().getTime());

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode)
                .clickTrainingBoardButton();
        sleep(6000);
        STEDashboardPage()
                .addNewBoard(boardName)
                .clickAddWidgetButton();
        AddWidgetPopUp()
                .clickNewsWidgetButton()
                .clickAddWidgetPopUpButton();
    }

    @TestCaseId("TC_NewsWidget_001")
    @Description("To verify if news widget is present on trading board and how it works")
    @Features("Stone Edge Trading widget news page")
    @Test()
    public void testNewsWidgetOnTradingBoard() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        if (isWeekend (date)) {
            if (NewsWidget().isDatePresent()) {
                NewsWidget()
                        .verifyNewsWidgetPresent()
                        .clickNewsListItem()
                        .verifyArticleContent()
                        .clickBackToNewsListButton()
                        .verifyIfNewsListVisible();
            } else return;
        } else {
            NewsWidget()
                    .verifyNewsWidgetPresent()
                    .verifyPresentDate(text)
                    .clickNewsListItem()
                    .verifyArticleContent()
                    .clickBackToNewsListButton()
                    .verifyIfNewsListVisible();
        }
    }

    private boolean isWeekend(LocalDate date){
        return date.getDayOfWeek().toString().equals("SATURDAY")|| date.toString().equals("SUNDAY");
    }

    @AfterClass
    public void closeThisDashboard() throws Exception {
        STEDashboardPage()
                .closeSelectedBoard();
    }

}
