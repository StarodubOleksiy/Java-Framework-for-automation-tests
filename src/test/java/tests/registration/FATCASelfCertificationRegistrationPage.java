package tests.registration;

import data.RegistrationInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTest;
import utils.ExcelUtils;

import java.util.List;


public class FATCASelfCertificationRegistrationPage extends BaseTest {

    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        CRSSelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_FATCA_Self_Certification_001")
    @Description("Verify error messages for empty required fields on FATCA self-certification of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testFATCASelfCertificationFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/FATCASelfCertificationEmptyErrorMessages.xlsx");

        FATCASelfCertificationForm()
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

    @TestCaseId("TC_Individual_Registration_FATCA_Self_Certification_002")
    @Description("Verify error messages for empty required fields on FATCA self-certification of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testFATCASelfCertificationFormEmptyInvalidFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/FATCASelfCertificationEmptyInvalidErrorMessages.xlsx");

        FATCASelfCertificationForm()
                .chooseIfPayUSAnnualIncome(registrationInfo.getYesAnswer())
                .checkForUSNative(registrationInfo.getYesAnswer())
                .haveUsFinancialInterestYesNo(registrationInfo.getYesAnswer())
                .enterUsFinancialInterestEstimatedValue(registrationInfo.getInvalidNumber())
                .enterUsFinancialInterestAnnualReturns(registrationInfo.getInvalidNumber())
                .enterUSFinancialInterestProfitsResulting(registrationInfo.getInvalidNumber())
                .haveUsFamilyCitizentYesNoYesNo(registrationInfo.getYesAnswer())
                .haveUsVisitedYesNo(registrationInfo.getYesAnswer())
                .haveUsResideYesNo(registrationInfo.getYesAnswer())
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }
}

