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

public class CustomerInformationPage extends BaseTest {
    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() {
        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();
    }

    @TestCaseId("TC_Individual_Registration_Customer_Information_001")
    @Description("Verify error messages for empty required fields on customer information of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testCustomerInformationFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/CustomerInformationFormEmptyErrorMessages.xlsx");

        CustomerInformationForm()
                .enterDateOfBirthInput("")
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

    @TestCaseId("TC_Individual_Registration_Customer_Information_002")
    @Description("Verify error messages for empty required fields and invalid fields on customer information of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testCustomerInformationFormInvalidAndEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/CustomerInformationFormEmptyAndRequiredErrorMessages.xlsx");

        CustomerInformationForm().enterPhoneNumber(registrationInfo.getInvalidNumber())
                .enterAdditionalPhoneNumber(registrationInfo.getInvalidNumber())
                .enterFaxNumber(registrationInfo.getInvalidNumber())
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }
}
