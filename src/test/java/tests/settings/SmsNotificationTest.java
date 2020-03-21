package tests.settings;

import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.LoggedUserData.*;

public class SmsNotificationTest extends BaseTestWithBrowserRetention {

    private boolean smsNotificationSwitchOff = false;

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone2, defaultPassword, defaultVerificationCode);
        sleep(6000);
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickSecurityTab();
    }

    @TestCaseId("TC_SMS_Authentication_001")
    @Description("Test  verify sms authentification successful flow")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void verifySmsAuthentication() throws Exception {
        smsNotificationSwitchOff = true;
        SettingsPage()
                .clickOffTab()
                .enterSmsAuthentication(defaultVerificationCode)
                .clickChangeSmsAuthenticationSpan()
                .clickCancelIcon();
        STEDashboardPage()
                .logOut();
        STELoginPage()
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .clickAccountName();
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard();
    }

    @TestCaseId("TC_SMS_Authentication_002")
    @Description("Test  verify sms authentication sms input field")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void verifySmsAuthenticationInputField() throws Exception {
        SettingsPage()
                .clickSmsTab()
                .checkSmsAuthenticationDisabled()
                .clickOffTab()
                .enterSmsAuthentication(defaultVerificationCode)
                .clickChangeSmsAuthenticationSpan()
                .checkSmsAuthenticationDisabled()
                .clickSmsTab()
                .enterSmsAuthentication(defaultVerificationCode)
                .clickChangeSmsAuthenticationSpan();
    }


    @AfterMethod
    public void after() {
        if (smsNotificationSwitchOff) {
            STEDashboardPage()
                    .clickSettingButton();
            SettingsPage()
                    .clickSecurityTab()
                    .clickSmsTab()
                    .enterSmsAuthentication(defaultVerificationCode)
                    .clickChangeSmsAuthenticationSpan();
            smsNotificationSwitchOff = false;
        }
    }

}
