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


public class ExplicitDeclarationsAndDocumentsPage extends BaseTest {
    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() throws Exception {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        CRSSelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        FATCASelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        EducationAndOccupationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        PoliticallyExposedPersonsForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        InvestmentProfileForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        FinancialStatusAndExperienceForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        PaymentDetailsForm().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_Explicit_Declarations_And_Documents_001")
    @Description("Verify error messages for empty required fields on Explicit declarations and documents form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testExplicitDeclarationsAndDocumentsFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/ExplicitDeclarationsAndDocumentsEmptyErrorMessages.xlsx");

        ExplicitDeclarationsAndDocumentsForm()
                .clickVerifyMeButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

}
