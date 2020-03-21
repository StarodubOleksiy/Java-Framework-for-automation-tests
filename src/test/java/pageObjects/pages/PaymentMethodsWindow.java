package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.pages.registration.PaymentDetailsForm;
import ru.yandex.qatools.allure.annotations.Step;
import utils.FluentWaiting;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodsWindow extends PageFactoryInitializer {

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-')]//button[contains(text(),'Add payment method')]")
    private WebElement addPaymentMethodButton;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-')]//button[contains(text(),'Add')]")
    private WebElement addButton;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-')]//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-')]//span[contains(text(),'USD')]")
    private WebElement currencyUSD;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-')]//span[contains(text(),'EUR')]")
    private WebElement currencyEUR;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-')]//span[contains(text(),'RUB')]")
    private WebElement currencyRUB;

    @FindBy(xpath = "//label[@class='redux__field__checkbox-label-wrapper']//input")
    private WebElement russianBankCheckBox;

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

    @FindBy(xpath = "//input[@name='rusBankBik']")
    private WebElement rusBankBik;

    @FindBy(xpath = "//input[@name='rusBankBeneficiaryBank']")
    private WebElement rusBankBeneficiaryBank;

    @FindBy(xpath = "//input[@name='rusBankCorrBankAccount']")
    private WebElement rusBankCorrBankAccount;

    @FindBy(xpath = "//input[@name='rusBankBankAddress']")
    private WebElement rusBankBankAddress;

    @FindBy(xpath = "//input[@name='rusBankBeneficiaryName']")
    private WebElement rusBankBeneficiaryName;

    @FindBy(xpath = "//input[@name='rusBankBeneficiaryAccountNo']")
    private WebElement rusBankBeneficiaryAccountNo;

    @FindBy(xpath = "//input[@name='rusBankBeneficiaryAddress']")
    private WebElement rusBankBeneficiaryAddress;

    @FindBy(xpath = "//input[@name='rusBankBeneficiaryTaxCode']")
    private WebElement rusBankBeneficiaryTaxCode;

    @FindBy(xpath = "//input[@name='rusBankKppCode']")
    private WebElement rusBankKppCode;

    @FindBy(xpath = "//input[@name='rusBankVoCode']")
    private WebElement rusBankVoCode;

    @FindBy(xpath = "//div[contains(@class,'file-upload-dropzone___1bnAJ')]//input[@type='file']")
    private WebElement proofOfAffiliationFile;

    @FindBy(xpath = "//div[contains(@class,'style__input-error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class,'style__input-error')]")
    private List<WebElement> errorMessages;

    @FindBy(xpath = "//div[contains(@class,'icon-icon-in-verification')]")
    private List<WebElement> verificationIcon;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Payments-___style__method-title-text___ZLA83')]")
    private List<WebElement> bankingAccountNames;

    @Step("select currency {0}")
    public PaymentMethodsWindow specifyCurrency(String currencyType) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyUSD);
        scrollIntoView(currencyUSD);
        switch (currencyType) {
            case "EUR":
                scrollIntoView(currencyEUR);
                currencyEUR.click();
                break;
            case "USD":
                scrollIntoView(currencyUSD);
                currencyUSD.click();
                break;
            case "RUB":
                scrollIntoView(currencyRUB);
                currencyRUB.click();
                break;
        }
        return this;
    }

    @Step("Enter the correspondent bank name")
    public PaymentMethodsWindow enterCorrespondentBankName(String name) {
        scrollIntoView(correspondentBankName);
        correspondentBankName.sendKeys(name);
        return this;
    }

    @Step("Enter the correspondent bank swift")
    public PaymentMethodsWindow enterCorrespondentBankSwift(String swift) {
        scrollIntoView(correspondentBankSwift);
        correspondentBankSwift.sendKeys(swift);
        return this;
    }

    @Step("Enter the correspondent bank account")
    public PaymentMethodsWindow enterCorrespondentBankAccount(String account) {
        scrollIntoView(correspondentBankAccount);
        correspondentBankAccount.sendKeys(account);
        return this;
    }

    @Step("Enter the beneficiary bank beneficiaries")
    public PaymentMethodsWindow enterBeneficiaryBank(String beneficiaries) {
        scrollIntoView(beneficiaryBankBeneficiary);
        beneficiaryBankBeneficiary.sendKeys(beneficiaries);
        return this;
    }

    @Step("Enter the beneficiary bank swift")
    public PaymentMethodsWindow enterBeneficiaryBankSwift(String swift) {
        scrollIntoView(beneficiaryBankSwift);
        beneficiaryBankSwift.sendKeys(swift);
        return this;
    }

    @Step("Enter the beneficiary bank name")
    public PaymentMethodsWindow enterBeneficiaryBankName(String name) {
        scrollIntoView(beneficiaryBankName);
        beneficiaryBankName.sendKeys(name);
        return this;
    }

    @Step("Enter the beneficiary bank account number")
    public PaymentMethodsWindow enterBeneficiaryBankAccountNumber(String account) {
        scrollIntoView(beneficiaryBankAccountNumber);
        beneficiaryBankAccountNumber.sendKeys(account);
        return this;
    }

    @Step("Enter the beneficiary bank iban code")
    public PaymentMethodsWindow enterBeneficiaryBankIbanCode(String code) {
        scrollIntoView(beneficiaryBankIbanCode);
        beneficiaryBankIbanCode.sendKeys(code);
        return this;
    }

    @Step("Enter the payment details")
    public PaymentMethodsWindow enterPaymentDetails(String details) {
        scrollIntoView(paymentDetails);
        paymentDetails.sendKeys(details);
        return this;
    }

    @Step("Enter the rusian bank bik")
    public PaymentMethodsWindow enterRusBankBik(String details) {
        scrollIntoView(rusBankBik);
        rusBankBik.sendKeys(details);
        return this;
    }

    @Step("Enter the rusian correspondent bank account")
    public PaymentMethodsWindow enterRusBankCorrBankAccount(String details) {
        scrollIntoView(rusBankCorrBankAccount);
        rusBankCorrBankAccount.sendKeys(details);
        return this;
    }


    @Step("Enter the rusian beneficiary bank")
    public PaymentMethodsWindow enterRusBankBeneficiaryBank(String details) {
        scrollIntoView(rusBankBeneficiaryBank);
        rusBankBeneficiaryBank.sendKeys(details);
        return this;
    }

    @Step("Enter the address of russian beneficiary bank")
    public PaymentMethodsWindow enterRusBankBankAddress(String details) {
        scrollIntoView(rusBankBankAddress);
        rusBankBankAddress.sendKeys(details);
        return this;
    }


    @Step("Enter the name of russian beneficiary bank")
    public PaymentMethodsWindow enterRusBankBeneficiaryName(String details) {
        scrollIntoView(rusBankBeneficiaryName);
        rusBankBeneficiaryName.sendKeys(details);
        return this;
    }

    @Step("Enter the address of russian beneficiaries")
    public PaymentMethodsWindow enterRusBankBeneficiaryAddress(String details) {
        scrollIntoView(rusBankBeneficiaryAddress);
        rusBankBeneficiaryAddress.sendKeys(details);
        return this;
    }

    @Step("Enter the russian bank beneficiary account no")
    public PaymentMethodsWindow enterRusBankBeneficiaryAccountNo(String details) {
        scrollIntoView(rusBankBeneficiaryAccountNo);
        rusBankBeneficiaryAccountNo.sendKeys(details);
        return this;
    }

    @Step("Enter the russian bank beneficiary tax code")
    public PaymentMethodsWindow enterRusBankBeneficiaryTaxCode(String details) {
        scrollIntoView(rusBankBeneficiaryTaxCode);
        rusBankBeneficiaryTaxCode.sendKeys(details);
        return this;
    }

    @Step("Enter the russian bank KPP code")
    public PaymentMethodsWindow enterRusBankKppCode(String details) {
        scrollIntoView(rusBankKppCode);
        rusBankKppCode.sendKeys(details);
        return this;
    }

    @Step("Enter the russian bank Vo code")
    public PaymentMethodsWindow enterRusBankVoCode(String details) {
        scrollIntoView(rusBankVoCode);
        rusBankVoCode.sendKeys(details);
        return this;
    }


    @Step("Upload document {0}")
    public PaymentMethodsWindow uploadProofOfAffiliation(String filePath) {
        scrollIntoView(proofOfAffiliationFile);
        proofOfAffiliationFile.sendKeys(filePath);
        sleep(3000); //TODO replace with wait for file to be uploaded
        return this;
    }

    @Step("Validate error messages {0}")
    public PaymentMethodsWindow validateErrorMessagesArePresent(List<String> expectedErrorMessages) {
        List<String> actualErrorMessages = new ArrayList<String>();
        for (WebElement error : errorMessages) {
            scrollIntoView(error);
            actualErrorMessages.add(error.getText());
        }
        Assert.assertEquals(actualErrorMessages, expectedErrorMessages);
        return this;
    }

    @Step("Validate error message")
    public PaymentMethodsWindow validateErrorMessageIsPresent(String expectedErrorMessage) {
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
        return this;
    }

    @Step("Click on <<Add payment method>> button")
    public PaymentMethodsWindow clickAddPaymentMethodButton() {
        sleep(500);
        addPaymentMethodButton.click();
        return this;
    }

    @Step("Click on <<Add >> button")
    public PaymentMethodsWindow clickAddButton() {
        addButton.click();
        return this;
    }

    @Step("Click on <<Cancel >> button")
    public PaymentMethodsWindow clickCancelButton() {
        cancelButton.click();
        return this;
    }

    @Step("Click check box <<Bank is based in Russian Federation>>")
    public PaymentMethodsWindow clickRussianBankCheckBox() {
        russianBankCheckBox.click();
        return this;
    }

    @Step("Verify verification icon is present")
    public PaymentMethodsWindow isVerificationIconIsPresent() {
        WebElement icon = verificationIcon.get(verificationIcon.size() - 1);
        scrollIntoView(icon);
        Assert.assertTrue(icon.isDisplayed());
        return this;
    }

    @Step("Verify bank account name")
    public PaymentMethodsWindow verifyBankAccountName(String name) {
        bankingAccountNames.forEach(item -> {
            if (name.equals(item)) {
                Assert.assertEquals(name, item);
            }
        });
        return this;
    }


}
