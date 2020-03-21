package pageObjects.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.AllureAttachments;
import utils.Platform;

import java.util.ArrayList;
import java.util.List;

public class ResetPassword extends PageFactoryInitializer {

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement loginPhoneTextBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement loginPasswordTextBox;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement smsCodeInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Send code')]")
    private WebElement sendCodeButton;

    @FindBy(xpath = "//button[contains(text(),'Reset password')]")
    private WebElement resetPassword;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement cancelSpan;

    @FindBy(xpath = "//span[contains(@class,'error-message')]")
    private List<WebElement> errorMessages;

    @Step("Clear field phone number")
    public ResetPassword clearPhoneNumberField() {
         this.clearInput(loginPhoneTextBox);
        return this;
    }

    @Step("Clear field sms code input")
    public ResetPassword clearSmsCodeInput() {
        this.clearInput(smsCodeInput);
        return this;
    }

    @Step("Clear field password")
    public ResetPassword clearPasswordField() {
        this.clearInput(loginPasswordTextBox);
        return this;
    }

    @Step("Enter Phone number into text field {0}")
    public ResetPassword enterLoginPhoneNumber(String phoneNumber) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginPhoneTextBox);
        loginPhoneTextBox.sendKeys(phoneNumber);//+380630711488
        return this;
    }

    @Step("Enter Password into text field {0}")
    public ResetPassword enterLoginPassword(String password) {
        sleep(500);
        loginPasswordTextBox.sendKeys(password);
        return this;
    }

    @Step("Click Login button")
    public ResetPassword clickLoginButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginButton);
        loginButton.click();
        return this;
    }

    @Step("Enter Sms Code {0}")
    public ResetPassword enterSmsCode(String code) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, smsCodeInput);
        smsCodeInput.sendKeys(code);
        return this;
    }


    @Step("Click Send code button")
    public ResetPassword clickSendCodeButton() {
        sendCodeButton.click();
        return this;
    }

    @Step("Click reset password button")
    public ResetPassword clickResetPassword() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, resetPassword);
        resetPassword.click();
        return this;
    }

    @Step("Verify reset password button is disabled")
    public ResetPassword ifResetPasswordIsDisabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, resetPassword);
        Assert.assertEquals(resetPassword.isEnabled(), false);
        return this;
    }

    @Step("Verify send code button is disabled")
    public ResetPassword ifSendCodeButtonIsDisabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, sendCodeButton);
        Assert.assertEquals(sendCodeButton.isEnabled(), false);
        return this;
    }

    @Step("Verify send code button is enabled")
    public ResetPassword ifSendCodeButtonIsEnabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, sendCodeButton);
        Assert.assertEquals(sendCodeButton.isEnabled(), true);
        return this;
    }

    @Step("Verify reset password button is enabled")
    public ResetPassword ifResetPasswordButtonIsEnabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, sendCodeButton);
        Assert.assertEquals(resetPassword.isEnabled(), true);
        return this;
    }

    @Step("Verify login password text box is not present on page")
    public ResetPassword ifLoginPasswordTextBoxIsNotPresent() {
        Assert.assertFalse(this.isElementPresent("//input[@name='password']"));
        return this;
    }

    @Step("Click login password text box")
    public ResetPassword clickOnLoginPasswordTextBox() {
        loginPasswordTextBox.click();
        return this;
    }

    @Step("Click login phone text box")
    public ResetPassword clickOnLoginPhoneTextBox() {
        loginPhoneTextBox.click();
        return this;
    }

    @Step("Click sms code input text box")
    public ResetPassword clickOnSmsCodeInputTextBox() {
        smsCodeInput.click();
        return this;
    }

    @Step("Click cancel span")
    public ResetPassword clickOnCancelSpan() {
        cancelSpan.click();
        return this;
    }


    @Step("Verify error messages {0}")
    public ResetPassword validateErrorMessagesArePresent(List<String> expectedErrorMessages) {
        List<String> actualErrorMessages = new ArrayList<String>();
        for (WebElement error : errorMessages) {
            scrollIntoView(error);
            actualErrorMessages.add(error.getText());
        }
        Assert.assertEquals(actualErrorMessages, expectedErrorMessages);
        return this;
    }

}
