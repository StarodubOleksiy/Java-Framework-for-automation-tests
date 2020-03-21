package pageObjects.pages.registration;

import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PaymentDetailsForm extends IndividualVerificationBase {

    @FindBy(xpath = "//label[contains(.,'USD')]")
    private WebElement currencyUSD;

    @FindBy(xpath = "//label[contains(.,'EUR')]")
    private WebElement currencyEUR;

    @FindBy(xpath = "//label[contains(.,'RUB')]")
    private WebElement currencyRUB;

    @FindBy(xpath = "//input[@name='paymentType']")
    private List<WebElement> paymentType;

    @FindBy(xpath = "//input[@name='correspondentBankName']")
    private WebElement correspondentBankName;

    @FindBy(xpath = "//input[@name='correspondentBankSwift']")
    private WebElement correspondentBankSwift;

    @FindBy(xpath = "//input[@name='correspondentBankAccount']")
    private WebElement correspondentBankAccount;

    @FindBy(xpath = "//input[@name='beneficiaryBankBeneficiary']")
    private WebElement beneficiaryBankBeneficiary;

    @FindBy(xpath = "//input[@name='beneficiaryBankSwift']")
    private WebElement beneficiaryBankSwift;

    @FindBy(xpath = "//input[@name='beneficiaryBankName']")
    private WebElement beneficiaryBankName;

    @FindBy(xpath = "//input[@name='beneficiaryBankAccountNumber']")
    private WebElement beneficiaryBankAccountNumber;

    @FindBy(xpath = "//input[@name='beneficiaryBankIbanCode']")
    private WebElement beneficiaryBankIbanCode;

    @FindBy(xpath = "//input[@name='paymentDetails']")
    private WebElement paymentDetails;

    @FindBy(xpath = "//div[contains(@class,'file-upload-group')][contains(.,'Proof of affiliation')]//input[@type='file']")
    private WebElement proofOfAffiliationFile;

    @Step("Specify all amounts in answers in (USD, EUR, RUB)  {0}")
    public PaymentDetailsForm specifyCurrency(String currencyType) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyUSD);
        scrollIntoView(currencyUSD);
        switch (currencyType) {
            case "EUR":
                //utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyEUR);
                currencyEUR.click();
                break;
            case "USD":
                //utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyUSD);
                currencyUSD.click();
                break;
            case "RUB":
                //utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyRUB);
                currencyRUB.click();
                break;
        }

        return this;
    }

    @Step("Enter the correspondent bank name")
    public PaymentDetailsForm enterCorrespondentBankName(String name) {
        scrollIntoView(correspondentBankName);
        correspondentBankName.sendKeys(name);
        return this;
    }

    @Step("Enter the correspondent bank swift")
    public PaymentDetailsForm enterCorrespondentBankSwift(String swift) {
        scrollIntoView(correspondentBankSwift);
        correspondentBankSwift.sendKeys(swift);
        return this;
    }

    @Step("Enter the correspondent bank account")
    public PaymentDetailsForm enterCorrespondentBankAccount(String account) {
        scrollIntoView(correspondentBankAccount);
        correspondentBankAccount.sendKeys(account);
        return this;
    }

    @Step("Enter the beneficiary bank beneficiaries")
    public PaymentDetailsForm enterBeneficiaryBank(String beneficiaries) {
        scrollIntoView( beneficiaryBankBeneficiary);
        beneficiaryBankBeneficiary.sendKeys( beneficiaries);
        return this;
    }

    @Step("Enter the beneficiary bank swift")
    public PaymentDetailsForm enterBeneficiaryBankSwift(String swift) {
        scrollIntoView(beneficiaryBankSwift);
        beneficiaryBankSwift.sendKeys(swift);
        return this;
    }

    @Step("Enter the beneficiary bank name")
    public PaymentDetailsForm enterBeneficiaryBankName(String name) {
        scrollIntoView(beneficiaryBankName);
        beneficiaryBankName.sendKeys(name);
        return this;
    }

    @Step("Enter the beneficiary bank account number")
    public PaymentDetailsForm enterBeneficiaryBankAccountNumber(String account) {
        scrollIntoView(beneficiaryBankAccountNumber);
        beneficiaryBankAccountNumber.sendKeys(account);
        return this;
    }

    @Step("Enter the beneficiary bank iban code")
    public PaymentDetailsForm enterBeneficiaryBankIbanCode(String code) {
        scrollIntoView( beneficiaryBankIbanCode);
        beneficiaryBankIbanCode.sendKeys(code);
        return this;
    }

    @Step("Enter the payment details")
    public PaymentDetailsForm enterPaymentDetails(String details) {
        scrollIntoView(paymentDetails);
        paymentDetails.sendKeys(details);
        return this;
    }

    @Step("Upload proof of affiliation file {0}")
    public PaymentDetailsForm uploadProofOfAffiliation(String filePath) {
        scrollIntoView(proofOfAffiliationFile);
        proofOfAffiliationFile.sendKeys(filePath);
        sleep(3000); //TODO replace with wait for file to be uploaded
        return this;
    }

    public PaymentDetailsForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.specifyCurrency(registrationInfo.getCurrency())
                .enterCorrespondentBankName(registrationInfo.getCompany())
                .enterCorrespondentBankSwift(registrationInfo.getSwift())
                .enterCorrespondentBankAccount(registrationInfo.getStringNumber())
                .enterBeneficiaryBank(registrationInfo.getCompany())
                .enterBeneficiaryBankSwift(registrationInfo.getSwift())
                .enterBeneficiaryBankName(registrationInfo.getCompany())
                .enterBeneficiaryBankAccountNumber(registrationInfo.getStringNumber())
                .enterBeneficiaryBankIbanCode(registrationInfo.getStringNumber())
                .enterPaymentDetails(registrationInfo.getSentence())
                .uploadProofOfAffiliation(registrationInfo.getProofOfAffiliation());
        return this;
    }

}
