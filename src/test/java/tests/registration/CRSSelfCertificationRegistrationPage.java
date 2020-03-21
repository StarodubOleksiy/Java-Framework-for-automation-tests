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


public class CRSSelfCertificationRegistrationPage extends BaseTest {

    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_CRS_Self_Certification_001")
    @Description("Verify error messages for empty required fields on CRS self-certification of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testCRSSelfCertificationFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/CRSSelfCertificationEmptyErrorMessages1.xlsx");

        CRSSelfCertificationForm()
                .selectCountry("")
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

    @TestCaseId("TC_Individual_Registration_CRS_Self_Certification_001")
    @Description("Verify error messages for empty required fields on CRS self-certification of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testCRSSelfCertificationFormEmptyFields2() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/CRSSelfCertificationEmptyErrorMessages2.xlsx");

        CRSSelfCertificationForm()
                .clickNoTINIsAvailable()
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }


}
