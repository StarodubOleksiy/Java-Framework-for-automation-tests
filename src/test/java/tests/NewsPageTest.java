package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static data.LoggedUserData.*;

public class NewsPageTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone1, defaultPassword, defaultVerificationCode);

        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard()
                .clickToNewsLink();
    }

    @TestCaseId("TC_NewsPage_001")
    @Description("To verify successful login to Widget News Page Stone Edge Trading application")
    @Features("Stone Edge Trading widget news page")
    @Test()
    public void testSuccessViewNewsPage() throws Exception {
        NewsPage()
                .clickNextPageButton()
                .validateDashboardNewsPreviousPageButton();
    }
}
