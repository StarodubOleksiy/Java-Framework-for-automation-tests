package pageObjects.pages.registration;

import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FinancialStatusAndExperienceForm extends IndividualVerificationBase {

    @FindBy(xpath = "//label[contains(.,'USD')]")
    private WebElement currencyUSD;

    @FindBy(xpath = "//label[contains(.,'EUR')]")
    private WebElement currencyEUR;

    @FindBy(xpath = "//input[@name='earnings']")
    private WebElement earnings;

    @FindBy(xpath = "//input[@name='monthlyIncome']")
    private WebElement monthlyIncome;

    @FindBy(xpath = "//input[@name='totalLiabilities']")
    private WebElement totalLiabilities;

    @FindBy(xpath = "//input[@name='fundsAvailable']")
    private WebElement fundsAvailable;

    @FindBy(xpath = "//label[input[@name='cryptoKnowledge']]")
    private List<WebElement> cryptoKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='optionsKnowledge']]")
    private List<WebElement> optionsKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='securitiesKnowledge']]")
    private List<WebElement> securitiesKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='currenciesKnowledge']]")
    private List<WebElement> currenciesKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='derivativesKnowledge']]")
    private List<WebElement> derivativesKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='depositsKnowledge']]")
    private List<WebElement> depositsKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='moneyMarketsKnowledge']]")
    private List<WebElement> moneyMarketsKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='depositaryKnowledge']]")
    private List<WebElement> depositaryKnowledgeRadioButton;
    //bondsKnowledge
    @FindBy(xpath = "//label[input[@name='bondsKnowledge']]")
    private List<WebElement> bondsKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='unitsKnowledge']]")
    private List<WebElement> unitsKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='otherInstrumentsKnowledge']]")
    private List<WebElement> otherInstrumentsKnowledgeRadioButton;

    @FindBy(xpath = "//label[input[@name='cryptoSource']]")
    private List<WebElement> cryptoSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='optionsSource']]")
    private List<WebElement> optionsSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='securitiesSource']]")
    private List<WebElement> securitiesSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='currenciesSource']]")
    private List<WebElement> currenciesSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='derivativesSource']]")
    private List<WebElement> derivativesSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='depositsSource']]")
    private List<WebElement> depositsSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='moneyMarketsSource']]")
    private List<WebElement> moneyMarketsSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='depositarySource']]")
    private List<WebElement> depositarySourceRadioButton;

    @FindBy(xpath = "//label[input[@name='bondsSource']]")
    private List<WebElement> bondsSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='unitsSource']]")
    private List<WebElement> unitsSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='otherInstrumentsSource']]")
    private List<WebElement> otherInstrumentsSourceRadioButton;

    @FindBy(xpath = "//label[input[@name='cryptoAmount']]")
    private List<WebElement> cryptoAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='optionsAmount']]")
    private List<WebElement> optionsAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='securitiesAmount']]")
    private List<WebElement> securitiesAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='currenciesAmount']]")
    private List<WebElement> currenciesAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='derivativesAmount']]")
    private List<WebElement> derivativesAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='depositsAmount']]")
    private List<WebElement> depositsAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='moneyMarketsAmount']]")
    private List<WebElement> moneyMarketsAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='depositaryAmount']]")
    private List<WebElement> depositaryAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='bondsAmount']]")
    private List<WebElement> bondsAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='unitsAmount']]")
    private List<WebElement> unitsAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='otherInstrumentsAmount']]")
    private List<WebElement> otherInstrumentsAmountRadioButton;

    @FindBy(xpath = "//label[input[@name='cryptoDuration']]")
    private List<WebElement> cryptoDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='optionsDuration']]")
    private List<WebElement> optionsDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='securitiesDuration']]")
    private List<WebElement> securitiesDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='currenciesDuration']]")
    private List<WebElement> currenciesDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='derivativesDuration']]")
    private List<WebElement> derivativesDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='depositsDuration']]")
    private List<WebElement> depositsDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='moneyMarketsDuration']]")
    private List<WebElement> moneyMarketsDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='depositaryDuration']]")
    private List<WebElement> depositaryDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='bondsDuration']]")
    private List<WebElement> bondsDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='unitsDuration']]")
    private List<WebElement> unitsDurationRadioButton;

    @FindBy(xpath = "//label[input[@name='otherInstrumentsDuration']]")
    private List<WebElement> otherInstrumentsDurationRadioButton;

    @FindBy(xpath = "//input[@name='cryptoCurrentValue']")
    private WebElement cryptoCurrentValue;

    @FindBy(xpath = "//input[@name='cryptoPastYearSize']")
    private WebElement cryptoPastYearSize;

    @FindBy(xpath = "//input[@name='cryptoLastYearAverage']")
    private WebElement cryptoLastYearAverage;

    @FindBy(xpath = "//input[@name='optionsCurrentValue']")
    private WebElement optionsCurrentValue;

    @FindBy(xpath = "//input[@name='optionsPastYearSize']")
    private WebElement optionsPastYearSize;

    @FindBy(xpath = "//input[@name='optionsLastYearAverage']")
    private WebElement optionsLastYearAverage;

    @FindBy(xpath = "//input[@name='securitiesCurrentValue']")
    private WebElement securitiesCurrentValue;

    @FindBy(xpath = "//input[@name='securitiesPastYearSize']")
    private WebElement securitiesPastYearSize;

    @FindBy(xpath = "//input[@name='securitiesLastYearAverage']")
    private WebElement securitiesLastYearAverage;

    @FindBy(xpath = "//input[@name='interestRatesCurrentValue']")
    private WebElement interestRatesCurrentValue;

    @FindBy(xpath = "//input[@name='interestRatesPastYearSize']")
    private WebElement interestRatesPastYearSize;

    @FindBy(xpath = "//input[@name='interestRatesLastYearAverage']")
    private WebElement interestRatesLastYearAverage;

    @FindBy(xpath = "//input[@name='derivativesCurrentValue']")
    private WebElement derivativesCurrentValue;

    @FindBy(xpath = "//input[@name='derivativesPastYearSize']")
    private WebElement derivativesPastYearSize;

    @FindBy(xpath = "//input[@name='derivativesLastYearAverage']")
    private WebElement derivativesLastYearAverage;

    @FindBy(xpath = "//input[@name='depositsCurrentValue']")
    private WebElement depositsCurrentValue;

    @FindBy(xpath = "//input[@name='depositsPastYearSize']")
    private WebElement depositsPastYearSize;

    @FindBy(xpath = "//input[@name='depositsLastYearAverage']")
    private WebElement depositsLastYearAverage;

    @FindBy(xpath = "//input[@name='moneyMarketsCurrentValue']")
    private WebElement moneyMarketsCurrentValue;

    @FindBy(xpath = "//input[@name='moneyMarketsPastYearSize']")
    private WebElement moneyMarketsPastYearSize;

    @FindBy(xpath = "//input[@name='moneyMarketsLastYearAverage']")
    private WebElement moneyMarketsLastYearAverage;

    @FindBy(xpath = "//input[@name='depositaryCurrentValue']")
    private WebElement depositaryCurrentValue;

    @FindBy(xpath = "//input[@name='depositaryPastYearSize']")
    private WebElement depositaryPastYearSize;

    @FindBy(xpath = "//input[@name='depositaryLastYearAverage']")
    private WebElement depositaryLastYearAverage;

    @FindBy(xpath = "//input[@name='bondsCurrentValue']")
    private WebElement bondsCurrentValue;

    @FindBy(xpath = "//input[@name='bondsPastYearSize']")
    private WebElement bondsPastYearSize;

    @FindBy(xpath = "//input[@name='bondsLastYearAverage']")
    private WebElement bondsLastYearAverage;

    @FindBy(xpath = "//input[@name='unitsCurrentValue']")
    private WebElement unitsCurrentValue;

    @FindBy(xpath = "//input[@name='unitsPastYearSize']")
    private WebElement unitsPastYearSize;

    @FindBy(xpath = "//input[@name='unitsLastYearAverage']")
    private WebElement unitsLastYearAverage;

    @FindBy(xpath = "//input[@name='otherInstrumentsCurrentValue']")
    private WebElement otherInstrumentsCurrentValue;

    @FindBy(xpath = "//input[@name='otherInstrumentsPastYearSize']")
    private WebElement otherInstrumentsPastYearSize;

    @FindBy(xpath = "//input[@name='otherInstrumentsLastYearAverage']")
    private WebElement otherInstrumentsLastYearAverage;

    @Step("Specify all amounts in answers in (USD, EUR)  {0}")
    public FinancialStatusAndExperienceForm specifyCurrency(String currencyType) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyUSD);
        scrollIntoView(currencyEUR);
        switch (currencyType) {
            case "EUR":
                //utils.FluentWaiting.waitUntillElementToBeClickable(10, 500, currencyEUR);
                currencyEUR.click();
                break;
            case "USD":
                //utils.FluentWaiting.waitUntillElementToBeClickable(10, 500, currencyUSD);
                currencyUSD.click();
                break;
        }
        return this;
    }

    @Step("Fill in earnings {0}")
    public FinancialStatusAndExperienceForm enterEarnings(String text) {
        earnings.sendKeys(text);
        return this;
    }

    @Step("Fill in monthly income {0}")
    public FinancialStatusAndExperienceForm enterMonthlyIncome(String text) {
        monthlyIncome.sendKeys(text);
        return this;
    }

    @Step("Fill in monthly income {0}")
    public FinancialStatusAndExperienceForm enterTotalLiabilities(String text) {
        scrollIntoView(totalLiabilities);
        totalLiabilities.sendKeys(text);
        return this;
    }

    @Step("Fill in funds available for investment {0}")
    public FinancialStatusAndExperienceForm enterFundsAvailable(String text) {
        scrollIntoView(fundsAvailable);
        fundsAvailable.sendKeys(text);
        return this;
    }

    @Step("Check for cryptocurrencies  {0}")
    public FinancialStatusAndExperienceForm checkCryptoCurrenciesKnowledge(String value) {
        scrollIntoView(cryptoKnowledgeRadioButton.get(0));
        cryptoKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for options  {0}")
    public FinancialStatusAndExperienceForm checkOptionsKnowledge(String status) {
        scrollIntoView(optionsKnowledgeRadioButton.get(0));
        optionsKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for securities {0}")
    public FinancialStatusAndExperienceForm checkSecuritiesKnowledge(String status) {
        scrollIntoView(securitiesKnowledgeRadioButton.get(0));
        securitiesKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for currencies {0}")
    public FinancialStatusAndExperienceForm checkCurrenciesKnowledge(String status) {
        scrollIntoView(currenciesKnowledgeRadioButton.get(0));
        currenciesKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for derivatives {0}")
    public FinancialStatusAndExperienceForm checkDerivativesKnowledge(String status) {
        scrollIntoView(derivativesKnowledgeRadioButton.get(0));
        derivativesKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for deposits {0}")
    public FinancialStatusAndExperienceForm checkDepositsKnowledge(String status) {
        scrollIntoView(depositsKnowledgeRadioButton.get(0));
        depositsKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for money of markets {0}")
    public FinancialStatusAndExperienceForm checkMoneyMarketsKnowledge(String status) {
        scrollIntoView(moneyMarketsKnowledgeRadioButton.get(0));
        moneyMarketsKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for depositary receipts {0}")
    public FinancialStatusAndExperienceForm checkDepositaryKnowledge(String status) {
        scrollIntoView(depositaryKnowledgeRadioButton.get(0));
        depositaryKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for bonds {0}")
    public FinancialStatusAndExperienceForm checkBondsKnowledge(String status) {
        scrollIntoView(bondsKnowledgeRadioButton.get(0));
        bondsKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for units {0}")
    public FinancialStatusAndExperienceForm checkUnitsKnowledge(String status) {
        scrollIntoView(unitsKnowledgeRadioButton.get(0));
        unitsKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for other instruments {0}")
    public FinancialStatusAndExperienceForm checkOtherInstrumentsKnowledge(String status) {
        scrollIntoView(otherInstrumentsKnowledgeRadioButton.get(0));
        otherInstrumentsKnowledgeRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for cryptocurrencies {0}")
    public FinancialStatusAndExperienceForm checkCryptoSource(String status) {
        scrollIntoView(cryptoSourceRadioButton.get(0));
        cryptoSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for options, futures, swaps, forwards, other derivatives {0}")
    public FinancialStatusAndExperienceForm checkOptionsSource(String status) {
        scrollIntoView(optionsSourceRadioButton.get(0));
        optionsSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for securities source {0}")
    public FinancialStatusAndExperienceForm checkSecuritiesSource(String status) {
        scrollIntoView(securitiesSourceRadioButton.get(0));
        securitiesSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for currencies, interest rates source {0}")
    public FinancialStatusAndExperienceForm checkCurrenciesSource(String status) {
        scrollIntoView(currenciesSourceRadioButton.get(0));
        currenciesSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for derivatives on commodities {0}")
    public FinancialStatusAndExperienceForm checkDerivativesSource(String status) {
        scrollIntoView(derivativesSourceRadioButton.get(0));
        derivativesSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for deposits source {0}")
    public FinancialStatusAndExperienceForm checkDepositsSource(String status) {
        scrollIntoView(depositsSourceRadioButton.get(0));
        depositsSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for money market instruments {0}")
    public FinancialStatusAndExperienceForm checkMoneyMarketsSource(String status) {
        scrollIntoView(moneyMarketsSourceRadioButton.get(0));
        moneyMarketsSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for depositary receipts {0}")
    public FinancialStatusAndExperienceForm checkDepositarySource(String status) {
        scrollIntoView(depositarySourceRadioButton.get(0));
        depositarySourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for bonds or other securitised debt {0}")
    public FinancialStatusAndExperienceForm checkBondsSource(String status) {
        scrollIntoView(bondsSourceRadioButton.get(0));
        bondsSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for units source {0}")
    public FinancialStatusAndExperienceForm checkUnitsSource(String status) {
        scrollIntoView(unitsSourceRadioButton.get(0));
        unitsSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for other non-complex financial instruments {0}")
    public FinancialStatusAndExperienceForm checkOtherInstrumentsSource(String status) {
        scrollIntoView(otherInstrumentsSourceRadioButton.get(0));
        otherInstrumentsSourceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for cryptocurrencies amount {0}")
    public FinancialStatusAndExperienceForm checkCryptoAmount(String status) {
        scrollIntoView(cryptoAmountRadioButton.get(0));
        cryptoAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for options, futures, swaps, forwards, other derivatives {0}")
    public FinancialStatusAndExperienceForm checkOptionsAmount(String status) {
        scrollIntoView(optionsAmountRadioButton.get(0));
        optionsAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for securities amount {0}")
    public FinancialStatusAndExperienceForm checkSecuritiesAmount(String status) {
        scrollIntoView(securitiesAmountRadioButton.get(0));
        securitiesAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for Currencies, interest rates amount {0}")
    public FinancialStatusAndExperienceForm checkCurrenciesAmount(String status) {
        scrollIntoView(currenciesAmountRadioButton.get(0));
        currenciesAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for derivatives on commodities amount {0}")
    public FinancialStatusAndExperienceForm checkDerivativesAmount(String status) {
        scrollIntoView(derivativesAmountRadioButton.get(0));
        derivativesAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for deposits amount {0}")
    public FinancialStatusAndExperienceForm checkDepositsAmount(String status) {
        scrollIntoView(depositsAmountRadioButton.get(0));
        depositsAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for money markets amount {0}")
    public FinancialStatusAndExperienceForm checkMoneyMarketsAmount(String status) {
        scrollIntoView(moneyMarketsAmountRadioButton.get(0));
        moneyMarketsAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for depositary receipts amount {0}")
    public FinancialStatusAndExperienceForm checkDepositaryAmount(String status) {
        scrollIntoView(depositaryAmountRadioButton.get(0));
        depositaryAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for bonds or other securitised debt amount {0}")
    public FinancialStatusAndExperienceForm checkBondsAmount(String status) {
        scrollIntoView(bondsAmountRadioButton.get(0));
        bondsAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for units amount {0}")
    public FinancialStatusAndExperienceForm checkUnitsAmount(String status) {
        scrollIntoView(unitsAmountRadioButton.get(0));
        unitsAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for other non-complex financial instruments amount {0}")
    public FinancialStatusAndExperienceForm checkOtherInstrumentsAmount(String status) {
        scrollIntoView(otherInstrumentsAmountRadioButton.get(0));
        otherInstrumentsAmountRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for crypto duration {0}")
    public FinancialStatusAndExperienceForm checkCryptoDuration(String status) {
        scrollIntoView(cryptoDurationRadioButton.get(0));
        cryptoDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for options duration {0}")
    public FinancialStatusAndExperienceForm checkOptionsDuration(String status) {
        scrollIntoView(optionsDurationRadioButton.get(0));
        optionsDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for securities duration {0}")
    public FinancialStatusAndExperienceForm checkSecuritiesDuration(String status) {
        scrollIntoView(securitiesDurationRadioButton.get(0));
        securitiesDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for currencies duration {0}")
    public FinancialStatusAndExperienceForm checkCurrenciesDuration(String status) {
        scrollIntoView(currenciesDurationRadioButton.get(0));
        currenciesDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for derivatives duration {0}")
    public FinancialStatusAndExperienceForm checkDerivativesDuration(String status) {
        scrollIntoView(derivativesDurationRadioButton.get(0));
        derivativesDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for deposits duration {0}")
    public FinancialStatusAndExperienceForm checkDepositsDuration(String status) {
        scrollIntoView(depositsDurationRadioButton.get(0));
        depositsDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for money markets duration {0}")
    public FinancialStatusAndExperienceForm checkMoneyMarketsDuration(String status) {
        scrollIntoView(moneyMarketsDurationRadioButton.get(0));
        moneyMarketsDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for depositary duration {0}")
    public FinancialStatusAndExperienceForm checkDepositaryDuration(String status) {
        scrollIntoView(depositaryDurationRadioButton.get(0));
        depositaryDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for bonds duration {0}")
    public FinancialStatusAndExperienceForm checkBondsDuration(String status) {
        scrollIntoView(bondsDurationRadioButton.get(0));
        bondsDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for units duration {0}")
    public FinancialStatusAndExperienceForm checkUnitsDuration(String status) {
        scrollIntoView(unitsDurationRadioButton.get(0));
        unitsDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for other instruments duration {0}")
    public FinancialStatusAndExperienceForm checkOtherInstrumentsDuration(String status) {
        scrollIntoView(otherInstrumentsDurationRadioButton.get(0));
        otherInstrumentsDurationRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter the crypto current value {0}")
    public FinancialStatusAndExperienceForm enterCryptoCurrentValue(String text) {
        scrollIntoView(cryptoCurrentValue);
        cryptoCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of crypto in last year {0}")
    public FinancialStatusAndExperienceForm enterCryptoPastYearSize(String text) {
        scrollIntoView(cryptoPastYearSize);
        cryptoPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of crypto in last year {0}")
    public FinancialStatusAndExperienceForm enterCryptoLastYearAverage(String text) {
        scrollIntoView(cryptoLastYearAverage);
        cryptoLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the options of current value {0}")
    public FinancialStatusAndExperienceForm enterOptionsCurrentValue(String text) {
        scrollIntoView(optionsCurrentValue);
        optionsCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of options past year {0}")
    public FinancialStatusAndExperienceForm enterOptionsPastYearSize(String text) {
        scrollIntoView(optionsPastYearSize);
        optionsPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of options past year {0}")
    public FinancialStatusAndExperienceForm enterOptionsLastYearAverage(String text) {
        scrollIntoView(optionsLastYearAverage);
        optionsLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the securities of current value {0}")
    public FinancialStatusAndExperienceForm enterSecuritiesCurrentValue(String text) {
        scrollIntoView(securitiesCurrentValue);
        securitiesCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of securities past year {0}")
    public FinancialStatusAndExperienceForm enterSecuritiesPastYearSize(String text) {
        scrollIntoView(securitiesPastYearSize);
        securitiesPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of securities past year {0}")
    public FinancialStatusAndExperienceForm enterSecuritiesLastYearAverage(String text) {
        scrollIntoView(securitiesLastYearAverage);
        securitiesLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the interest rates of current value {0}")
    public FinancialStatusAndExperienceForm enterInterestRatesCurrentValue(String text) {
        scrollIntoView(interestRatesCurrentValue);
        interestRatesCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of interest rates past year {0}")
    public FinancialStatusAndExperienceForm enterInterestRatesPastYearSize(String text) {
        scrollIntoView(interestRatesPastYearSize);
        interestRatesPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of interest rates past year {0}")
    public FinancialStatusAndExperienceForm enterInterestRatesLastYearAverage(String text) {
        scrollIntoView(interestRatesLastYearAverage);
        interestRatesLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the derivatives of current value {0}")
    public FinancialStatusAndExperienceForm enterDerivativesCurrentValue(String text) {
        scrollIntoView(derivativesCurrentValue);
        derivativesCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of derivatives last year {0}")
    public FinancialStatusAndExperienceForm enterDerivativesPastYearSize(String text) {
        scrollIntoView(derivativesPastYearSize);
        derivativesPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of derivatives last year {0}")
    public FinancialStatusAndExperienceForm enterDerivativesLastYearAverage(String text) {
        scrollIntoView(derivativesLastYearAverage);
        derivativesLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the deposit of current value {0}")
    public FinancialStatusAndExperienceForm enterDepositsCurrentValue(String text) {
        scrollIntoView(depositsCurrentValue);
        depositsCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the deposit of size past year {0}")
    public FinancialStatusAndExperienceForm enterDepositsPastYearSize(String text) {
        scrollIntoView(depositsPastYearSize);
        depositsPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the deposit of average past year {0}")
    public FinancialStatusAndExperienceForm enterDepositsLastYearAverage(String text) {
        scrollIntoView(depositsLastYearAverage);
        depositsLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the monkey market current value {0}")
    public FinancialStatusAndExperienceForm enterMoneyMarketsCurrentValue(String text) {
        scrollIntoView(moneyMarketsCurrentValue);
        moneyMarketsCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of monkey market past year {0}")
    public FinancialStatusAndExperienceForm enterMoneyMarketsPastYearSize(String text) {
        scrollIntoView(moneyMarketsPastYearSize);
        moneyMarketsPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of monkey market past year {0}")
    public FinancialStatusAndExperienceForm enterMoneyMarketsLastYearAverage(String text) {
        scrollIntoView(moneyMarketsLastYearAverage);
        moneyMarketsLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the current value of depositary {0}")
    public FinancialStatusAndExperienceForm enterDepositaryCurrentValue(String text) {
        scrollIntoView(depositaryCurrentValue);
        depositaryCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the depositary of size past year {0}")
    public FinancialStatusAndExperienceForm enterDepositaryPastYearSize(String text) {
        scrollIntoView(depositaryPastYearSize);
        depositaryPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the depositary of average past year {0}")
    public FinancialStatusAndExperienceForm enterDepositaryLastYearAverage(String text) {
        scrollIntoView(depositaryLastYearAverage);
        depositaryLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the bonds of current value {0}")
    public FinancialStatusAndExperienceForm enterBondsCurrentValue(String text) {
        scrollIntoView(bondsCurrentValue);
        bondsCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the bonds size of past year {0}")
    public FinancialStatusAndExperienceForm enterBondsPastYearSize(String text) {
        scrollIntoView(bondsPastYearSize);
        bondsPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the bonds average of past year {0}")
    public FinancialStatusAndExperienceForm enterBondsLastYearAverage(String text) {
        scrollIntoView(bondsLastYearAverage);
        bondsLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the units of current value {0}")
    public FinancialStatusAndExperienceForm enterUnitsCurrentValue(String text) {
        scrollIntoView(unitsCurrentValue);
        unitsCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of units past year {0}")
    public FinancialStatusAndExperienceForm enterUnitsPastYearSize(String text) {
        scrollIntoView(unitsPastYearSize);
        unitsPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of units past year {0}")
    public FinancialStatusAndExperienceForm enterUnitsLastYearAverage(String text) {
        scrollIntoView(unitsLastYearAverage);
        unitsLastYearAverage.sendKeys(text);
        return this;
    }

    @Step("Enter the current value of other instruments {0}")
    public FinancialStatusAndExperienceForm enterOtherInstrumentsCurrentValue(String text) {
        scrollIntoView(otherInstrumentsCurrentValue);
        otherInstrumentsCurrentValue.sendKeys(text);
        return this;
    }

    @Step("Enter the size of other instruments past year {0}")
    public FinancialStatusAndExperienceForm enterOtherInstrumentsPastYearSize(String text) {
        scrollIntoView(otherInstrumentsCurrentValue);
        otherInstrumentsPastYearSize.sendKeys(text);
        return this;
    }

    @Step("Enter the average of other instruments past year {0}")
    public FinancialStatusAndExperienceForm enterOtherInstrumentsLastYearAverage(String text) {
        scrollIntoView(otherInstrumentsLastYearAverage);
        otherInstrumentsLastYearAverage.sendKeys(text);
        return this;
    }

    public FinancialStatusAndExperienceForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.specifyCurrency(registrationInfo.getCurrency())
                .enterEarnings(registrationInfo.getStringNumber())
                .enterMonthlyIncome(registrationInfo.getStringNumber())
                .enterTotalLiabilities(registrationInfo.getStringNumber())
                .enterFundsAvailable(registrationInfo.getStringNumber())
                .checkCryptoCurrenciesKnowledge(registrationInfo.getYesAnswer())
                .checkOptionsKnowledge(registrationInfo.getYesAnswer())
                .checkSecuritiesKnowledge(registrationInfo.getYesAnswer())
                .checkCurrenciesKnowledge(registrationInfo.getYesAnswer())
                .checkDerivativesKnowledge(registrationInfo.getYesAnswer())
                .checkDepositsKnowledge(registrationInfo.getYesAnswer())
                .checkMoneyMarketsKnowledge(registrationInfo.getYesAnswer())
                .checkDepositaryKnowledge(registrationInfo.getYesAnswer())
                .checkBondsKnowledge(registrationInfo.getYesAnswer())
                .checkUnitsKnowledge(registrationInfo.getYesAnswer())
                .checkOtherInstrumentsKnowledge(registrationInfo.getYesAnswer())
                .checkCryptoSource(registrationInfo.getKnowledge())
                .checkOptionsSource(registrationInfo.getKnowledge())
                .checkSecuritiesSource(registrationInfo.getKnowledge())
                .checkCurrenciesSource(registrationInfo.getKnowledge())
                .checkDerivativesSource(registrationInfo.getKnowledge())
                .checkDepositsSource(registrationInfo.getKnowledge())
                .checkMoneyMarketsSource(registrationInfo.getKnowledge())
                .checkDepositarySource(registrationInfo.getKnowledge())
                .checkBondsSource(registrationInfo.getKnowledge())
                .checkUnitsSource(registrationInfo.getKnowledge())
                .checkOtherInstrumentsSource(registrationInfo.getKnowledge())
                .checkCryptoAmount(registrationInfo.getAverageAmount())
                .checkOptionsAmount(registrationInfo.getAverageAmount())
                .checkSecuritiesAmount(registrationInfo.getAverageAmount())
                .checkCurrenciesAmount(registrationInfo.getAverageAmount())
                .checkDerivativesAmount(registrationInfo.getAverageAmount())
                .checkDepositsAmount(registrationInfo.getAverageAmount())
                .checkMoneyMarketsAmount(registrationInfo.getAverageAmount())
                .checkDepositaryAmount(registrationInfo.getAverageAmount())
                .checkBondsAmount(registrationInfo.getAverageAmount())
                .checkUnitsAmount(registrationInfo.getAverageAmount())
                .checkOtherInstrumentsAmount(registrationInfo.getAverageAmount())
                .checkCryptoDuration(registrationInfo.getDuration())
                .checkOptionsDuration(registrationInfo.getDuration())
                .checkSecuritiesDuration(registrationInfo.getDuration())
                .checkCurrenciesDuration(registrationInfo.getDuration())
                .checkDerivativesDuration(registrationInfo.getDuration())
                .checkDepositsDuration(registrationInfo.getDuration())
                .checkMoneyMarketsDuration(registrationInfo.getDuration())
                .checkDepositaryDuration(registrationInfo.getDuration())
                .checkBondsDuration(registrationInfo.getDuration())
                .checkUnitsDuration(registrationInfo.getDuration())
                .checkOtherInstrumentsDuration(registrationInfo.getDuration())
                .enterCryptoCurrentValue(registrationInfo.getStringNumber())
                .enterCryptoPastYearSize(registrationInfo.getStringNumber())
                .enterCryptoLastYearAverage(registrationInfo.getStringNumber())
                .enterOptionsCurrentValue(registrationInfo.getStringNumber())
                .enterOptionsPastYearSize(registrationInfo.getStringNumber())
                .enterOptionsLastYearAverage(registrationInfo.getStringNumber())
                .enterSecuritiesCurrentValue(registrationInfo.getStringNumber())
                .enterSecuritiesPastYearSize(registrationInfo.getStringNumber())
                .enterSecuritiesLastYearAverage(registrationInfo.getStringNumber())
                .enterInterestRatesCurrentValue(registrationInfo.getStringNumber())
                .enterInterestRatesPastYearSize(registrationInfo.getStringNumber())
                .enterInterestRatesLastYearAverage(registrationInfo.getStringNumber())
                .enterDerivativesCurrentValue(registrationInfo.getStringNumber())
                .enterDerivativesPastYearSize(registrationInfo.getStringNumber())
                .enterDerivativesLastYearAverage(registrationInfo.getStringNumber())
                .enterDepositsCurrentValue(registrationInfo.getStringNumber())
                .enterDepositsPastYearSize(registrationInfo.getStringNumber())
                .enterDepositsLastYearAverage(registrationInfo.getStringNumber())
                .enterMoneyMarketsCurrentValue(registrationInfo.getStringNumber())
                .enterMoneyMarketsPastYearSize(registrationInfo.getStringNumber())
                .enterMoneyMarketsLastYearAverage(registrationInfo.getStringNumber())
                .enterDepositaryCurrentValue(registrationInfo.getStringNumber())
                .enterDepositaryPastYearSize(registrationInfo.getStringNumber())
                .enterDepositaryLastYearAverage(registrationInfo.getStringNumber())
                .enterBondsCurrentValue(registrationInfo.getStringNumber())
                .enterBondsPastYearSize(registrationInfo.getStringNumber())
                .enterBondsLastYearAverage(registrationInfo.getStringNumber())
                .enterUnitsCurrentValue(registrationInfo.getStringNumber())
                .enterUnitsPastYearSize(registrationInfo.getStringNumber())
                .enterUnitsLastYearAverage(registrationInfo.getStringNumber())
                .enterOtherInstrumentsCurrentValue(registrationInfo.getStringNumber())
                .enterOtherInstrumentsPastYearSize(registrationInfo.getStringNumber())
                .enterOtherInstrumentsLastYearAverage(registrationInfo.getStringNumber());
        return this;
    }

}
