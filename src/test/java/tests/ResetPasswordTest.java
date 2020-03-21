package tests;

import data.RegistrationInfo;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import utils.ExcelUtils;

import java.util.List;

import static data.LoggedUserData.defaultPassword;
import static data.LoggedUserData.userPhone2;

public class ResetPasswordTest extends BaseTestWithBrowserRetention {
    private RegistrationInfo registrationInfo;
    private String resetPassword;

    @BeforeClass
    public void before() {
        registrationInfo = new RegistrationInfo();
        resetPassword = registrationInfo.getPassword();
        STESignupPage()
                .enterSignupPhoneNumber(userPhone2)
                .clickIForgotPassword();
    }

    @TestCaseId("TC_Stone Edge Trading_Reset_Password_001")
    @Description("Verify reset password success flow")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testResetPassword() throws Exception {
        ResetPassword()
                .enterLoginPhoneNumber(userPhone2)
                .enterSmsCode(registrationInfo.getValidSmsCode())
                .clickSendCodeButton()
                .enterLoginPassword(resetPassword)
                .clickResetPassword();
        sleep(2000); //This line is required. In other case test will fall.
        STELoginPage()
                .clearPhoneNumberField();
        STELoginPage().quickLogin(userPhone2, resetPassword, registrationInfo.getValidSmsCode());
        sleep(2000); //This line is required. In other case test will fall.
        STEDashboardPage()
                .logOut();
        sleep(2000);
        STELoginPage()
                .clickItsNotMeLink();
        STESignupPage()
                .enterSignupPhoneNumber(userPhone2)
                .clickIForgotPassword();
    }

    @TestCaseId("TC_Individual_Registration_Reset_Password_002")
    @Description("Verify reset password when all fields are empty")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testResetPasswordWhenAllFieldsAreEmpty() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/ResetPasswordEmptyField.xlsx");
        ResetPassword()
                .enterLoginPhoneNumber(userPhone2)
                .enterSmsCode(registrationInfo.getValidSmsCode())
                .clickSendCodeButton()
                .clearPhoneNumberField()
                .clearSmsCodeInput()
                .enterLoginPhoneNumber("")
                .enterSmsCode("")
                .clickOnLoginPasswordTextBox()
                .ifResetPasswordIsDisabled()
                .ifSendCodeButtonIsDisabled();
                sleep(2000);
        ResetPassword()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }


    @TestCaseId("TC_Individual_Registration_Reset_Password_003")
    @Description("Verify reset password when fields are filled Incorrectly")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testResetPasswordFieldsFilledIncorectly() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/ResetPasswordErrorMessages.xlsx");
        ResetPassword()
                .clearPhoneNumberField()
                .enterLoginPhoneNumber(userPhone2)
                .clearSmsCodeInput()
                .enterSmsCode(registrationInfo.getValidSmsCode());
        Thread.sleep(1000); //This line is required. In other case test will fall.
        ResetPassword()
                .clickSendCodeButton()
                .enterLoginPassword("12345")
                .clearPhoneNumberField()
                .enterLoginPhoneNumber("+38099032896923")
                .ifResetPasswordIsDisabled()
                .ifSendCodeButtonIsDisabled()
                .clickOnLoginPhoneTextBox()
                .validateErrorMessagesArePresent(expectedErrorMessages)
                .clearPasswordField();
    }


    @TestCaseId("TC_Individual_Registration_Reset_Password_004")
    @Description("Verify reset password when all fields are not empty")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testResetPasswordWhenAllFieldsAreNotEmpty() throws Exception {
        ResetPassword()
                .clearPhoneNumberField()
                .enterLoginPhoneNumber(userPhone2)
                .clearSmsCodeInput()
                .enterSmsCode(registrationInfo.getValidSmsCode())
                .clickSendCodeButton()
                .clearPasswordField()
                .enterLoginPassword(resetPassword)
                .ifResetPasswordButtonIsEnabled()
                .ifSendCodeButtonIsDisabled();
    }


    @AfterClass
    public void changePasswordBackLikeBefore() throws Exception {
        ResetPassword()
                .clickOnCancelSpan();
        STESignupPage()
                .clearPhoneNumberField()
                .enterSignupPhoneNumber(userPhone2)
                .clickIForgotPassword();
        ResetPassword()
                .clearPhoneNumberField()
                .enterLoginPhoneNumber(userPhone2)
                .clearSmsCodeInput()
                .enterSmsCode(registrationInfo.getValidSmsCode())
                .clickSendCodeButton()
                .clearPasswordField()
                .enterLoginPassword(defaultPassword)
                .clickResetPassword();
    }

}
