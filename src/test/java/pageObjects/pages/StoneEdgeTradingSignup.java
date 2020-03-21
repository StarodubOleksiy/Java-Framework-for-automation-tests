package pageObjects.pages;

import data.RegistrationInfo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

public class StoneEdgeTradingSignup extends PageFactoryInitializer {

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement loginPhoneTextBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement smsCodeInput;

    @FindBy(xpath = "//span[contains(text(),'Open account')]")
    private WebElement openAccountLink;

    @FindBy(xpath = "//button[contains(text(),'Send code')]")
    private WebElement sendCodeButton;

    @FindBy(xpath = "//*[contains(@class,'account-name')]")
    private WebElement accountNameCheckBox;

    @FindBy(xpath = "//span[contains(@class,'error-message')]")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'notifications-wrapper')]")
    private WebElement notificationWrapper;

    @FindBy(xpath = "//span[contains(@class, 'ok-button')]")
    private WebElement okButton;

    @FindBy(xpath = "//button[contains(text(),'Next step')]")
    private WebElement nextStep;

    @FindBy(xpath = "//span[contains(text(),'I forgot password')]")
    private WebElement forgotPasswordLink;

    @FindBy(partialLinkText = ("Log in"))
    private WebElement logInLink;

    @Step("Enter Phone number {0} into text field")
    public StoneEdgeTradingSignup enterSignupPhoneNumber(String phoneNumber) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginPhoneTextBox);
        loginPhoneTextBox.sendKeys(phoneNumber);
        return this;
    }

    @Step("Enter new pasword which you want to reset")
    public StoneEdgeTradingSignup enterPassword(String password) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Clear field phone number")
    public StoneEdgeTradingSignup clearPhoneNumberField() {
        this.clearInput(loginPhoneTextBox);
         return this;
    }

    @Step("Clear field password")
    public StoneEdgeTradingSignup clearPasswordField() {
        this.clearInput(passwordInput);
        return this;
    }

    @Step("Click Login button")
    public StoneEdgeTradingSignup clickLoginButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginButton);
        loginButton.click();
        return this;
    }

    @Step("Click Ok policy button")
    public StoneEdgeTradingSignup clickOkButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, okButton);
        okButton.click();
        return this;
    }

    @Step("Enter Sms Code {0} into text field")
    public StoneEdgeTradingSignup enterSmsCode(String code) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, smsCodeInput);
        smsCodeInput.sendKeys(code);
        return this;
    }

    @Step("Validate login field error message")
    public StoneEdgeTradingSignup validateSignupErrorMessage() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(loginErrorMessage, 30, "Please enter valid phone number");
        return this;
    }

    @Step("Click on Open account link")
    public StoneEdgeTradingSignup clickOpenAccount() {
        utils.FluentWaiting.waitUntillElementToBeClickable(70, 500, openAccountLink);
        openAccountLink.click();
        return this;
    }

    @Step("Validate login required error message")
    public StoneEdgeTradingSignup validateLoginRequiredMessage() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(loginErrorMessage, 30, "Required");
        return this;
    }

    @Step("Click on Send code button")
    public StoneEdgeTradingSignup clickSendCodeButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, sendCodeButton);
        sendCodeButton.click();
        return this;
    }

    @Step("Click Next step button")
    public StoneEdgeTradingSignup clickNextStepButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, nextStep);
        nextStep.click();
        return this;
    }

    @Step("Click Log In link")
    public StoneEdgeTradingSignup clickLogInLink() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, logInLink);
        logInLink.click();
        return this;
    }

    public StoneEdgeTradingSignup fillInRequiredFields(RegistrationInfo registrationInfo) {
        this.clickOpenAccount()
                .clickOkButton()
                .enterSignupPhoneNumber(registrationInfo.getPhoneNumber())
                .clickSendCodeButton()
                .enterSmsCode(registrationInfo.getValidSmsCode());
        return this;
    }

    @Step("Click On <<I forgot password>> link")
    public StoneEdgeTradingSignup clickIForgotPassword() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, forgotPasswordLink);
        forgotPasswordLink.click();
        return this;
    }

}
