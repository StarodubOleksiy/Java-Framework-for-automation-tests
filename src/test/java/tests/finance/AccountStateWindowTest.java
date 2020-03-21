package tests.finance;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.Currency.*;
import static data.LoggedUserData.*;

public class AccountStateWindowTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone3, defaultPassword, defaultVerificationCode);
        STEDashboardPage()
                .clickFinancesLink();
    }

    @TestCaseId("TC_Account_State_Window_001")
    @Description("Verify fields")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void verifyFields() throws Exception {
        AccountStateWindow()
                .verifyFieldsOnAccountStateWindow();
    }

    @TestCaseId("TC_Account_State_Window_002")
    @Description("Verify variables when USD currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void verifyVariablesUSDCurrencySelected() throws Exception {
        AccountStateWindow()
                .clickUSDSpan()
                .verifyCurrency(USD.toString());
        STEDashboardPage()
                .verifyCurrencyOnBoard(USD.toString());
    }

    @TestCaseId("TC_Account_State_Window_003")
    @Description("Verify variables when EUR currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void verifyVariablesEURCurrencySelected() throws Exception {
        AccountStateWindow()
                .clickEURSpan()
                .verifyCurrency(EUR.toString());
        STEDashboardPage()
                .verifyCurrencyOnBoard(EUR.toString());
    }

    @TestCaseId("TC_Account_State_Window_004")
    @Description("Verify variables when RUB currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void verifyVariablesRUBCurrencySelected() throws Exception {
        AccountStateWindow()
                .clickRUBSpan()
                .verifyCurrency(RUB.toString());
        STEDashboardPage()
                .verifyCurrencyOnBoard(RUB.toString());
    }

    @TestCaseId("TC_Account_State_Window_005")
    @Description("Verify variables when GBP currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void verifyVariablesGBPCurrencySelected() throws Exception {
        AccountStateWindow()
                .clickGBPSpan()
                .verifyCurrency(GBP.toString());
        STEDashboardPage()
                .verifyCurrencyOnBoard(GBP.toString());
    }
}
