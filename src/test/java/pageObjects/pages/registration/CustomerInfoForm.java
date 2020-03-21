package pageObjects.pages.registration;

import data.RegistrationInfo;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CustomerInfoForm extends IndividualVerificationBase {

    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//input[@name='placeOfBirth']")
    private WebElement placeOfBirthInput;

    @FindBy(xpath = "//input[@name='nationality']")
    private WebElement nationalityInput;

    @FindBy(xpath = "//input[@name='passportNumber']")
    private WebElement passportNumberInput;

    @FindBy(xpath = "//*[@class='Select-control']//input")
    private WebElement countryOfIssuance;

    @FindBy(xpath = "//input[@name='passportIssueDate']")
    private WebElement passportIssueDateInput;

    @FindBy(xpath = "//input[@name='passportExpiryDate']")
    private WebElement passportExpiryDateInput;

    @FindBy(xpath = "//input[@name='passportNoExpiry']")
    private WebElement passportNoExpiryCheckbox;

    @FindBy(xpath = "//input[@name='homeAddress']")
    private WebElement homeAddressInput;

    @FindBy(xpath = "//input[@name='mailingAddress']")
    private WebElement mailingAddressInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='additionalPhoneNumber']")
    private WebElement additionalPhoneNumberInput;

    @FindBy(xpath = "//input[@name='faxNumber']")
    private WebElement faxNumberInput;

    @FindBy(xpath = "//label[input[@name='preferredCommunication']]")
    private List<WebElement> preferredCommRadioGroup;

    @FindBy(name = "purposeForRequesting")
    private WebElement purposeForRequestingText;

    @FindBy(xpath = "//input[@name='expiryDate']")
    private WebElement expiryDateInput;

    @FindBy(xpath = "//div[contains(@class,'file-upload-group')][contains(.,'Proof of identity')]//input[@type='file']")
    private WebElement proofOfIdentityFile;

    @FindBy(xpath = "//div[contains(@class,'file-upload-group')][contains(.,'Proof of residency')]//input[@type='file']")
    private WebElement proofOfResidencyFile;

    @FindBy(xpath = "//div[contains(text(),'is required!')]")
    private WebElement errorDiv;

    @Step("Enter date of birth {0}")
    public CustomerInfoForm enterDateOfBirthInput(String dateOfBirth) {
        dateOfBirthInput.click();

        if (StringUtils.isBlank(dateOfBirth)) {
            sendEmptyKeys(dateOfBirthInput);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Enter place of birth {0}")
    public CustomerInfoForm enterPlaceOfBirth(String placeOfBirth) {
        placeOfBirthInput.sendKeys(placeOfBirth);
        return this;
    }

    @Step("Enter nationality {0}")
    public CustomerInfoForm enterNationality(String nationality) {
        nationalityInput.sendKeys(nationality);
        return this;
    }

    @Step("Enter passport number {0}")
    public CustomerInfoForm enterPassportNumber(String passportNumber) {
        passportNumberInput.sendKeys(passportNumber);
        return this;
    }

    @Step("Set country of issuance {0}")
    public CustomerInfoForm selectCountry(String country) {
        countryOfIssuance.sendKeys(country + Keys.ENTER);
        return this;
    }

    @Step("Enter passport issue date {0}")
    public CustomerInfoForm enterPassportIssueDate(String passportIssueDate) {
        scrollIntoView(passportIssueDateInput);
        passportIssueDateInput.click();

        if (StringUtils.isBlank(passportIssueDate)) {
            sendEmptyKeys(passportIssueDateInput);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Enter passport expiry date {0}")
    public CustomerInfoForm enterPassportExpiryDate(String passportExpiryDate) {
        scrollIntoView(passportExpiryDateInput);
        passportExpiryDateInput.click();

        if (StringUtils.isBlank(passportExpiryDate)) {
            sendEmptyKeys(passportExpiryDateInput);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Check my passport validity is indefinite {0}")
    public CustomerInfoForm clickPassportNoExpiry() {
        scrollIntoView(passportNoExpiryCheckbox);
        passportNoExpiryCheckbox.click();
        return this;
    }

    @Step("Enter home address {0}")
    public CustomerInfoForm enterHomeAddress(String homeAddress) {
        scrollIntoView(homeAddressInput);
        homeAddressInput.sendKeys(homeAddress);
        return this;
    }

    @Step("Enter mailing address {0}")
    public CustomerInfoForm enterMailingAddress(String mailingAddress) {
        scrollIntoView(homeAddressInput);
        mailingAddressInput.sendKeys(mailingAddress);
        return this;
    }

    @Step("Enter phone number {0}")
    public CustomerInfoForm enterPhoneNumber(String phoneNumber) {
        scrollIntoView(homeAddressInput);
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    @Step("Enter additional phone number {0}")
    public CustomerInfoForm enterAdditionalPhoneNumber(String additionalPhoneNumber) {
        scrollIntoView(additionalPhoneNumberInput);
        additionalPhoneNumberInput.sendKeys(additionalPhoneNumber);
        return this;
    }

    @Step("Enter fax number {0}")
    public CustomerInfoForm enterFaxNumber(String faxNumber) {
        scrollIntoView(faxNumberInput);
        faxNumberInput.sendKeys(faxNumber);
        return this;
    }


    @Step("Set preferred communication {0}")
    public CustomerInfoForm selectPreferredCommunication(String communicationType) {
        scrollIntoView(preferredCommRadioGroup.get(0));
        preferredCommRadioGroup.stream().filter(option -> option.getText().equalsIgnoreCase(communicationType)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter purpose for requesting {0}")
    public CustomerInfoForm enterPurposeForRequesting(String purposeForRequesting) {
        scrollIntoView(purposeForRequestingText);
        purposeForRequestingText.sendKeys(purposeForRequesting);
        return this;
    }

    @Step("Enter expiry date {0}")
    public CustomerInfoForm enterExpiryDate(String expiryDate) {
        scrollIntoView(expiryDateInput);
        expiryDateInput.click();
        selectFirstEnabledDate();
        return this;
    }

    @Step("Upload proof of identity file {0}")
    public CustomerInfoForm uploadProofOfIdentity(String filePath) {
        scrollIntoView(proofOfIdentityFile);
        proofOfIdentityFile.sendKeys(filePath);
        sleep(3000); //TODO replace with wait for file to be uploaded
        return this;
    }

    @Step("Upload proof of residency file {0}")
    public CustomerInfoForm uploadProofOfResidency(String filePath) {
        scrollIntoView(proofOfResidencyFile);
        proofOfResidencyFile.sendKeys(filePath);
        sleep(3000); //TODO replace with wait for file to be uploaded
        return this;
    }

    public CustomerInfoForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.enterDateOfBirthInput(registrationInfo.getDateOfBirth())
                .enterPlaceOfBirth(registrationInfo.getPlaceOfBirth())
                .enterNationality(registrationInfo.getNationality())
                .enterPassportNumber(registrationInfo.getPassportNumber())
                .selectCountry(registrationInfo.getCountry())
                .enterPassportIssueDate(registrationInfo.getPassportIssueDate())
                .enterPassportExpiryDate(registrationInfo.getPassportExpiryDate())
                .enterHomeAddress(registrationInfo.getHomeAddress())
                .enterPhoneNumber(registrationInfo.getPhoneNumber())
                .selectPreferredCommunication(registrationInfo.getPreferredCommunication())
                .enterPurposeForRequesting(registrationInfo.getPurposeForRequesting())
                .uploadProofOfIdentity(registrationInfo.getProofOfIdentity())
                .enterExpiryDate(registrationInfo.getExpiryDate())
                .uploadProofOfResidency(registrationInfo.getProofOfResidency());
        return this;
    }


}
