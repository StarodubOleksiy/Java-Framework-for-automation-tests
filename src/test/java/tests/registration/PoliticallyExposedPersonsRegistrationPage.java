package tests.registration;

import data.RegistrationInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTest;
import utils.ExcelUtils;

import java.util.List;

public class PoliticallyExposedPersonsRegistrationPage extends BaseTest {

    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        CRSSelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        FATCASelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        EducationAndOccupationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_Politically_Exposed_Persons_001")
    @Description("Verify error messages for empty required fields on Politically exposed persons form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testPoliticallyExposedPersonsFormEmptyFields1() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/PoliticallyExposedPersonsEmptyErrorMessages1.xlsx");

        PoliticallyExposedPersonsForm().sleep(3000); //to make sure page is fully loaded - fix flakiness on CI
        PoliticallyExposedPersonsForm()
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

    @TestCaseId("TC_Individual_Registration_Politically_Exposed_Persons_002")
    @Description("Verify error messages for empty required fields on Politically exposed persons form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testPoliticallyExposedPersonsFormEmptyFields2() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/PoliticallyExposedPersonsEmptyErrorMessages2.xlsx");

        PoliticallyExposedPersonsForm()
                .checkFamilyInGovernment(registrationInfo.getYesAnswer())
                .checkFamilyInGovernmentInPastYear(registrationInfo.getYesAnswer())
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }
}
