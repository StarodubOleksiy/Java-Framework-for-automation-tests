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


public class PaymentDetailsPage extends BaseTest {

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

    }

    @TestCaseId("TC_Individual_Registration_Payment_Details_001")
    @Description("Verify error messages for empty required fields on Payment details form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testPaymentDetailsFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/PaymentDetailsEmptyErrorMessages.xlsx");

        PaymentDetailsForm()
                .enterCorrespondentBankName("")
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

}
