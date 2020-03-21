package pageObjects.pages.registration;


import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class InvestmentProfileForm extends IndividualVerificationBase {

    @FindBy(xpath = "//label[contains(.,'USD')]")
    private WebElement currencyUSD;

    @FindBy(xpath = "//label[contains(.,'EUR')]")
    private WebElement currencyEUR;

    @FindBy(xpath = "//label[contains(text(),'Long term investments')]")
    private WebElement longTermInvestmentsCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Short term investments')]")
    private WebElement shortTermInvestmentsCheckBox;

    @FindBy(xpath = "//label[contains(text(),'Current income')]")
    private WebElement currentIncomeCheckBox;

    @FindBy(xpath = "//label[input[@name='frequencyOfProspective']]")
    private List<WebElement> frequencyOfProspectiveRadioButton;

    @FindBy(xpath = "//label[input[@name='intendedAmount']]")
    private List<WebElement> intendedAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='accountTurnover']]")
    private List<WebElement> accountTurnoverRadioButton;

    @FindBy(xpath = "//label[input[@name='riskLevel']]")
    private List<WebElement> riskLevelRadioButton;

    @FindBy(xpath = "//input[@name='anyInvestments']")
    private WebElement anyInvestments;


    @Step("Specify all amounts in answers in (USD, EUR)  {0}")
    public InvestmentProfileForm specifyCurrency(String currencyType) {
        scrollIntoView(currencyEUR);
        switch (currencyType) {
            case "EUR":
                currencyEUR.click();
                break;
            case "USD":
                currencyUSD.click();
                break;
        }
        return this;
    }

    @Step("Check long term investments")
    public InvestmentProfileForm checkLongTermInvestments() {
        scrollIntoView(longTermInvestmentsCheckBox);
        longTermInvestmentsCheckBox.click();
        return this;
    }

    @Step("Check short term investments")
    public InvestmentProfileForm checkShortTermInvestments() {
        scrollIntoView(shortTermInvestmentsCheckBox);
        shortTermInvestmentsCheckBox.click();
        return this;
    }

    @Step("Check current income")
    public InvestmentProfileForm checkCurrentIncome() {
        scrollIntoView(currentIncomeCheckBox);
        currentIncomeCheckBox.click();
        return this;
    }

    @Step("Checking Frequency of prospective financial transaction {0}")
    public InvestmentProfileForm checkFrequencyOfProspectiveFinancialTransaction(String value) {
        scrollIntoView(frequencyOfProspectiveRadioButton.get(0));
        frequencyOfProspectiveRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Checking intend to invest amount {0}")
    public InvestmentProfileForm checkIntendedToInvestAmount(String value) {
        scrollIntoView(intendedAmountRadioButton.get(0));
        intendedAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Checking anticipated account turnover {0}")
    public InvestmentProfileForm checkAnticipatedAccountTurnover(String value) {
        scrollIntoView(accountTurnoverRadioButton.get(0));
        accountTurnoverRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Checking Level of risk willing to take {0}")
    public InvestmentProfileForm checkLevelOfRiskWillingToTake(String value) {
        scrollIntoView(riskLevelRadioButton.get(0));
        riskLevelRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter any investments to avoid {0}")
    public InvestmentProfileForm enterInvestmentsToAvoid(String value) {
        scrollIntoView(anyInvestments);
        anyInvestments.sendKeys(value);
        return this;
    }

    public InvestmentProfileForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.specifyCurrency(registrationInfo.getCurrency())
                .checkLongTermInvestments()
                .checkFrequencyOfProspectiveFinancialTransaction(registrationInfo.getFrequencyOfProspectiveFinancialTransaction())
                .checkIntendedToInvestAmount(registrationInfo.getIntendedToInvestAmount())
                .checkAnticipatedAccountTurnover(registrationInfo.getAnticipatedAccountTurnover())
                .checkLevelOfRiskWillingToTake(registrationInfo.getLevelOfRiskWillingToTake())
                .enterInvestmentsToAvoid(registrationInfo.getSentence());
        return this;
    }
}
