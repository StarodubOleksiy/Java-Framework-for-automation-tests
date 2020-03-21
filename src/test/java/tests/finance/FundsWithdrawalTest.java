package tests.finance;

import data.RegistrationInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.Currency.*;

import static data.LoggedUserData.defaultPassword;
import static data.LoggedUserData.defaultVerificationCode;
import static data.LoggedUserData.userPhone3;

public class FundsWithdrawalTest extends BaseTestWithBrowserRetention {

    RegistrationInfo registrationInfo = new RegistrationInfo();

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone3, defaultPassword, defaultVerificationCode);
        STEDashboardPage()
                .clickFinancesLink();
    }

    @TestCaseId("TC_FundsWithdraw_Window_001")
    @Description("Verify fields on funds withdrawal")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test1VerifyFields() throws Exception {
        FundsWithdrawalWindow()
                .verifyFieldsOnFundsWithdrawnWindow(FundsWithdrawalWindow().getAvailableCurrency());
    }

    @TestCaseId("TC_FundsWithdraw_Window_002")
    @Description("Create request choose USD currency and cancel it after successful verifying")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test2CreateRequestUSDCurrency() throws Exception {
        FundsWithdrawalWindow()
                .specifyCurrency(USD.toString())
                .enterAmount(registrationInfo.getStringNumber())
                .enterComment(registrationInfo.getReason())
                .setWithdrawTo(registrationInfo.getUsdPaymentMethod())
                .clickRequestWithdrawalButton()
                .verifyPaymentMethod(USD.toString(), registrationInfo.getUsdPaymentMethod())
                .ifPendingIconIsPresent()
                .clickCancelRequestButton()
                .ifRejectedIconIsPresent()
                .verifyRequestWasCanceled();
    }

    @TestCaseId("TC_FundsWithdraw_Window_003")
    @Description("Create request choose EUR currency")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test3CreateRequestEURCurrency() throws Exception {
        FundsWithdrawalWindow()
                .specifyCurrency(EUR.toString())
                .enterAmount(registrationInfo.getStringNumber())
                .enterComment(registrationInfo.getReason())
                .setWithdrawTo(registrationInfo.getEurPaymentMethod())
                .clickRequestWithdrawalButton()
                .verifyPaymentMethod(EUR.toString(), registrationInfo.getEurPaymentMethod())
                .ifPendingIconIsPresent()
                .clickCancelRequestButton()
                .ifRejectedIconIsPresent()
                .verifyRequestWasCanceled();
    }

    @TestCaseId("TC_FundsWithdraw_Window_004")
    @Description("Create request choose RUB currency")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test4CreateRequestRUBCurrency() throws Exception {
        FundsWithdrawalWindow()
                .specifyCurrency(RUB.toString())
                .enterAmount(registrationInfo.getStringNumber())
                .enterComment(registrationInfo.getReason())
                .setWithdrawTo(registrationInfo.getRubPaymentMethod())
                .clickRequestWithdrawalButton()
                .verifyPaymentMethod(RUB.toString(), registrationInfo.getRubPaymentMethod())
                .ifPendingIconIsPresent()
                .clickCancelRequestButton()
                .ifRejectedIconIsPresent()
                .verifyRequestWasCanceled();
    }

    @TestCaseId("TC_FundsWithdraw_Window_005")
    @Description("Create request choose GBP currency")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test5CreateRequestGBPCurrency() throws Exception {
        FundsWithdrawalWindow()
                .specifyCurrency(GBP.toString())
                .enterAmount(registrationInfo.getStringNumber())
                .enterComment(registrationInfo.getReason())
                .setWithdrawTo(registrationInfo.getUsdPaymentMethod())
                .clickRequestWithdrawalButton()
                .ifPendingIconIsPresent()
                .clickCancelRequestButton()
                .ifRejectedIconIsPresent()
                .verifyRequestWasCanceled();
    }

    @TestCaseId("TC_FundsWithdraw_Window_006")
    @Description("Verify <<Reset>> button and if <<Request withdrawal>> button will be disabled after it click ")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test6CheckResetButton() throws Exception {
        FundsWithdrawalWindow()
                .specifyCurrency(RUB.toString())
                .enterAmount(registrationInfo.getStringNumber())
                .enterComment(registrationInfo.getReason())
                .setWithdrawTo(registrationInfo.getRubPaymentMethod())
                .verifyDescriptionField(registrationInfo.getReason())
                .verifyRequestWithdrawalButtonEnabled()
                .clickResetButton()
                .verifyDescriptionField("")
                .verifyRequestWithdrawalButtonDisabled();
    }

    @TestCaseId("TC_FundsWithdraw_Window_007")
    @Description("Verify when transfer sum is larger then sum which is available on account")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test7VerifyAccountCurrencySumLessThenAmountSum() throws Exception {
        sleep(8000);
        STEDashboardPage()
                .clickOnAccount();
        FundsWithdrawalWindow()
                .specifyCurrency(USD.toString())
                .enterAmount("1000000000")
                .enterComment(registrationInfo.getReason())
                .setWithdrawTo(registrationInfo.getUsdPaymentMethod())
                .clickRequestWithdrawalButton();
    }

    @TestCaseId("TC_FundsWithdraw_Window_008")
    @Description("Verify currency which is available on two different accounts")
    @Features("Stone Edge Trading Finances page")
    @Test(enabled = false)
    public void test8VerifyAvailableCurrencyOfSeveralAccount() throws Exception {
        sleep(6000);
        String availableCurrency0Index = FundsWithdrawalWindow().getAvailableCurrency();
        STEDashboardPage()
                .logOut();
        STELoginPage()
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .enterSmsCode(defaultVerificationCode)
                .clickLoginButton();
        Assert.assertTrue(availableCurrency0Index.contains(getWholeAmount(STELoginPage().getAccountCurrency(0))));
        Assert.assertNotEquals(availableCurrency0Index, STELoginPage().getAccountCurrency(1));
        String availableCurrency1Index = STELoginPage()
                .getAccountCurrency(1);
        STELoginPage()
                .checkAccountNamesByIndex(1)
                .clickLoginButton();
        STEDashboardPage()
                .clickFinancesLink();
        Assert.assertEquals(availableCurrency1Index, FundsWithdrawalWindow().getAvailableCurrency());
        Assert.assertNotEquals(availableCurrency0Index, FundsWithdrawalWindow().getAvailableCurrency());
        STEDashboardPage()
                .logOut();
        STELoginPage()
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .enterSmsCode(defaultVerificationCode)
                .clickLoginButton()
                .checkAccountNamesByIndex(0)
                .clickLoginButton();
        STEDashboardPage()
                .clickFinancesLink();
    }

}
