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


public class InvestmentProfilePage extends BaseTest {

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

        PoliticallyExposedPersonsForm().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_Investment_Profile_001")
    @Description("Verify error messages for empty required fields on Investment profile form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testInvestmentProfileFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/InvestmentProfileEmptyErrorMessages.xlsx");

        InvestmentProfileForm()
                .enterInvestmentsToAvoid("")
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }


}
