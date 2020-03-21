package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Step;
import utils.AllureAttachments;
import utils.Platform;

import java.util.List;


/**
 * @author Anatolii Ivanyuk
 * @date Aug 18, 2018
 */

public class StoneEdgeTradingLogin extends PageFactoryInitializer {

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement loginPhoneTextBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement loginPasswordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement acceptPolicies;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement smsCodeInput;

    @FindBy(xpath = "//div[contains(@class,'WithSelectedMember-___style__account-row___2z9iW')]")
    private WebElement accountName;

    @FindBy(xpath = "//span[contains(@class,'error-message')]")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'notifications-wrapper')]")
    private WebElement notificationWrapper;

    @FindBy(xpath = "//span[contains(@class, 'ok-button')]")
    private WebElement okButton;

    @FindBy(xpath = "//span[contains(@class, 'app-pages-LoginPage-components-___style__forgot___3fNqd')]")
    private WebElement itsNotMeLink;

    @FindBy(xpath = "//button[contains(@class, 'style__resend-button')]")
    private WebElement didNotGetCodeSendAgainLink;

    @FindBy(xpath = "//*[contains(@class,'account-name')]")
    private List<WebElement> accountNamesCheckBox;

    @FindBy(xpath = "//span[contains(@class,'app-containers-SelectAccountPopup-___style__balance')]//span")
    private List<WebElement> accountCurrency;

    @FindBy(xpath = "//span[contains(@class,'WithSelectedMember')]")
    private List<WebElement> dealerDeskMembers;

    @Step("Clear field phone number")
    public StoneEdgeTradingLogin clearPhoneNumberField() {
        this.clearInput(loginPhoneTextBox);
        return this;
    }

    @Step("Clear field password")
    public StoneEdgeTradingLogin clearPasswordField() {
        this.clearInput(loginPasswordTextBox);
        return this;
    }


    @Step("Enter Phone number into text field {0}")
    public StoneEdgeTradingLogin enterLoginPhoneNumber(String phoneNumber) {
        sleep(1000);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginPhoneTextBox);
        loginPhoneTextBox.sendKeys(phoneNumber);
        return this;
    }

    @Step("Enter Password into text field {0}")
    public StoneEdgeTradingLogin enterLoginPassword(String password) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginPasswordTextBox);
        loginPasswordTextBox.sendKeys(password);
        return this;
    }

    @Step("Click Login button")
    public StoneEdgeTradingLogin clickLoginButton() {
        sleep(1000);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginButton);
        loginButton.click();
        return this;
    }

    @Step("Click accept policies")
    public StoneEdgeTradingLogin clickAcceptPolicies() {
        acceptPolicies.click();
        return this;
    }

    @Step("Verify if <<Login>> button is disabled")
    public StoneEdgeTradingLogin verifyLoginButtonDisabled() {
        Assert.assertFalse(loginButton.isEnabled());
        return this;
    }


    @Step("Enter Sms Code {0}")
    public StoneEdgeTradingLogin enterSmsCode(String code) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, smsCodeInput);
        smsCodeInput.sendKeys(code);
        return this;
    }

    @Step("Click Account Name")
    public StoneEdgeTradingLogin clickAccountName() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, accountName);
        accountName.click();
        return this;
    }

    @Step("Validate login field error message")
    public StoneEdgeTradingLogin validateLoginErrorMessage() {
        utils.ExplicitWaiting.explicitWaitTextToBePresentInElement(loginErrorMessage, 10, "Please enter valid phone number");
        return this;
    }

    @Step("Validate login required error message")
    public StoneEdgeTradingLogin validateLoginRequiredMessage() {
        utils.ExplicitWaiting.explicitWaitTextToBePresentInElement(loginErrorMessage, 10, "Required");
        return this;
    }

    @Step("Click on Password field")
    public StoneEdgeTradingLogin clickOnPasswordField() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginPasswordTextBox);
        loginPasswordTextBox.click();
        return this;
    }

    @Step("Click on Login field")
    public StoneEdgeTradingLogin clickOnLoginField() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginPhoneTextBox);
        loginPhoneTextBox.click();
        return this;
    }

    @Step("Validate notification error message")
    public StoneEdgeTradingLogin validateNotificationErrorMessage(String message) {
        utils.ExplicitWaiting.explicitWaitTextToBePresentInElement(notificationWrapper, 20, message);
        return this;
    }

    @Step("Validate password is too short error message")
    public StoneEdgeTradingLogin validateTooShortPasswordErrorMessage() {
        utils.ExplicitWaiting.explicitWaitTextToBePresentInElement(loginErrorMessage, 10, "Password is too short");
        return this;
    }

    @Step("Click Ok policy button")
    public StoneEdgeTradingLogin clickOkButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, okButton);
        okButton.click();
        return this;
    }

    @Step("Click <<It's not me>> link")
    public StoneEdgeTradingLogin clickItsNotMeLink() {
        itsNotMeLink.click();
        return this;
    }

    public StoneEdgeTradingDashboard quickLogin(String phone, String password, String verificationCode) {
        for (int i = 0; i < 3; i++) {
            try {
                if (i == 0) {
                    clickAcceptPolicies();
                }
                login(phone, password, verificationCode);
                this.clickAccountName();
                return STEDashboardPage();
            } catch (TimeoutException e) {
                AllureAttachments.saveFullPageScreenshot(Platform.WEB, "login retry", getWebDriver());
                System.out.println("Login retry #" + i + ". Exception:" + e);
                getWebDriver().navigate().to(WebsiteURL);
            }
        }
        throw new TimeoutException("Login retry count exceeded 3.");
    }

    public StoneEdgeTradingDashboard quickLoginOneAccount(String phone, String password, String verificationCode) {
        for (int i = 0; i < 3; i++) {
            try {
                if (i == 0) {
                    clickAcceptPolicies();
                }
                login(phone, password, verificationCode);
                return STEDashboardPage();
            } catch (TimeoutException e) {
                AllureAttachments.saveFullPageScreenshot(Platform.WEB, "login retry", getWebDriver());
                System.out.println("Login retry #" + i + ". Exception:" + e);
                getWebDriver().navigate().to(WebsiteURL);
            }
        }
        throw new TimeoutException("Login retry count exceeded 3.");
    }

    private void login(String phone, String password, String verificationCode) throws TimeoutException {
        this.enterLoginPhoneNumber(phone)
                .enterLoginPassword(password)
                .clickLoginButton()
                .enterSmsCode(verificationCode)
                .clickLoginButton();
    }

    @Step("Click dealer desk member")
    public StoneEdgeTradingLogin clickDealerDeskMember() {
        dealerDeskMembers.get(dealerDeskMembers.size()-1).click();
        return this;
    }
    
    public StoneEdgeTradingDashboard quickLoginOnDealerDesk(String phone, String password) {
        for (int i = 0; i < 3; i++) {
            try {
                if (i == 0) {
                    clickAcceptPolicies();
                }
                this.enterLoginPhoneNumber(phone)
                        .enterLoginPassword(password)
                        .clickLoginButton()
                        .clickDealerDeskMember();
                return STEDashboardPage();
            } catch (TimeoutException e) {
                AllureAttachments.saveFullPageScreenshot(Platform.WEB, "login retry", getWebDriver());
                System.out.println("Login retry #" + i + ". Exception:" + e);
                getWebDriver().navigate().to(WebsiteURL);
            }
        }
        throw new TimeoutException("Login retry count exceeded 3.");
    }





    @Step("Choose account name from drop down when account names are several")
    public StoneEdgeTradingLogin checkAccountNamesByIndex(int index) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, accountName);
        accountNamesCheckBox.get(index).click();
        return this;
    }

    public String getAccountSwitchName(int index) {
        return accountNamesCheckBox.get(index).getText();
    }

    //didNotGetCodeSendAgainLink

    @Step("verify if << Did not get code. Send again>> link is present")
    public StoneEdgeTradingLogin checkDidNotGetCodeSendAgainLinkIsPresent() {
        Assert.assertTrue(this.isButtonPresent());
        return this;
    }

    @Step("verify if << Did not get code. Send again>> link is not present")
    public StoneEdgeTradingLogin checkDidNotGetCodeSendAgainLinkIsNotPresent() {
        Assert.assertFalse(this.isButtonPresent());
        return this;
    }

    @Step("Click <<Did not get code. Send again>> link")
    public StoneEdgeTradingLogin clickDidNotGetCodeSendAgainLink() {
        sleep(61000);
        didNotGetCodeSendAgainLink.click();
        return this;
    }

    public boolean isButtonPresent() {
        return this.isElementPresent("//button[contains(@class, 'style__resend-button')]");
    }

    public String getAccountCurrency(int index) {
        return accountCurrency.get(index).getText();
    }


}
