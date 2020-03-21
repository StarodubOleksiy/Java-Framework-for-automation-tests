package pageObjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import pageObjects.pages.registration.CRSSelfCertificationForm;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.List;

public class FundsWithdrawalWindow extends PageFactoryInitializer {

    @FindBy(xpath = "//b[contains(text(),'Funds withdrawal')]")
    private WebElement fundsWithdrawalTitle;

    @FindBy(xpath = "//p[contains(@class,'PaymentsPage-Withdrawal-___styles__text-center___soU_Q')]")
    private WebElement withdrawnWindowText;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//div[contains(@class,'react-select__control')]")
    private WebElement withdrawPayment;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//div[contains(@class,'react-select__control')]//input")
    private WebElement withdrawPaymentInput;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//span[contains(text(),'USD')]")
    private WebElement currencyUSD;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//span[contains(text(),'EUR')]")
    private WebElement currencyEUR;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//span[contains(text(),'RUB')]")
    private WebElement currencyRUB;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//span[contains(text(),'GBP')]")
    private WebElement currencyGBP;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amount;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement description;

    @FindBy(xpath = "//span[contains(text(),'Amount')]")
    private WebElement amountField;

    @FindBy(xpath = "//span[contains(text(),'Withdraw to')]")
    private WebElement withdrawToField;

    @FindBy(xpath = "//span[contains(text(),'Comment')]")
    private WebElement commentField;

    @FindBy(xpath = "//button[contains(@class,'containers-PaymentsPage-Withdrawal-___styles__btn-ok')]")
    private WebElement requestWithdrawalButton;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal')]//button[contains(text(),'Reset')]")
    private WebElement resetButton;

    @FindBy(xpath = "//td[contains(@class,'PaymentsPage-Withdrawal-___styles__fix-width-lg___26fK5')]")
    private List<WebElement> withdrawalRow;

    @FindBy(xpath = "//tr[contains(@class,'PaymentsPage-Withdrawal-___styles__withdrawal-table-row___2ZdL1')]")
    private List<WebElement> withdrawalCancelRequestRow;

    @FindBy(xpath = "//p[contains(@class,'PaymentsPage-Withdrawal-___styles__text-center')]//span")
    private List<WebElement> availableCurrency;

    @FindBy(xpath = "//button[contains(@class,'PaymentsPage-Withdrawal-___styles__cancel-request')]")
    private List<WebElement> cancelRequestButton;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal-___styles__pending___YSp1t')]")
    private List<WebElement> pendingIcon;

    @FindBy(xpath = "//div[contains(@class,'PaymentsPage-Withdrawal-___styles__rejected___GKOaR')]")
    private List<WebElement> rejectedIcon;

    @Step("select currency {0}")
    public FundsWithdrawalWindow specifyCurrency(String currencyType) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, currencyUSD);
        scrollIntoView(currencyUSD);
        switch (currencyType) {
            case "EUR":
                sleep(500);
                scrollIntoView(currencyEUR);
                currencyEUR.click();
                break;
            case "USD":
                sleep(500);
                scrollIntoView(currencyUSD);
                currencyUSD.click();
                break;
            case "RUB":
                sleep(500);
                scrollIntoView(currencyRUB);
                currencyRUB.click();
                break;
            default:
                sleep(500);
                scrollIntoView(currencyGBP);
                currencyGBP.click();
                break;
        }
        return this;
    }

    @Step("Set withdraw to")
    public FundsWithdrawalWindow setWithdrawTo(String payment) {
        scrollIntoView(withdrawPayment);
       //withdrawPayment.click();
        withdrawPaymentInput.sendKeys(payment + Keys.ENTER);
        return this;
    }


    @Step("Verify currency funds withdrawal window")
    public FundsWithdrawalWindow verifyCurrency(String currency) {
        Assert.assertTrue(withdrawnWindowText.getText().contains(currency));
        return this;
    }

    //fundsWithdrawalTitle
    @Step("Verify fields on funds withdrawn window")
    public FundsWithdrawalWindow verifyFieldsOnFundsWithdrawnWindow(String currency) {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(fundsWithdrawalTitle, 30, "Funds withdrawal");
        Assert.assertTrue(withdrawnWindowText.getText().contains("Your funds will be withdrawn from "));
        Assert.assertTrue(withdrawnWindowText.getText().contains(". Available amount "));
        Assert.assertTrue(withdrawnWindowText.getText().contains(currency));
        ExplicitWaiting.explicitWaitTextToBePresentInElement(amountField, 30, "Amount");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(withdrawToField, 30, "Withdraw to");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(commentField, 30, "Comment");
        return this;
    }

    @Step("Enter the amount")
    public FundsWithdrawalWindow enterAmount(String amountName) {
        scrollIntoView(amount);
        amount.sendKeys(amountName);
        return this;
    }

    @Step("Enter the comment")
    public FundsWithdrawalWindow enterComment(String comment) {
        scrollIntoView(description);
        description.sendKeys(comment);
        return this;
    }

    @Step("Click on <request withdrawal>> button")
    public FundsWithdrawalWindow clickRequestWithdrawalButton() {
        sleep(500);
        requestWithdrawalButton.click();
        return this;
    }

    @Step("Click on reset button")
    public FundsWithdrawalWindow clickResetButton() {
        sleep(500);
        resetButton.click();
        return this;
    }

    @Step("Verify bank account name")
    public FundsWithdrawalWindow verifyPaymentMethod(String currency, String name) {
        sleep(1000);
        scrollIntoView(withdrawalRow.get(0));
        Assert.assertTrue(withdrawalRow.get(0).getText().contains(currency));
        Assert.assertTrue(withdrawalRow.get(0).getText().contains(name));
        return this;
    }

    @Step("Verify <<description>> field")
    public FundsWithdrawalWindow verifyDescriptionField(String descr) {
        Assert.assertEquals(descr, description.getText());
        return this;
    }

    @Step("Clear field amount")
    public FundsWithdrawalWindow clearAmountField() {
        this.clearInput(amount);
        return this;
    }

    @Step("Clear field withdrawPayment")
    public FundsWithdrawalWindow clearWithdrawPaymentField() {
        this.clearInput(withdrawPaymentInput);
        return this;
    }


    @Step("Verify if <<Request withdrawal>> button is disabled")
    public FundsWithdrawalWindow verifyRequestWithdrawalButtonDisabled() {
        Assert.assertFalse(requestWithdrawalButton.isEnabled());
        return this;
    }

    @Step("Verify if <<Request withdrawal>> button is enabled")
    public FundsWithdrawalWindow verifyRequestWithdrawalButtonEnabled() {
        Assert.assertTrue(requestWithdrawalButton.isEnabled());
        return this;
    }

    public String getAvailableCurrency() {
        return availableCurrency.get(0).getText();
    }

    @Step("Click on cancel request button")
    public FundsWithdrawalWindow clickCancelRequestButton() {
        sleep(500);
        scrollIntoView(cancelRequestButton.get(0));
        cancelRequestButton.get(0).click();
        return this;
    }

    @Step("Verify if pending icon is present")
    public FundsWithdrawalWindow ifPendingIconIsPresent() {
        scrollIntoView(pendingIcon.get(0));
        Assert.assertTrue(pendingIcon.get(0).isDisplayed());
        return this;
    }

    @Step("Verify if rejected icon is present")
    public FundsWithdrawalWindow ifRejectedIconIsPresent() {
        scrollIntoView(rejectedIcon.get(0));
        Assert.assertTrue(rejectedIcon.get(0).isDisplayed());
        return this;
    }

    @Step("Verify if request was canceled")
    public FundsWithdrawalWindow verifyRequestWasCanceled() {
        sleep(1500);
        scrollIntoView(withdrawalCancelRequestRow.get(0));
        Assert.assertTrue(withdrawalCancelRequestRow.get(0).getText().contains("Cancelled by client on"));
        return this;
    }


}
