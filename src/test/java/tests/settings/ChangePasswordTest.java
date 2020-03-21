package tests.settings;

import data.RegistrationInfo;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;

import static data.LoggedUserData.*;

public class ChangePasswordTest extends BaseTestWithBrowserRetention {

    private RegistrationInfo registrationInfo;
    private String newPassword;
    private boolean currentPasswordIsChanged = false;

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone2, defaultPassword, defaultVerificationCode);
        registrationInfo = new RegistrationInfo();
        newPassword = registrationInfo.getPassword();
    }

    @BeforeMethod
    public void before() {
        sleep(6000);
        STEDashboardPage()
                .clickSettingButton();
        SettingsPage()
                .clickSecurityTab();
    }


    @TestCaseId("TC_Change_Password_001")
    @Description("Test change password successful flow")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test1ChangePasswordSuccessfulFlow() throws Exception {
        currentPasswordIsChanged = true;
        SettingsPage()
                .enterOldPassword(defaultPassword)
                .enterNewPassword(newPassword)
                .enterRepeatNewPassword(newPassword)
                .clickConfirmWithCodeButton()
                .enterSmsCode(defaultVerificationCode)
                .clickChangePasswordButton()
                .clickCancelIcon();
        STEDashboardPage()
                .logOut();
        sleep(200);
        STELoginPage()
                .enterLoginPassword(newPassword)
                .clickLoginButton()
                .enterSmsCode(defaultVerificationCode)
                .clickLoginButton()
                .clickAccountName();
        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard();
    }

    @TestCaseId("TC_Change_Password_002")
    @Description("Test change password fields are empty")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test2ChangePasswordFieldsAreEmpty() throws Exception {
        SettingsPage()
                .clearOldPassword()
                .enterOldPassword("")
                .checkNewPasswordTextBoxIsDisabled()
                .checkRepeatNewPasswordTextBoxIsDisabled()
                .ifSmsCodeInputIsNotPresent()
                .ifChangePasswordSpanIsNotPresent()
                .clickCancelIcon();
    }

    @TestCaseId("TC_Change_Password_003")
    @Description("Test current password is short")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test3ChangePasswordIsShort() throws Exception {
        SettingsPage()
                .clearOldPassword()
                .enterOldPassword("12345")
                .checkNewPasswordTextBoxIsDisabled()
                .checkRepeatNewPasswordTextBoxIsDisabled()
                .checkConfirmWithCodeButtonIsDisabled()
                .ifSmsCodeInputIsNotPresent()
                .ifChangePasswordSpanIsNotPresent()
                .clickCancelIcon();
    }

    @TestCaseId("TC_Change_Password_004")
    @Description("Test current password is wrong")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test4ChangeCurrentPasswordIsWrong() throws Exception {
        SettingsPage()
                .clearOldPassword()
                .enterOldPassword("test9087")
                .enterNewPassword("123456789")
                .enterRepeatNewPassword("123456789")
                .clickConfirmWithCodeButton()
                .ifSmsCodeInputIsNotPresent()
                .ifChangePasswordSpanIsNotPresent()
                .clickCancelIcon();
    }

    @TestCaseId("TC_Change_Password_005")
    @Description("Test new password is short")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test5ChangeNewPasswordIsShort() throws Exception {
        SettingsPage()
                .clearOldPassword()
                .enterOldPassword("test123")
                .enterNewPassword("12345")
                .enterRepeatNewPassword("12345")
                .checkConfirmWithCodeButtonIsDisabled()
                .ifSmsCodeInputIsNotPresent()
                .ifChangePasswordSpanIsNotPresent()
                .clickCancelIcon();
    }

    @TestCaseId("TC_Change_Password_006")
    @Description("Test new and repeat passwords are different")
    @Features("Stone Edge Trading Dashboard page")
    @Test()
    public void test6NewPasswordNotSameAsRepeated() throws Exception {
        SettingsPage()
                .clearOldPassword()
                .enterOldPassword("test123")
                .enterNewPassword("123456789")
                .enterRepeatNewPassword("1234567890-=")
                .checkConfirmWithCodeButtonIsDisabled()
                .ifSmsCodeInputIsNotPresent()
                .ifChangePasswordSpanIsNotPresent()
                .clickCancelIcon();
    }

    @AfterMethod
    public void after() {
        if (currentPasswordIsChanged) {
            STEDashboardPage()
                    .clickSettingButton();
            SettingsPage()
                    .clickSecurityTab()
                    .enterOldPassword(newPassword)
                    .enterNewPassword(defaultPassword)
                    .enterRepeatNewPassword(defaultPassword)
                    .clickConfirmWithCodeButton()
                    .enterSmsCode(defaultVerificationCode)
                    .clickChangePasswordButton()
                    .clickCancelIcon();
            currentPasswordIsChanged = false;
        }
    }

}
