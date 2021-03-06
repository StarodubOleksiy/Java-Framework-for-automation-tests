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

public class EducationAndOccupationRegistrationPage extends BaseTest {

    private RegistrationInfo registrationInfo = new RegistrationInfo();

    @BeforeMethod
    public void before() {

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        CRSSelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();

        FATCASelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_Education_And_Occupation_001")
    @Description("Verify error messages for empty required fields on Education and occupation form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testEducationAndOccupationFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/EducationAndOccupationEmptyErrorMessages.xlsx");

        EducationAndOccupationForm()
                .enterNameOfEmployer("")
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

}
