package pageObjects.pages;

import data.RegistrationInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.pages.registration.IndividualVerificationBase;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;
import utils.FluentWaiting;

import java.util.ArrayList;
import java.util.List;

import static controllers.WebDriverFactory.getWebDriver;

public class OpenAccountForm {

    @FindBy(xpath = "//button[contains(text(),'Individual')]")
    private WebElement individualButton;

    @FindBy(xpath = "//button[contains(text(),'Corporate')]")
    private WebElement corporateButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Open account')]")
    private WebElement openAccountButton;

    @FindBy(partialLinkText = ("Log in"))
    private WebElement logInLink;

    @FindBy(xpath = "//div[contains(@class,'notifications-wrapper')]")
    private WebElement notificationWrapper;

    @FindBy(xpath = "//span[contains(@class,'error-message')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[contains(@class,'error-message')]")
    private List<WebElement> errorMessages;


    @Step("Click Individual button")
    public OpenAccountForm clickIndividualButton() {
        individualButton.click();
        return this;
    }

    @Step("Click Corporate button")
    public OpenAccountForm clickCorporateButton() {
        corporateButton.click();
        return this;
    }

    @Step("Enter first name {0}")
    public OpenAccountForm enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Enter last name {0}")
    public OpenAccountForm enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Enter email {0}")
    public OpenAccountForm enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Click first name field")
    public OpenAccountForm clickFirstName() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, firstNameInput);
        firstNameInput.click();
        return this;
    }

    @Step("Click first name field")
    public OpenAccountForm clickLastName() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, lastNameInput);
        lastNameInput.click();
        return this;
    }

    @Step("Enter password {0}")
    public OpenAccountForm enterPassword(String password) {
        FluentWaiting.waitUntillElementToBeVisible(60, 500,  passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click email field")
    public OpenAccountForm clickEmail() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, emailInput);
        emailInput.click();
        return this;
    }

    @Step("Click password field")
    public OpenAccountForm clickPassword() {
        passwordInput.click();
        return this;
    }

    @Step("Click Open Account button")
    public OpenAccountForm clickOpenAccountButton() {
        openAccountButton.click();
        return this;
    }

    @Step("Click Log In link")
    public OpenAccountForm clickLogInLink() {
        logInLink.click();
        return this;
    }

    @Step("Validate login field error message")
    public OpenAccountForm validateErrorMessage(String error) {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(errorMessage, 30, error);
        return this;
    }

    @Step("Validate if open account button is enabled")
    public OpenAccountForm ifOpenAccountButtonIsEnabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, openAccountButton);
        Assert.assertTrue(openAccountButton.isEnabled());
        return this;
    }

    @Step("Validate if open account button is disabled")
    public OpenAccountForm ifOpenAccountButtonIsDisabled() {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, openAccountButton);
        Assert.assertFalse(openAccountButton.isEnabled());
        return this;
    }

    public OpenAccountForm fillInRequiredFields(RegistrationInfo registrationInfo) {
        this/*.clickIndividualButton()*/
                .enterFirstName(registrationInfo.getFirstName())
                .enterLastName(registrationInfo.getLastName())
                .enterEmail(registrationInfo.getEmailAddress())
                .enterPassword(registrationInfo.getPassword());
        return this;
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Validate error messages {0}")
    public OpenAccountForm validateErrorMessagesArePresent(List<String> expectedErrorMessages) {
        List<String> actualErrorMessages = new ArrayList<String>();
        for (WebElement error: errorMessages) {
            scrollIntoView(error);
            actualErrorMessages.add(error.getText());
        }
        Assert.assertEquals(actualErrorMessages, expectedErrorMessages);
        return this;
    }

}