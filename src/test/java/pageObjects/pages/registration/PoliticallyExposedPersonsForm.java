package pageObjects.pages.registration;


import org.apache.commons.lang3.StringUtils;
import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class PoliticallyExposedPersonsForm extends IndividualVerificationBase {

    @FindBy(xpath = "//label[input[@name='inGovPrevYear']]")
    private List<WebElement> inGovPrevYearRadioButton;

    @FindBy(xpath = "//label[input[@name='familyInGovHoldPosition']]")
    private List<WebElement> familyInGovHoldPositionRadioButton;

    @FindBy(xpath = "//input[@name='familyMembersInGovHoldPosition[0].fullName']")
    private WebElement fullName;

    @FindBy(xpath = "//input[@name='familyMembersInGovHoldPosition[0].position']")
    private WebElement position;

    @FindBy(xpath = "//input[@name='familyMembersInGovHoldPosition[0].durationStart']")
    private WebElement durationStart;

    @FindBy(xpath = "//input[@name='familyMembersInGovHoldPosition[0].durationEnd']")
    private WebElement durationEnd;

    @FindBy(xpath = "//label[input[@name='familyInGovHeldPositionPrevYear']]")
    private List<WebElement> familyInGovHeldPositionPrevYear;

    @FindBy(xpath = "//input[@name='familyMembersInGovHeldPositionPrevYear[0].fullName']")
    private WebElement fullNamePrevYear;

    @FindBy(xpath = "//input[@name='familyMembersInGovHeldPositionPrevYear[0].position']")
    private WebElement positionPrevYear;

    @FindBy(xpath = "//input[@name='familyMembersInGovHeldPositionPrevYear[0].durationStart']")
    private WebElement durationStartPrevYear;

    @FindBy(xpath = "//input[@name='familyMembersInGovHeldPositionPrevYear[0].durationEnd']")
    private WebElement durationEndPrevYear;


    @Step("Check if employee hold a position in any governmental body during the previous one year {0}")
    public PoliticallyExposedPersonsForm checkHoldingGovernmentPositionInPastYear(String value) {
        scrollIntoView(inGovPrevYearRadioButton.get(0));
        inGovPrevYearRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Check if user immediate family members or close associates hold a position in any governmental body {0}")
    public PoliticallyExposedPersonsForm checkFamilyInGovernment(String value) {
        scrollIntoView(familyInGovHoldPositionRadioButton.get(0));
        familyInGovHoldPositionRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter name of family member of employer who is in US government now {0}")
    public PoliticallyExposedPersonsForm enterNameOfFamilyMemberOfEmployee(String value) {
        fullName.sendKeys(value);
        return this;
    }

    @Step("Enter position of family member of employer who is in US government now {0}")
    public PoliticallyExposedPersonsForm enterPositionOfFamilyMemberOfEmployee(String value) {
        position.sendKeys(value);
        return this;
    }

    @Step("Enter start date of family member of employer in US government now {0}")
    public PoliticallyExposedPersonsForm enterStartDateOfFamilyMemberOfEmployee(String value) {
        durationStart.click();
        if (StringUtils.isBlank(value)) {
            sendEmptyKeys(durationStart);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Enter end date of family member of employer in US government now {0}")
    public PoliticallyExposedPersonsForm enterEndDateOfFamilyMemberOfEmployee(String value) {
        durationEnd.click();
        if (StringUtils.isBlank(value)) {
            sendEmptyKeys(durationEnd);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Check if user immediate family members or close associates hold a position in any governmental body during pas year {0}")
    public PoliticallyExposedPersonsForm checkFamilyInGovernmentInPastYear(String value) {
        scrollIntoView(familyInGovHeldPositionPrevYear.get(0));
        familyInGovHeldPositionPrevYear.stream().filter(option -> option.getText().equalsIgnoreCase(value)).
                findFirst().get().click();
        return this;
    }

    @Step("Enter name of family member of employer who was in US government previous year {0}")
    public PoliticallyExposedPersonsForm enterNameOfFamilyMemberOfEmployeePrevYear(String value) {
        fullNamePrevYear.sendKeys(value);
        return this;
    }

    @Step("Enter position of family member of employer who was in US government previous year {0}")
    public PoliticallyExposedPersonsForm enterPositionOfFamilyMemberOfEmployeePrevYear(String value) {
        positionPrevYear.sendKeys(value);
        return this;
    }

    @Step("Enter start date of family member of employer  in US government previous year {0}")
    public PoliticallyExposedPersonsForm enterStartDateOfFamilyMemberOfEmployeePrevYear(String value) {
        durationStartPrevYear.click();
        if (StringUtils.isBlank(value)) {
            sendEmptyKeys(durationStartPrevYear);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    @Step("Enter end date of family member of employer in US government previous year {0}")
    public PoliticallyExposedPersonsForm enterEndDateOfFamilyMemberOfEmployeePrevYear(String value) {
        durationEndPrevYear.click();
        if (StringUtils.isBlank(value)) {
            sendEmptyKeys(durationEndPrevYear);
        } else {
            selectFirstEnabledDate();
        }
        return this;
    }

    public PoliticallyExposedPersonsForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.checkHoldingGovernmentPositionInPastYear(registrationInfo.getNoAnswer())
                .checkFamilyInGovernment(registrationInfo.getNoAnswer())
                .checkFamilyInGovernmentInPastYear(registrationInfo.getNoAnswer());
        return this;
    }

    public PoliticallyExposedPersonsForm fillInAllFieldsWithData(RegistrationInfo registrationInfo) {
        this.checkHoldingGovernmentPositionInPastYear(registrationInfo.getYesAnswer())
                .checkFamilyInGovernment(registrationInfo.getYesAnswer())
                .enterNameOfFamilyMemberOfEmployee(registrationInfo.getFirstName())
                .enterPositionOfFamilyMemberOfEmployee(registrationInfo.getPosition())
                .enterStartDateOfFamilyMemberOfEmployee(registrationInfo.getExpiryDate())
                .enterEndDateOfFamilyMemberOfEmployee(registrationInfo.getExpiryDate())
                .checkFamilyInGovernmentInPastYear(registrationInfo.getYesAnswer())
                .enterNameOfFamilyMemberOfEmployeePrevYear(registrationInfo.getFirstName())
                .enterPositionOfFamilyMemberOfEmployeePrevYear(registrationInfo.getPosition())
                .enterStartDateOfFamilyMemberOfEmployeePrevYear(registrationInfo.getExpiryDate())
                .enterEndDateOfFamilyMemberOfEmployeePrevYear(registrationInfo.getExpiryDate());
        return this;
    }

}
