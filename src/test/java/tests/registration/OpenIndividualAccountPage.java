package tests.registration;

import data.RegistrationInfo;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTest;
import utils.ExcelUtils;

import java.util.List;

public class OpenIndividualAccountPage extends BaseTest {

    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }


    @TestCaseId("TC_Open_Individual_Account_001")
    @Description("Verify error messages for empty required fields on Open Account page")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testAllFieldsAreEmpty() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/OpenAccountEmptyErrorMessages.xlsx");
        OpenAccountForm()
                .clickPassword()
                .clickFirstName()
                .clickLastName()
                .clickEmail()
                .clickPassword()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

    @TestCaseId("TC_Open_Individual_Account_002")
    @Description("Verify error messages for empty required fields on Open Account page")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testInvalidData() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/OpenAccountInvalidDataErrorMessages.xlsx");
        OpenAccountForm()
                .enterFirstName(registrationInfo.getOneCharacterName())
                .enterLastName(registrationInfo.getOneCharacterName())
                .enterEmail(registrationInfo.getOneCharacterName())
                .enterPassword(registrationInfo.getOneCharacterName())
                .clickFirstName()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }


    @TestCaseId("TC_Open_Individual_Account_003")
    @Description("Verify if open account button is disabled when filling the first name")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testOpenAccountButtonFillingFirstName() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName());
        OpenAccountForm().ifOpenAccountButtonIsDisabled();

    }

    @TestCaseId("TC_Open_Individual_Account_004")
    @Description("Verify if open account button is disabled when filling the first and last names")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testOpenAccountButtonFillingFirstAndLastName() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterLastName(registrationInfo.getLastName());
        OpenAccountForm().ifOpenAccountButtonIsDisabled();

    }

    @TestCaseId("TC_Open_Individual_Account_005")
    @Description("Verify if open account button is disabled when filling the first, last names and email")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testOpenAccountButtonFillingFirstLastNameAndEmail() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterLastName(registrationInfo.getLastName())
                .enterEmail(registrationInfo.getEmailAddress());
        OpenAccountForm().ifOpenAccountButtonIsDisabled();

    }

    @TestCaseId("TC_Open_Individual_Account_006")
    @Description("Verify if open account button is enabled when filling the first, last names email and password")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testOpenAccountButtonFillingFirstLastNameEmailAndPassword() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterLastName(registrationInfo.getLastName())
                .enterEmail(registrationInfo.getEmailAddress())
                .enterPassword(registrationInfo.getPassword());
        OpenAccountForm().ifOpenAccountButtonIsEnabled();
    }

    @TestCaseId("TC_Open_Individual_Account_007")
    @Description("Verify page Open Account when password is weak")
    @Features("Stone Edge Trading open account")
    @Test()
    public void testOpenPageWeakPassword() throws Exception {
        OpenAccountForm()
                .enterFirstName(registrationInfo.getFirstName())
                .enterLastName(registrationInfo.getLastName())
                .enterEmail(registrationInfo.getEmailAddress())
                .enterPassword("123456")
                .clickOpenAccountButton();
    }


}
