package pageObjects.pages.registration;


import data.RegistrationInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class ExplicitDeclarationsAndDocumentsForm extends IndividualVerificationBase {
    @FindBy(xpath = "//label[input[@name='agreeTermsAndConditions']]")
    private WebElement agreeTermsAndConditionsLink;

    @FindBy(xpath = "//input[@name='agreeTermsAndConditions']")
    private WebElement agreeTermsAndConditionsCheckbox;

    @FindBy(xpath = "//label[input[@name='agreePolicies']]")
    private WebElement agreePoliciesLink;

    @FindBy(xpath = "//input[@name='agreePolicies']")
    private WebElement agreePoliciesCheckbox;

    @FindBy(xpath = "//label[input[@name='confirmInformation']]")
    private WebElement confirmInformationCheckbox;

    @FindBy(xpath = "//label[input[@name='agreeDpr']]")
    private WebElement agreeDprLink;

    @FindBy(xpath = "//input[@name='agreeDpr']")
    private WebElement agreeDprCheckbox;

    @FindBy(xpath = "//label[input[@name='notPrepared']]")
    private List<WebElement> notPreparedRadioButton;

    @FindBy(xpath = "//label[input[@name='notWantAdvice']]")
    private List<WebElement> notWantAdviceRadioButton;

    @FindBy(xpath = "//label[input[@name='notWantReceiveRelevantAdvice']]")
    private List<WebElement> notWantReceiveRelevantAdviceRadioButton;

    @FindBy(xpath = "//label[input[@name='confirmInformed']]")
    private List<WebElement> confirmInformedRadioButton;

    @FindBy(xpath = "//button[contains(text(),'Verify me')]")
    private WebElement verifyMe;

    @Step("Click to agree with general Terms and Conditions Agreement")
    public ExplicitDeclarationsAndDocumentsForm clickToAgreeTermsAndConditions() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, agreeTermsAndConditionsLink);
        makeElementVisible(agreeTermsAndConditionsCheckbox);
        scrollIntoView(agreeTermsAndConditionsCheckbox);
        agreeTermsAndConditionsCheckbox.click();
        return this;
    }

    @Step("Click to agree with all the Policies published on website")
    public ExplicitDeclarationsAndDocumentsForm clickToAgreePolicies() {
        scrollIntoView(agreePoliciesLink);
        makeElementVisible(agreePoliciesCheckbox);
        agreePoliciesCheckbox.click();
        return this;
    }

    @Step("Click to confirm that all information and documentation provided in this questionnaire " +
            "is neither false or misleading as this constitutes a criminal offence")
    public ExplicitDeclarationsAndDocumentsForm clickToConfirmInformation() {
        scrollIntoView(confirmInformationCheckbox);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, confirmInformationCheckbox);
        confirmInformationCheckbox.click();
        return this;
    }

    @Step("Click to consent to the processing of personal data relating to me, in line with the provisions of" +
            "EU General Data Protection Regulation")
    public ExplicitDeclarationsAndDocumentsForm clickToAgreeDpr() {
        scrollIntoView(agreeDprLink);
        makeElementVisible(agreeDprCheckbox);
        agreeDprCheckbox.click();
        return this;
    }

    @Step("Check for not prepared to give the requested specific information")
    public ExplicitDeclarationsAndDocumentsForm checkingNotPrepared(String status) {
        scrollIntoView(notPreparedRadioButton.get(0));
        notPreparedRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for do not want to receive advice beyond the legally prescribed minimum")
    public ExplicitDeclarationsAndDocumentsForm checkingNotWantAdvice(String status) {
        scrollIntoView(notWantAdviceRadioButton.get(0));
        notWantAdviceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for do not want to receive any relevant advice pursuant to a separate agreement")
    public ExplicitDeclarationsAndDocumentsForm checkingNotWantReceiveRelevantAdvice(String status) {
        scrollIntoView(notWantReceiveRelevantAdviceRadioButton.get(0));
        notWantReceiveRelevantAdviceRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Check for hereby confirm that I have been informed about all important facts about" +
            " the market and about the risks")
    public ExplicitDeclarationsAndDocumentsForm checkingConfirmInformed(String status) {
        scrollIntoView(confirmInformedRadioButton.get(0));
        confirmInformedRadioButton.stream().filter(option -> option.getText().equalsIgnoreCase(status)).
                findFirst().get().click();
        return this;
    }

    @Step("Click on Verify me button")
    public ExplicitDeclarationsAndDocumentsForm clickVerifyMeButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, verifyMe);
        verifyMe.click();
        return this;
    }

    public ExplicitDeclarationsAndDocumentsForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.clickToAgreeTermsAndConditions()
                .clickToAgreePolicies()
                .clickToConfirmInformation()
                .clickToAgreeDpr()
                .checkingNotPrepared(registrationInfo.getNoAnswer())
                .checkingNotWantAdvice(registrationInfo.getYesAnswer())
                .checkingNotWantReceiveRelevantAdvice(registrationInfo.getYesAnswer())
                .checkingConfirmInformed(registrationInfo.getYesAnswer());
        return this;
    }

}
