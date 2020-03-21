package tests.registration;

import data.RegistrationInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTest;

public class IndividualRegistrationMainFlow extends BaseTest {

    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() throws Exception {
        registrationInfo = new RegistrationInfo();
    }


    @TestCaseId("TC_Individual_Registration_Valid_Flow_001")
    @Description("Verify valid individual registration flow with minimum set of filled fields in Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testIndividualRegistrationFlow1() throws Exception {

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

        ExplicitDeclarationsAndDocumentsForm().fillInRequiredFields(registrationInfo).clickVerifyMeButton();

        VerificationForm().validateVerifyMessage("Your account is on Verification");
    }

    @TestCaseId("TC_Individual_Registration_Valid_Flow_002")
    @Description("Verify valid individual registration flow with maximum set of filled fields in Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testIndividualRegistrationFlow2() throws Exception {

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        CRSSelfCertificationForm().fillInAllFieldsWithData(registrationInfo).clickNextStepButton();

        FATCASelfCertificationForm().fillInAllFieldsWithData(registrationInfo).clickNextStepButton();

        EducationAndOccupationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        PoliticallyExposedPersonsForm().fillInAllFieldsWithData(registrationInfo).clickNextStepButton();

        InvestmentProfileForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        FinancialStatusAndExperienceForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        PaymentDetailsForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        ExplicitDeclarationsAndDocumentsForm().fillInRequiredFields(registrationInfo).clickVerifyMeButton();

        VerificationForm().validateVerifyMessage("Your account is on Verification");
    }

}
