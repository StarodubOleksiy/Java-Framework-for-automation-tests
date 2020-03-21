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


public class FinancialStatusAndExperiencePage extends BaseTest {

    private RegistrationInfo registrationInfo;

    @BeforeMethod
    public void before() throws Exception {

        registrationInfo = new RegistrationInfo();

        STESignupPage().fillInRequiredFields(registrationInfo).clickNextStepButton();;

        OpenAccountForm().fillInRequiredFields(registrationInfo).clickOpenAccountButton();

        OpeningAnAccountForm().clickPersonalButton().clickNextStepButton();

        CustomerInformationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();;

        CRSSelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();;

        FATCASelfCertificationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();;

        EducationAndOccupationForm().fillInRequiredFields(registrationInfo).clickNextStepButton();;

        PoliticallyExposedPersonsForm().fillInRequiredFields(registrationInfo).clickNextStepButton();;

        InvestmentProfileForm().fillInRequiredFields(registrationInfo).clickNextStepButton();;
    }

    @TestCaseId("TC_Individual_Registration_Financial_Status_And_Experience_001")
    @Description("Verify error messages for empty required fields on Financial status and experience form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testFinancialStatusAndExperienceFormEmptyFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/FinancialStatusAndExperienceEmptyErrorMessages.xlsx");

        FinancialStatusAndExperienceForm()
                .enterEarnings("")
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }


    @TestCaseId("TC_Individual_Registration_Financial_Status_And_Experience_001")
    @Description("Verify error messages for invalid and empty required fields on Financial status and experience form of Stone Edge Trading application")
    @Features("Stone Edge Trading individual registration")
    @Test
    public void testFinancialStatusAndExperienceFormEmptyInvalidFields() throws Exception {
        List<String> expectedErrorMessages = ExcelUtils.getExpectedErrorMessages("registration/FinancialStatusAndExperienceEmptyInvalidErrorMessages.xlsx");

        FinancialStatusAndExperienceForm()
                .enterEarnings(registrationInfo.getInvalidNumber())
                .enterMonthlyIncome(registrationInfo.getInvalidNumber())
                .enterTotalLiabilities(registrationInfo.getInvalidNumber())
                .enterFundsAvailable(registrationInfo.getInvalidNumber())
                .enterCryptoCurrentValue(registrationInfo.getInvalidNumber())
                .enterCryptoPastYearSize(registrationInfo.getInvalidNumber())
                .enterCryptoLastYearAverage(registrationInfo.getInvalidNumber())
                .enterOptionsCurrentValue(registrationInfo.getInvalidNumber())
                .enterOptionsPastYearSize(registrationInfo.getInvalidNumber())
                .enterOptionsLastYearAverage(registrationInfo.getInvalidNumber())
                .enterSecuritiesCurrentValue(registrationInfo.getInvalidNumber())
                .enterSecuritiesPastYearSize(registrationInfo.getInvalidNumber())
                .enterSecuritiesLastYearAverage(registrationInfo.getInvalidNumber())
                .enterInterestRatesCurrentValue(registrationInfo.getInvalidNumber())
                .enterInterestRatesPastYearSize(registrationInfo.getInvalidNumber())
                .enterInterestRatesLastYearAverage(registrationInfo.getInvalidNumber())
                .enterDerivativesCurrentValue(registrationInfo.getInvalidNumber())
                .enterDerivativesPastYearSize(registrationInfo.getInvalidNumber())
                .enterDerivativesLastYearAverage(registrationInfo.getInvalidNumber())
                .enterDepositsCurrentValue(registrationInfo.getInvalidNumber())
                .enterDepositsPastYearSize(registrationInfo.getInvalidNumber())
                .enterDepositsLastYearAverage(registrationInfo.getInvalidNumber())
                .enterMoneyMarketsCurrentValue(registrationInfo.getInvalidNumber())
                .enterMoneyMarketsPastYearSize(registrationInfo.getInvalidNumber())
                .enterMoneyMarketsLastYearAverage(registrationInfo.getInvalidNumber())
                .enterDepositaryCurrentValue(registrationInfo.getInvalidNumber())
                .enterDepositaryPastYearSize(registrationInfo.getInvalidNumber())
                .enterDepositaryLastYearAverage(registrationInfo.getInvalidNumber())
                .enterBondsCurrentValue(registrationInfo.getInvalidNumber())
                .enterBondsPastYearSize(registrationInfo.getInvalidNumber())
                .enterBondsLastYearAverage(registrationInfo.getInvalidNumber())
                .enterUnitsCurrentValue(registrationInfo.getInvalidNumber())
                .enterUnitsPastYearSize(registrationInfo.getInvalidNumber())
                .enterUnitsLastYearAverage(registrationInfo.getInvalidNumber())
                .enterOtherInstrumentsCurrentValue(registrationInfo.getInvalidNumber())
                .enterOtherInstrumentsPastYearSize(registrationInfo.getInvalidNumber())
                .enterOtherInstrumentsLastYearAverage(registrationInfo.getInvalidNumber())
                .clickNextStepButton()
                .validateErrorMessagesArePresent(expectedErrorMessages);
    }

}
