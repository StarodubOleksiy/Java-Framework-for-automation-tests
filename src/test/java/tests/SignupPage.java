package tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static data.LoggedUserData.*;

public class SignupPage extends BaseTest {

    @TestCaseId("TC_Signup_001")
    @Description("Verify incorrect login signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void testSTEIncorrectLoginSignup1() throws Exception {
        String phone = "";
        STESignupPage()
                .clickOpenAccount()
                .clickOkButton()
                .enterSignupPhoneNumber(phone)
                .enterSmsCode(defaultVerificationCode);

        STESignupPage().validateLoginRequiredMessage();
    }

    @TestCaseId("TC_Signup_002")
    @Description("Verify incorrect login signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void testSTEIncorrectLoginSignup2() throws Exception {
        String phone = "123";
        STESignupPage()
                .clickOpenAccount()
                .clickOkButton()
                .enterSignupPhoneNumber(phone)
                .enterSmsCode(defaultVerificationCode);

        STESignupPage().validateSignupErrorMessage();
    }

    @TestCaseId("TC_Sigup_003")
    @Description("To verify incorrect validation code signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void testSTEIncorrectCodeSignup1() throws Exception {
        String validationCode = "";

        STESignupPage()
                .clickOpenAccount()
                .clickOkButton()
                .enterSignupPhoneNumber(userPhoneNotRegistered)
                .clickSendCodeButton()
                .enterSmsCode(validationCode);

        STELoginPage()
                .clickOnLoginField();
        STESignupPage()
                .validateLoginRequiredMessage();
    }

    @TestCaseId("TC_Sigup_004")
    @Description("To verify incorrect validation code signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void testSTEIncorrectCodeSignup2() throws Exception {
        String validationCode = "126";

        STESignupPage()
                .clickOpenAccount()
                .clickOkButton()
                .enterSignupPhoneNumber(userPhoneNotRegistered)
                .clickSendCodeButton()
                .enterSmsCode(validationCode);

        STELoginPage()
                .clickLoginButton()
                .validateNotificationErrorMessage("authy service failed");
    }

    @TestCaseId("TC_Sigup_005")
    @Description("To verify validation for number in use to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void testSTENumberInUseSignup() throws Exception {
        STESignupPage()
                .clickOpenAccount()
                .clickOkButton()
                .enterSignupPhoneNumber(/*userPhone1*/ userPhone2)
                .clickSendCodeButton()
                .enterSmsCode(defaultVerificationCode);
        STELoginPage()
                .validateNotificationErrorMessage("phone already exists");
    }

}
