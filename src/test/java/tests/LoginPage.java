package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.net.URL;

import static data.LoggedUserData.*;
public class LoginPage extends BaseTest {
    @TestCaseId("TC_Login_001")
    @Description("To verify successful login to Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTESuccessLogin() throws Exception {
        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber( userPhone1)
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .enterSmsCode(defaultVerificationCode)
                .clickLoginButton()
                .clickAccountName();

        STEDashboardPage()
                .verifyPageTitle()
                .validateDashboard();
    }


    @TestCaseId("TC_Login_002")
    @Description("To verify incorrect phone number for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPhoneLogin1() throws Exception {
        String phone = "";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(phone)
                .enterLoginPassword(defaultPassword);
        STELoginPage().validateLoginRequiredMessage();
    }

    @TestCaseId("TC_Login_003")
    @Description("To verify incorrect phone number for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPhoneLogin2() throws Exception {
        String phone = "123";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(phone)
                .enterLoginPassword(defaultPassword);

        STELoginPage().validateLoginErrorMessage();
    }

    @TestCaseId("TC_Login_004")
    @Description("To verify incorrect phone number for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPhoneLogin3() throws Exception {
        String phone = "11124124114114";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(phone)
                .enterLoginPassword(defaultPassword);

        STELoginPage().validateLoginErrorMessage();
    }

    @TestCaseId("TC_Login_005")
    @Description("To verify incorrect password for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPasswordLogin1() throws Exception {
        String password = "";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(password)
                .clickOnLoginField();

        STELoginPage()
                .validateLoginRequiredMessage();
    }

    @TestCaseId("TC_Login_006")
    @Description("To verify incorrect password for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPasswordLogin2() throws Exception {
        String password = "123";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(password)
                .clickOnLoginField();

        STELoginPage()
                .clickOnPasswordField()
                .validateTooShortPasswordErrorMessage();
    }

    @TestCaseId("TC_Login_007")
    @Description("To verify incorrect password for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPasswordLogin3() throws Exception {
        String password = "abcderds";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(password)
                .clickOnLoginField();

        STELoginPage()
                .clickLoginButton()
                .validateNotificationErrorMessage("wrong password");
    }

    @TestCaseId("TC_Login_008")
    @Description("To verify incorrect password for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectPasswordLogin4() throws Exception {
        String password = "'11124124114114";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(password)
                .clickOnLoginField();

        STELoginPage()
                .clickLoginButton()
                .validateNotificationErrorMessage("wrong password");
    }

    @TestCaseId("TC_Login_009")
    @Description("To verify incorrect validateion code for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectValidationCodeLogin1() throws Exception {
        String validationCode = "";
        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .enterSmsCode(validationCode)
                .verifyLoginButtonDisabled();
    }

    @TestCaseId("TC_Login_010")
    @Description("To verify incorrect validation code for login into Stone Edge Trading application")
    @Features("Stone Edge Trading login page")
    @Test
    public void testSTEIncorrectValidationCodeLogin2() throws Exception {

       String validationCode = "145";

        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .enterSmsCode(validationCode);

        STELoginPage()
                .clickLoginButton()
                .validateNotificationErrorMessage("authy validation failed");

    }

    @TestCaseId("TC_Login_011")
    @Description("Verify if <<Did not get code. Send again>> Link will be present after 60 seconds ")
    @Features("Stone Edge Trading login page")
    @Test
    public void testDidNotGetCodeSendAgainLink() throws Exception {
        STELoginPage()
                .clickOkButton()
                .enterLoginPhoneNumber(userPhone1)
                .enterLoginPassword(defaultPassword)
                .clickLoginButton()
                .checkDidNotGetCodeSendAgainLinkIsNotPresent();
        STELoginPage()
                .clickDidNotGetCodeSendAgainLink()
                .checkDidNotGetCodeSendAgainLinkIsNotPresent()
                .enterSmsCode(defaultVerificationCode)
                .clickLoginButton()
                .clickAccountName();
        STEDashboardPage()
                .validateDashboard();
    }

}


