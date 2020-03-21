package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.pages.registration.CRSSelfCertificationForm;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.List;
import java.util.regex.Pattern;

public class SettingsPage extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(@class,'Popup-___style__header-text')]//span")
    private WebElement settingHeader;

    @FindBy(xpath = "//div[@id='modal-windows-container']//i[@class='icon-icon-cancel']")
    private WebElement cancelIconButton;

    //Profile tab fields
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextBox;

    //Security tab fields

    @FindBy(xpath = "//div[contains(text(),'Security')]")
    private WebElement securityTab;

    @FindBy(xpath = "//input[@name='oldPassword']")
    private WebElement oldPasswordTextBox;

    @FindBy(xpath = "//input[@name='newPassword']")
    private WebElement newPasswordTextBox;

    @FindBy(xpath = "//input[@name='repeatedPassword']")
    private WebElement repeatNewPasswordTextBox;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement smsCodeInputTextBox;

    @FindBy(xpath = "//input[@name='smsCode']")
    private WebElement smsAuthenticationTextBox;

    @FindBy(xpath = "//button[text()='Confirm with code']")
    private WebElement confirmWithCodeButton;

    @FindBy(xpath = "//button[text()='Change password']")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//span[contains(text(),'SMS')]")
    private WebElement smsAuthenticationSpan;

    @FindBy(xpath = "//span[contains(text(),'Off')]")
    private WebElement offAuthenticationSpan;

    @FindBy(xpath = "//button[contains(@class,'changeCodeButton')]")
    private WebElement changeSmsAuthenticationButton;

    //Trading tab fields

    @FindBy(xpath = "//div[contains(text(),'Trading')]")
    private WebElement tradingTab;

    @FindBy(xpath = "//div[@class='app-containers-ProfileSettings-___style__sections___1iCzs']//span[contains(text(),'USD')]")
    private WebElement usdCurrencySpan;

    @FindBy(xpath = "//div[@class='app-containers-ProfileSettings-___style__sections___1iCzs']//span[contains(text(),'EUR')]")
    private WebElement eurCurrencySpan;

    @FindBy(xpath = "//div[@class='app-containers-ProfileSettings-___style__sections___1iCzs']//span[contains(text(),'RUB')]")
    private WebElement rubCurrencySpan;

    @FindBy(xpath = "//div[@class='app-containers-ProfileSettings-___style__sections___1iCzs']//span[contains(text(),'GBP')]")
    private WebElement gbpCurrencySpan;

    @FindBy(xpath = "//div[contains(@class,'style__value')]//input")
    private List<WebElement> tradingAmounts;

    @FindBy(xpath = "//span[contains(@class,'app-containers-ProfileSettings-___style__amount')]")
    private List<WebElement> tradingAmountSpans;

    @FindBy(xpath = "//div[contains(@class,'style__settings')]//div[contains(@class,'react-select__control')]//input")
    private List<WebElement> tradingMultiplierInputs;

    @FindBy(xpath = "//div[contains(@class,'style__settings')]//form//div[contains(@class,'react-select__control')]")
    private List<WebElement> tradingMultipliers;

    @FindBy(xpath = "(//div[contains(@class,'style__settings')]//div[contains(@class,'Select-control')])[1]")
    private WebElement forexMultiplier;

    @FindBy(xpath = "(//div[contains(@class,'style__settings')]//div[contains(@class,'Select-control')])[2]")
    private WebElement equityMultiplier;

    @FindBy(xpath = "(//div[contains(@class,'style__settings')]//div[contains(@class,'Select-control')])[3]")
    private WebElement bondsMultiplier;

    @FindBy(xpath = "(//div[contains(@class,'style__settings')]//div[contains(@class,'Select-control')])[4]")
    private WebElement optionsMultiplier;

    @FindBy(xpath = "(//div[contains(@class,'style__settings')]//div[contains(@class,'Select-control')])[5]")
    private WebElement futuresMultiplier;

    @FindBy(xpath = "//label[contains(.,'Enable quick trade')]//input")
    private WebElement quickTradeSwitch;

    @FindBy(xpath = "//label[contains(.,'Position closing confirmation')]")
    private WebElement positionsCloseSwitchLabel;

    @FindBy(xpath = "//label[contains(.,'Position closing confirmation')]//input")
    private WebElement positionsCloseSwitchInput;

    //Appearance tab fields

    @FindBy(xpath = "//div[contains(text(),'Appearance')]")
    private WebElement appearanceTab;

    @FindBy(xpath = "//span[contains(text(),'Dark')]")
    private WebElement darkSpan;

    @FindBy(xpath = "//span[contains(text(),'Light')]")
    private WebElement lightSpan;

    @Step("Enter old password")
    public SettingsPage enterOldPassword(String password) {
        oldPasswordTextBox.sendKeys(password);
        return this;
    }

    @Step("Enter old password")
    public SettingsPage clearOldPassword() {
        this.clearInput(oldPasswordTextBox);
        return this;
    }

    @Step("Enter new password")
    public SettingsPage enterNewPassword(String password) {
        newPasswordTextBox.sendKeys(password);
        return this;
    }

    @Step("Repeat new password")
    public SettingsPage enterRepeatNewPassword(String password) {
        repeatNewPasswordTextBox.sendKeys(password);
        return this;
    }

    @Step("Enter sms code")
    public SettingsPage enterSmsCode(String password) {
        smsCodeInputTextBox.sendKeys(password);
        return this;
    }

    @Step("Click confirm with code")
    public SettingsPage clickConfirmWithCodeButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, confirmWithCodeButton);
        confirmWithCodeButton.click();
        return this;
    }

    @Step("Verify new password input field is disabled")
    public SettingsPage checkConfirmWithCodeButtonIsDisabled() {
        Assert.assertFalse(confirmWithCodeButton.isEnabled());
        return this;
    }

    @Step("Click change password")
    public SettingsPage clickChangePasswordButton() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, changePasswordButton);
        changePasswordButton.click();
        return this;
    }

    @Step("Verify new password input field is disabled")
    public SettingsPage checkNewPasswordTextBoxIsDisabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, newPasswordTextBox);
        Assert.assertFalse(newPasswordTextBox.isEnabled());
        return this;
    }

    @Step("Verify repeat new password input field is disabled")
    public SettingsPage checkRepeatNewPasswordTextBoxIsDisabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, repeatNewPasswordTextBox);
        Assert.assertFalse(repeatNewPasswordTextBox.isEnabled());
        return this;
    }

    @Step("Verify repeat new password input field is disabled")
    public SettingsPage ifSmsCodeInputIsNotPresent() {
        this.isElementPresent("//input[@name='code']");
        return this;
    }

    @Step("Verify <<change password>> span is not present")
    public SettingsPage ifChangePasswordSpanIsNotPresent() {
        Assert.assertFalse(this.isElementPresent("//span[contains(text(),'Change password')]"));
        return this;
    }

    @Step("Click security tab on settings pop up window")
    public SettingsPage clickSecurityTab() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, securityTab);
        securityTab.click();
        return this;
    }

    @Step("Click appearance tab on settings pop up window")
    public SettingsPage clickAppearanceTab() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, appearanceTab);
        appearanceTab.click();
        return this;
    }

    @Step("Click smsOnButton on security button")
    public SettingsPage clickSmsTab() {
        sleep(1000);
        smsAuthenticationSpan.click();
        return this;
    }

    @Step("Click smsOffButton on security button")
    public SettingsPage clickOffTab() {
        sleep(1000);
        offAuthenticationSpan.click();
        return this;
    }

    @Step("Enter sms authentication code")
    public SettingsPage enterSmsAuthentication(String sms) {
        sleep(1000);
        smsAuthenticationTextBox.sendKeys(sms);
        return this;
    }

    @Step("Click change button on security tab")
    public SettingsPage clickChangeSmsAuthenticationSpan() {
        changeSmsAuthenticationButton.click();
        return this;
    }

    @Step("Verify sms authentification input text box is disabled")
    public SettingsPage checkSmsAuthenticationDisabled() {
        sleep(1000);
        Assert.assertFalse(smsAuthenticationTextBox.isEnabled());
        return this;
    }

    @Step("Click trading tab on settings pop up window")
    public SettingsPage clickTradingTab() {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, tradingTab);
        tradingTab.click();
        return this;
    }

    @Step("Click USD currency button on trading tab")
    public SettingsPage clickUSDCurrency() {
        sleep(1000);
        scrollIntoView(usdCurrencySpan);
        usdCurrencySpan.click();
        return this;
    }

    @Step("Click EUR currency button on trading tab")
    public SettingsPage clickEURCurrency() {
        sleep(1000);
        scrollIntoView(eurCurrencySpan);
        eurCurrencySpan.click();
        return this;
    }

    @Step("Click RUB currency button on trading tab")
    public SettingsPage clickRUBCurrency() {
        sleep(1000);
        scrollIntoView(rubCurrencySpan);
        rubCurrencySpan.click();
        return this;
    }

    @Step("Click GBP currency button on trading tab")
    public SettingsPage clickGBPCurrency() {
        sleep(1000);
        scrollIntoView(gbpCurrencySpan);
        gbpCurrencySpan.click();
        return this;
    }

    @Step("Enter trading amount on trading tab")
    public SettingsPage enterTradingAmount(int index, String amount) {
        scrollIntoView(tradingAmounts.get(index));
        tradingAmounts.get(index).sendKeys(amount);
        return this;
    }

    @Step("Enter trading amount on trading tab")
    public SettingsPage clearTradingAmount(int index) {
        scrollIntoView(tradingAmounts.get(index));
        this.clearInput(tradingAmounts.get(index));
        return this;
    }

    @Step("Verify trading amount on trading tab")
    public SettingsPage verifyTradingAmount(int index, String amount) {
        scrollIntoView(tradingAmountSpans.get(index));
        sleep(2000);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingAmountSpans.get(index), 30, amount);

        return this;
    }

    @Step("Set trading multiplier")
    public SettingsPage selectTradingMultiplier(String multiplier, int index) {
        scrollIntoView(tradingMultiplierInputs.get(index));
        sleep(1000); //TODO remove this later
        tradingMultipliers.get(index).click();
        tradingMultiplierInputs.get(index).sendKeys(multiplier + Keys.ENTER);
        return this;
    }

    @Step("Click close settings window")
    public SettingsPage clickCancelIcon() {
        cancelIconButton.click();
        return this;
    }

    @Step("Click dark button on appearance tab")
    public SettingsPage clickDarkSpan() {
        sleep(1000);
        darkSpan.click();
        return this;
    }

    @Step("Click light button on appearance tab")
    public SettingsPage clickLightSpan() {
        sleep(1000);
        lightSpan.click();
        return this;
    }

    @Step("Click <<Position close confirmation>>")
    public SettingsPage clickCloseConfirmationSwitcher() {
        positionsCloseSwitchLabel.click();
        return this;
    }

    @Step("Verify if you on Setting window")
    public SettingsPage verifySettingWindow() {
        Assert.assertEquals(settingHeader.getText(), "Settings");
        return this;
    }

    public boolean isPositionCloseConfirmationSwitchedOn() {
        scrollIntoView(positionsCloseSwitchInput);
        return positionsCloseSwitchInput.getAttribute("value").contains("true");
    }

    public String getFirstName() {
        return firstNameTextBox.getAttribute("value");
    }

    public String getLastName() {
        return lastNameTextBox.getAttribute("value");
    }

}
