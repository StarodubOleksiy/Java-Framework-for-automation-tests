package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

public class EditOrderRequestPopUpWindow extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Edit order request')]")
    private WebElement editOrderRequestTitle;

    @FindBy(xpath = "//div[@id='modal-windows-container']//div[contains(text(),'Bid')]")
    private WebElement bidColumn;

    @FindBy(xpath = "//div[@id='modal-windows-container']//div[contains(text(),'Spread')]")
    private WebElement spreadColumn;

    @FindBy(xpath = "//div[@id='modal-windows-container']//div[contains(text(),'Ask')]")
    private WebElement askColumn;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Buy')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Sell')]")
    private WebElement sellButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Amount')]")
    private WebElement amountField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Type')]")
    private WebElement typeField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Duration')]")
    private WebElement durationField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//label[contains(text(),'Execution type')]")
    private WebElement executionTypeField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//input[@name='orderQty']")
    private WebElement amount;

    @FindBy(xpath = "//div[@id='modal-windows-container']//input[@name='expectedPrice']")
    private WebElement expectedPrice;

    @FindBy(xpath = "//div[@id='modal-windows-container']//div[contains(@class,'InstrumentInfo-___style__instrument-name-id___1AqTk')]")
    private WebElement symbolDescription;

    @FindBy(xpath = "//div[@id='modal-windows-container']//button[contains(.,'Edit buy  order')]")
    private WebElement updateButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(text(),'Order ticket')]")
    private WebElement orderTicketTitle;

    @FindBy(xpath = "//div[@id='modal-windows-container']//div[contains(@class,'instrument-name-id')]")
    private WebElement instrumentNameTitle;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[contains(.,'Edit buy  order')]")
    private WebElement editBuyOrderButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[text()='Manual']")
    private WebElement manualButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[text()='Automatic']")
    private WebElement automaticButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//span[text()='Any']")
    private WebElement anyButton;

    @FindBy(xpath = "//div[@id='modal-windows-container']//th[text()='Trading details']")
    private WebElement tradingDetailsField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//th[contains(text(),'Buy')]")
    private WebElement buyField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//th[contains(text(),'Sell')]")
    private WebElement sellField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//th[text()='Nominal value']")
    private WebElement nominalValueField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//th[text()='Margin impact']")
    private WebElement marginImpactField;

    @FindBy(xpath = "//div[@id='modal-windows-container']//th[text()='Margin after trade']")
    private WebElement marginAfterTradeField;


    @Step("Verify fields on edit order request window")
    public EditOrderRequestPopUpWindow verifyFieldsOnEditOrderRequest(String instrumentName) {
        sleep(1500);
        Assert.assertEquals(symbolDescription.getText(), instrumentName);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(bidColumn, 30, "Bid");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(spreadColumn, 30, "Spread");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(askColumn, 30, "Ask");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(amountField, 30, "Amount");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(typeField, 30, "Type");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(durationField, 30, "Duration");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(executionTypeField, 30, "Execution type");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(manualButton, 30, "Manual");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(automaticButton, 30, "Automatic");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(anyButton, 30, "Any");
        return this;
    }

    @Step("Verify fields on edit order request window on market session")
    public EditOrderRequestPopUpWindow verifyFieldsOnEditOrderRequestEQ(String instrumentName) {
        this.verifyFieldsOnEditOrderRequest(instrumentName);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(tradingDetailsField, 30, "Trading details");
        Assert.assertTrue(buyField.getText().contains("Buy"));
        Assert.assertTrue(sellField.getText().contains("Sell"));
        ExplicitWaiting.explicitWaitTextToBePresentInElement(nominalValueField, 30, "Nominal value");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(marginImpactField, 30, "Margin impact");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(marginAfterTradeField, 30, "Margin after trade");
        return this;
    }

    @Step("Clear field amount")
    public EditOrderRequestPopUpWindow clearAmountField() {
        this.clearInput(amount);
        return this;
    }


    @Step("Fill in amount field")
    public EditOrderRequestPopUpWindow enterAmount(String amountName) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, amount);
        amount.sendKeys(amountName);
        return this;
    }

    @Step("Fill in expected price field")
    public EditOrderRequestPopUpWindow enterPrice(String priceName) throws Exception {
        Thread.sleep(100);
        expectedPrice.sendKeys(priceName);
        return this;
    }


    @Step("Click edit order buy button")
    public EditOrderRequestPopUpWindow clickEditBuyOrderButton() {
        sleep(500);
        editBuyOrderButton.click();
        return this;
    }

    @Step("Verify if <<Edit buy  order>> button is disabled")
    public EditOrderRequestPopUpWindow isEditBuyOrderButtonDisabled() {
        Assert.assertFalse(updateButton.isEnabled());
        return this;
    }


}
