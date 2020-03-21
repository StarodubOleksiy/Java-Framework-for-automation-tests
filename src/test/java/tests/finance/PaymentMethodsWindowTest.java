package tests.finance;

import data.RegistrationInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import tests.BaseTestWithBrowserRetention;
import utils.ExcelUtils;

import java.util.List;

import static data.LoggedUserData.*;

public class PaymentMethodsWindowTest extends BaseTestWithBrowserRetention {

    RegistrationInfo registrationInfo = new RegistrationInfo();
    private boolean needToCancel = false;

    @BeforeClass
    public void login() {
        STELoginPage().quickLogin(userPhone3, defaultPassword, defaultVerificationCode);
        STEDashboardPage()
                .clickFinancesLink();
        sleep(500);
    }

    @AfterMethod
    public void afterMethod() {
        if (needToCancel) {
            PaymentMethodsWindow().clickCancelButton();
            needToCancel = false;
        }
    }

    @TestCaseId("TC_Payment_Method_Window_001")
    @Description("Add payment method when USD currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test1addPaymentMethodUSDCurrency() throws Exception {
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("USD")
                .enterCorrespondentBankName(registrationInfo.getCompany())
                .enterCorrespondentBankSwift(registrationInfo.getSwift())
                .enterBeneficiaryBankName(registrationInfo.getCompany())
                .enterBeneficiaryBankSwift(registrationInfo.getSwift())
                .enterBeneficiaryBank(registrationInfo.getCompany())
                .enterBeneficiaryBankAccountNumber(registrationInfo.getStringNumber())
                .enterBeneficiaryBankIbanCode(registrationInfo.getStringNumber())
                .enterPaymentDetails(registrationInfo.getReason())
                .uploadProofOfAffiliation(registrationInfo.getProofOfAffiliation())
                .clickAddButton()
                .isVerificationIconIsPresent()
                .verifyBankAccountName(registrationInfo.getCompany());
        needToCancel = false;
    }

    @TestCaseId("TC_Payment_Method_Window_002")
    @Description("Add payment method when EUR currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test2addPaymentMethodEURCurrency() throws Exception {
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("EUR")
                .enterCorrespondentBankName(registrationInfo.getCompany())
                .enterCorrespondentBankSwift(registrationInfo.getSwift())
                .enterBeneficiaryBankName(registrationInfo.getCompany())
                .enterBeneficiaryBankSwift(registrationInfo.getSwift())
                .enterBeneficiaryBank(registrationInfo.getCompany())
                .enterBeneficiaryBankAccountNumber(registrationInfo.getStringNumber())
                .enterBeneficiaryBankIbanCode(registrationInfo.getStringNumber())
                .enterPaymentDetails(registrationInfo.getReason())
                .uploadProofOfAffiliation(registrationInfo.getProofOfAffiliation())
                .clickAddButton()
                .isVerificationIconIsPresent()
                .verifyBankAccountName(registrationInfo.getCompany());
        needToCancel = false;

    }

    @TestCaseId("TC_Payment_Method_Window_003")
    @Description("Add payment method when RUB currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test3addPaymentMethodRUBCurrency() throws Exception {
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("RUB")
                .clickRussianBankCheckBox()
                .enterRusBankBik(registrationInfo.getNineDigitNumber())
                .enterRusBankBeneficiaryBank(registrationInfo.getCompany())
                .enterRusBankCorrBankAccount(registrationInfo.getStringNumber())
                .enterRusBankBankAddress(registrationInfo.getStreet())
                .enterRusBankBeneficiaryName(registrationInfo.getCompany())
                .enterRusBankBeneficiaryAddress(registrationInfo.getStreet())
                .enterRusBankBeneficiaryAccountNo(registrationInfo.getStringNumber())
                .enterRusBankBeneficiaryTaxCode(registrationInfo.getTenDigitNumber())
                .enterRusBankKppCode(registrationInfo.getNineDigitNumber())
                .enterRusBankVoCode(registrationInfo.getFiveDigitNumber())
                .enterPaymentDetails(registrationInfo.getReason())
                .uploadProofOfAffiliation(registrationInfo.getProofOfAffiliation())
                .clickAddButton()
                .isVerificationIconIsPresent()
                .verifyBankAccountName(registrationInfo.getCompany());
        needToCancel = false;

    }

    @TestCaseId("TC_Payment_Method_Window_004")
    @Description("Verify if swift code is incorrect")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test4swiftCodeIsNotCorrect() throws Exception {
        needToCancel = true;

        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/testPaymentMethodsWindowInvalidSwift.xlsx");
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("USD")
                .enterCorrespondentBankName("1")
                .enterCorrespondentBankSwift("1")
                .enterBeneficiaryBankName("1")
                .enterBeneficiaryBankSwift("1")
                .enterBeneficiaryBank("1")
                .enterBeneficiaryBankAccountNumber("1")
                .enterBeneficiaryBankIbanCode("1")
                .enterPaymentDetails("1")
                .uploadProofOfAffiliation(registrationInfo.getProofOfAffiliation())
                .clickAddButton()
                .validateErrorMessagesArePresent(expectedErrorMessages)
                .clickCancelButton();
        needToCancel = false;
    }


    @TestCaseId("TC_Payment_Method_Window_005")
    @Description("Verify if all fields are empty when USD currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test5allFieldsAreEmptyUSDCurrency() throws Exception {
        needToCancel = true;

        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/testPaymentMethodsWindowEmptyFields.xlsx");
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("USD")
                .clickAddButton()
                .validateErrorMessagesArePresent(expectedErrorMessages)
                .clickCancelButton();
        needToCancel = false;
    }


    @TestCaseId("TC_Payment_Method_Window_006")
    @Description("Add payment method when RUB currency selected and fields are empty")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test6allFieldsAreEmptyRUBCurrency() throws Exception {
        needToCancel = true;

        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/testPaymentMethodsWindowRusCurrencyEmptyFields.xlsx");
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("RUB")
                .clickRussianBankCheckBox()
                .clickAddButton()
                .validateErrorMessagesArePresent(expectedErrorMessages)
                .clickCancelButton();
        needToCancel = false;
    }


    @TestCaseId("TC_Payment_Method_Window_007")
    @Description("Verify if all fields are empty when EUR currency selected")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test7allFieldsAreEmptyEURCurrency() throws Exception {
        needToCancel = true;

        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/testPaymentMethodsWindowEmptyFields.xlsx");
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("EUR")
                .clickAddButton()
                .validateErrorMessagesArePresent(expectedErrorMessages)
                .clickCancelButton();
        needToCancel = false;
    }

    @TestCaseId("TC_Payment_Method_Window_008")
    @Description("Add payment method when RUB currency selected and fields are filled incorrectly")
    @Features("Stone Edge Trading Finances page")
    @Test()
    public void test8addPaymentMethodRUBCurrencyInvalidFilledFields() throws Exception {
        needToCancel = true;

        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("Excel Files/testPaymentMethodsWindowRusCurrencyInvalidFields.xlsx");
        PaymentMethodsWindow()
                .clickAddPaymentMethodButton()
                .specifyCurrency("RUB")
                .clickRussianBankCheckBox()
                .enterRusBankBik("1")
                .enterRusBankBeneficiaryBank("1")
                .enterRusBankCorrBankAccount("1")
                .enterRusBankBankAddress("1")
                .enterRusBankBeneficiaryName("1")
                .enterRusBankBeneficiaryAddress("1")
                .enterRusBankBeneficiaryAccountNo("1")
                .enterRusBankBeneficiaryTaxCode("1")
                .enterRusBankKppCode("1")
                .enterRusBankVoCode("1")
                .enterPaymentDetails("1")
                .uploadProofOfAffiliation(registrationInfo.getProofOfAffiliation())
                .clickAddButton()
                .validateErrorMessagesArePresent(expectedErrorMessages)
                .clickCancelButton();
        needToCancel = false;
    }

}
