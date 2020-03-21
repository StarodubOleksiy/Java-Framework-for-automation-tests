package tests.registration;

import data.RegistrationInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTest;
import tests.BaseTestWithBrowserRetention;
import utils.ExcelUtils;

import java.util.List;

public class OpenCorporateAccountPage extends BaseTestWithBrowserRetention {
    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();
        OpenAccountForm().clickCorporateButton();
    }

    @TestCaseId("TC_Open_Individual_Account_001")
    @Description("Testing when flow is successfull and all fields are filled right")
    @Features("Stone Edge Trading open account")
    @Test(enabled = false)
    public void testSuccessfullFlow() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterEmail(registrationInfo.getEmailAddress())
                .enterPassword(registrationInfo.getPassword())
                .clickOpenAccountButton();
    }


    @TestCaseId("TC_Open_Corporate_Account_002")
    @Description("Verify error messages for empty required fields on Open Account page")
    @Features("Stone Edge Trading open account")
    @Test(enabled = false)
    public void testAllFieldsAreEmpty() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/OpenAccountEmptyErrorMessagesCorporateTab.xlsx");
        OpenAccountForm()
                .clickPassword()
                .clickFirstName()
                .clickEmail()
                .clickCorporateButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

    @TestCaseId("TC_Open_Corporate_Account_003")
    @Description("Verify error messages for empty required fields on Open Account page")
    @Features("Stone Edge Trading open account")
    @Test(enabled = false)
    public void testInvalidData() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/OpenAccountInvalidDataErrorMessages.xlsx");
        OpenAccountForm()
                .enterFirstName(registrationInfo.getOneCharacterName())
                .enterEmail(registrationInfo.getOneCharacterName())
                .enterPassword(registrationInfo.getOneCharacterName())
                .clickFirstName()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }


    @TestCaseId("TC_Open_Corporate_Account_004")
    @Description("Verify if open account button is disabled when filling the first name")
    @Features("Stone Edge Trading open account")
    @Test(enabled = false)
    public void testOpenAccountButtonFillingFirstName() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName());
        OpenAccountForm().ifOpenAccountButtonIsDisabled();

    }

    @TestCaseId("TC_Open_Corporate_Account_005")
    @Description("Verify if open account button is disabled when filling the first name and email")
    @Features("Stone Edge Trading open account")
    @Test(enabled = false)
    public void testOpenAccountButtonFillingFirstLastNameAndEmail() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterEmail(registrationInfo.getEmailAddress());
        OpenAccountForm().ifOpenAccountButtonIsDisabled();

    }

    @TestCaseId("TC_Open_Corporate_Account_006")
    @Description("Verify if open account button is enabled when filling the first name email and password")
    @Features("Stone Edge Trading open account")
    @Test(enabled = false)
    public void testOpenAccountButtonFillingFirstLastNameEmailAndPassword() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterEmail(registrationInfo.getEmailAddress())
                .enterPassword(registrationInfo.getPassword());
        OpenAccountForm().ifOpenAccountButtonIsEnabled();
    }


}
