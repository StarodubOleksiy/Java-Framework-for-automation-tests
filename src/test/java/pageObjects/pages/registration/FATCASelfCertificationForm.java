package pageObjects.pages.registration;

import org.apache.commons.lang3.StringUtils;
import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FATCASelfCertificationForm extends IndividualVerificationBase {

    @FindBy(xpath = "//label[contains(.,'USD')]")
    private WebElement fatcaCurrencyUSD;

    @FindBy(xpath = "//label[contains(.,'EUR')]")
    private WebElement fatcaCurrencyEUR;

    @FindBy(xpath = "//label[input[@name='usCitizen']]")
    private List<WebElement> isUSCitizenYesNoList;

    @FindBy(xpath = "//label[input[@name='usIncome']]")
    private List<WebElement> payUSAnnualIncomeYesNoList;

    @FindBy(xpath = "//input[@name='usIncomeDetails']")
    private WebElement usIncomeDetails;

    @FindBy(xpath = "//label[input[@name='usNative']]")
    private List<WebElement> usNativeYesNoList;

    @FindBy(xpath = "//input[@name='usNativeDetails']")
    private WebElement usNativeDetails;

    @FindBy(xpath = "//label[input[@name='greenCard']]")
    private List<WebElement> appliedGreenCardYesNoList;

    @FindBy(xpath = "//label[input[@name='usFinancialInterest']]")
    private List<WebElement> haveUsFinancialInterestYesNoList;

    @FindBy(xpath = "//input[@name='usFinancialInterestNature']")
    private WebElement usFinancialInterestNature;

    @FindBy(xpath = "//input[@name='usFinancialInterestEstimatedValue']")
    private WebElement usFinancialInterestEstimatedValue;

    @FindBy(xpath = "//input[@name='usFinancialInterestAnnualReturns']")
    private WebElement usFinancialInterestAnnualReturns;

    @FindBy(xpath = "//input[@name='usFinancialInterestProfitsResulting']")
    private WebElement usFinancialInterestProfitsResulting;

    @FindBy(xpath = "//label[input[@name='usFamilyCitizen']]")
    private List<WebElement> haveUsFamilyCitizentYesNoList;

    @FindBy(xpath = "//input[@name='usFamilyCitizens[0].fullName']")
    private WebElement usFamilyCitizensFullName;

    @FindBy(xpath = "//input[@name='usFamilyCitizens[0].intership']")
    private WebElement usFamilyCitizensIntership;

    @FindBy(xpath = "//span[contains(text(),'Add one more person')]")
    private WebElement addPersonLink;

    @FindBy(xpath = "//label[input[@name='usVisited']]")
    private List<WebElement> usVisitedYesNoList;

    @FindBy(xpath = "//input[@name='usVisitReason']")
    private WebElement usVisitReason;

    @FindBy(xpath = "//label[input[@name='usReside']]")
    private List<WebElement> usResideYesNoList;

    @FindBy(xpath = "//input[@name='usResideDurationStart']")
    private WebElement usResideDurationStart;

    @FindBy(xpath = "//input[@name='usResideDurationEnd']")
    private WebElement usResideDurationEnd;

    @FindBy(xpath = "//input[@name='usResideState']")
    private WebElement usResideState;

    @FindBy(xpath = "//input[@name='usResideStreet']")
    private WebElement usResideStreet;

    @FindBy(xpath = "//input[@name='usResideProvince']")
    private WebElement usResideProvince;

    @Step("Specify all amounts in answers in currency {0}")
    public FATCASelfCertificationForm selectCurrency(String currency) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, fatcaCurrencyUSD);
        switch (currency) {
            case "EUR":
                fatcaCurrencyEUR.click();
                break;
            case "USD":
                fatcaCurrencyUSD.click();
                break;
        }

        return this;
    }

    @Step("Check if user is a United States citizen or permanent resident{0}")
    public FATCASelfCertificationForm chooseIfUSCitizen(String answer) {
        scrollIntoView(isUSCitizenYesNoList.get(0));
        isUSCitizenYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Check if user  pays U.S. annual income{0}")
    public FATCASelfCertificationForm chooseIfPayUSAnnualIncome(String answer) {
        scrollIntoView(payUSAnnualIncomeYesNoList.get(0));
        payUSAnnualIncomeYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Fill in TIN{0}")
    public FATCASelfCertificationForm fillInTIN(String tin) {
        usIncomeDetails.sendKeys(tin);
        return this;
    }

    @Step("Check if user is a United States of America native{0}")
    public FATCASelfCertificationForm checkForUSNative(String answer) {
        scrollIntoView(usNativeYesNoList.get(0));
        usNativeYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Check if user is abandoned American citizenship or have any intention in this regard{0}")
    public FATCASelfCertificationForm enterUSnativeDetails(String details) {
        usNativeDetails.sendKeys(details);
        return this;
    }

    @Step("Check if user is applied for the Green Card or requested an American citizenship{0}")
    public FATCASelfCertificationForm checkApplyingGreenCard(String answer) {
        scrollIntoView(appliedGreenCardYesNoList.get(0));
        appliedGreenCardYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Check if user  has any financial or economic interests in the United States of America{0}")
    public FATCASelfCertificationForm haveUsFinancialInterestYesNo(String answer) {
        scrollIntoView(haveUsFinancialInterestYesNoList.get(0));
        haveUsFinancialInterestYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Fill in the nature of your interest{0}")
    public FATCASelfCertificationForm enterUsFinancialInterestNature(String details) {
        usFinancialInterestNature.sendKeys(details);
        return this;
    }

    @Step("Fill in estimated value{0}")
    public FATCASelfCertificationForm enterUsFinancialInterestEstimatedValue(String details) {
        scrollIntoView(usFinancialInterestEstimatedValue);
        usFinancialInterestEstimatedValue.sendKeys(details);
        return this;
    }

    @Step("Fill in annual returns{0}")
    public FATCASelfCertificationForm enterUsFinancialInterestAnnualReturns(String details) {
        scrollIntoView(usFinancialInterestAnnualReturns);
        usFinancialInterestAnnualReturns.sendKeys(details);
        return this;
    }

    @Step("Fill in profits resulting{0}")
    public FATCASelfCertificationForm enterUSFinancialInterestProfitsResulting(String details) {
         scrollIntoView(usFinancialInterestProfitsResulting);
        usFinancialInterestProfitsResulting.sendKeys(details);
        return this;
    }

    @Step("Check if anyone of user family members (husband, wife, parents, brother, sister etc.) hold the American citizenship{0}")
    public FATCASelfCertificationForm haveUsFamilyCitizentYesNoYesNo(String answer) {
        scrollIntoView(haveUsFamilyCitizentYesNoList.get(0));
        haveUsFamilyCitizentYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Fill in full name{0}")
    public FATCASelfCertificationForm enterUsFamilyCitizensFullName(String name) {
        usFamilyCitizensFullName.sendKeys(name);
        return this;
    }

    @Step("Fill in the relationship for this person{0}")
    public FATCASelfCertificationForm enterUSFamilyCitizensRelationship(String relationship) {
        usFamilyCitizensIntership.sendKeys(relationship);
        return this;
    }

    @Step("Add one more person{0}")
    public FATCASelfCertificationForm clickAddNewPerson() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, addPersonLink);
        addPersonLink.click();
        return this;
    }

    @Step("Check if user has visited the United States during the five last years{0}")
    public FATCASelfCertificationForm haveUsVisitedYesNo(String answer) {
        scrollIntoView(usVisitedYesNoList.get(0));
        usVisitedYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Fill in the reason for the visit{0}")
    public FATCASelfCertificationForm enterUsVisitReason(String reason) {
        usVisitReason.sendKeys(reason);
        return this;
    }

    @Step("Check if user resides in the United States{0}")
    public FATCASelfCertificationForm haveUsResideYesNo(String answer) {
        scrollIntoView(usResideYesNoList.get(0));
        usResideYesNoList.stream().filter(option -> option.getText().equalsIgnoreCase(answer)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter USA reside start{0}")
    public FATCASelfCertificationForm enterUsResideDurationStart(String start) {
        usResideDurationStart.click();
        if (StringUtils.isBlank(start)) {
            sendEmptyKeys(usResideDurationStart);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Enter USA reside end{0}")
    public FATCASelfCertificationForm enterUsResideDurationEnd(String end) {
        usResideDurationEnd.click();
        if (StringUtils.isBlank(end)) {
            sendEmptyKeys(usResideDurationEnd);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Fill in the state for full mailing address{0}")
    public FATCASelfCertificationForm enterUsResideState(String state) {
        usResideState.sendKeys(state);
        return this;
    }

    @Step("Fill in the street for full mailing address{0}")
    public FATCASelfCertificationForm enterUsResideStreet(String street) {
        usResideStreet.sendKeys(street);
        return this;
    }

    @Step("Fill in the province for full mailing address{0}")
    public FATCASelfCertificationForm enterUsResideuProvince(String province) {
        usResideProvince.sendKeys(province);
        return this;
    }

    public FATCASelfCertificationForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.selectCurrency(registrationInfo.getCurrency())
                .chooseIfUSCitizen(registrationInfo.getYesAnswer())
                .chooseIfPayUSAnnualIncome(registrationInfo.getYesAnswer())
                .fillInTIN(registrationInfo.getTin())
                .checkForUSNative(registrationInfo.getNoAnswer())
                .checkApplyingGreenCard(registrationInfo.getNoAnswer())
                .haveUsFinancialInterestYesNo(registrationInfo.getNoAnswer())
                .haveUsFamilyCitizentYesNoYesNo(registrationInfo.getNoAnswer())
                .haveUsVisitedYesNo(registrationInfo.getNoAnswer())
                .haveUsResideYesNo(registrationInfo.getNoAnswer());
        return this;
    }

    public FATCASelfCertificationForm fillInAllFieldsWithData(RegistrationInfo registrationInfo) {
       this.selectCurrency(registrationInfo.getCurrency())
                .chooseIfUSCitizen(registrationInfo.getYesAnswer())
                .chooseIfPayUSAnnualIncome(registrationInfo.getYesAnswer())
                .fillInTIN(registrationInfo.getTin())
                .checkForUSNative(registrationInfo.getYesAnswer())
                .enterUSnativeDetails(registrationInfo.getSentence())
                .checkApplyingGreenCard(registrationInfo.getYesAnswer())
                .haveUsFinancialInterestYesNo(registrationInfo.getYesAnswer())
                .enterUsFinancialInterestNature(registrationInfo.getReason())
                .enterUsFinancialInterestEstimatedValue(registrationInfo.getStringNumber())
                .enterUsFinancialInterestAnnualReturns(registrationInfo.getStringNumber())
                .enterUSFinancialInterestProfitsResulting(registrationInfo.getStringNumber())
                .haveUsFamilyCitizentYesNoYesNo(registrationInfo.getYesAnswer())
                .enterUsFamilyCitizensFullName(registrationInfo.getFullName())
                .enterUSFamilyCitizensRelationship(registrationInfo.getSentence())
                .haveUsVisitedYesNo(registrationInfo.getYesAnswer())
                .enterUsVisitReason(registrationInfo.getReason())
                .haveUsResideYesNo(registrationInfo.getYesAnswer())
                .enterUsResideDurationStart(registrationInfo.getPassportIssueDate())
                .enterUsResideDurationEnd(registrationInfo.getPassportExpiryDate())
                .enterUsResideState(registrationInfo.getState())
                .enterUsResideStreet(registrationInfo.getStreet())
                .enterUsResideuProvince(registrationInfo.getProvince());
        return this;
    }

}
