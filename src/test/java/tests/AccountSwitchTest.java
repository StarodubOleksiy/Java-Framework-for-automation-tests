package tests;

import data.AccountVariables;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.util.ArrayList;
import java.util.List;

import static data.LoggedUserData.*;

public class AccountSwitchTest extends BaseTestWithBrowserRetention {

    @BeforeClass
    public void login() {
        STELoginPage().quickLoginOneAccount(userPhone3, defaultPassword, defaultVerificationCode);
        sleep(6000);
    }

    @TestCaseId("TC_Verification_Different_Accounts_001")
    @Description("Verify account names and variables of two different accounts")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void testAccountNames() throws Exception {
        sleep(3000);
        String firstAccountName = STELoginPage().getAccountSwitchName(0);
        String secondAccountName = STELoginPage().getAccountSwitchName(1);
        STELoginPage()
                .checkAccountNamesByIndex(0);
        if (!STEDashboardPage().isHeaderVisible())
            STEDashboardPage()
                    .clickShowHeader();
        STEDashboardPage()
                .verifyAccount(firstAccountName);
        AccountVariables accountVariables = STEDashboardPage().getAccountVariables();
        STEDashboardPage()
                .logOut();
        STELoginPage()
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .enterSmsCode(defaultVerificationCode)
                .clickLoginButton()
                .checkAccountNamesByIndex(1);
        if (!STEDashboardPage().isHeaderVisible())
            STEDashboardPage()
                    .clickShowHeader();
        STEDashboardPage()
                .verifyAccount(secondAccountName);
        Thread.sleep(2000); //This line is required because variables need time to refresh
        STEDashboardPage()
                .verificationVariablesOfSeveralAccounts(accountVariables);
        STEDashboardPage()
                .logOut();

    }

}
