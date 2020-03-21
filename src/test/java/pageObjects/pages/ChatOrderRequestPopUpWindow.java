package pageObjects.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.List;

public class ChatOrderRequestPopUpWindow extends PageFactoryInitializer {

    @FindBy(xpath = "//div[@data-window-name='chat']//div[contains(@class,'header-title___bur5l')]")
    private WebElement chatTitle;

    @FindBy(xpath = "//div[@data-window-name='chat']//div[contains(@class,'TradingPage-containers-Chat-___style__symbol')]")
    private WebElement currentInstrument;

    @FindBy(xpath = "//div[@data-window-name='chat']//i[@class='icon-icon-cancel']")
    private WebElement closePopupButton;

    @FindBy(xpath = "//div[@data-window-name='chat']//div[@class='app-pages-TradingPage-containers-Chat-___style__message___1CXl4']")
    private List<WebElement> messageArea;

    @FindBy(xpath = "//input[@name='message']")
    private WebElement message;

    @FindBy(xpath = "//div[@data-window-name='chat']//button[contains(.,'Send')]")
    private WebElement sendButton;

    @Step("Verify fields on order request chart window {0}")
    public ChatOrderRequestPopUpWindow verifyFieldsOnChatOrderRequest(String instrumentName) {
        sleep(1500);
        ExplicitWaiting.explicitWaitTextToBePresentInElement(chatTitle, 30, "Order chat");
        //ExplicitWaiting.explicitWaitTextToBePresentInElement(currentInstrument, 30, instrumentName);
        Assert.assertTrue(currentInstrument.getText().contains(instrumentName));
        return this;
    }

    @Step("Click on send button")
    public ChatOrderRequestPopUpWindow clickSendButton() {
        sendButton.click();
        return this;
    }

    @Step("Clear field price")
    public ChatOrderRequestPopUpWindow clearMessageField() {
        this.clearInput(message);
        return this;
    }

    @Step("Enter message {0}")
    public ChatOrderRequestPopUpWindow enterMessage(String msg) {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, message);
        message.sendKeys(msg);
        return this;
    }

    @Step("Click on cancel icon")
    public ChatOrderRequestPopUpWindow clickCancelWindow() {
        closePopupButton.click();
        return this;
    }

    @Step("Verify message is appeared on text area  {0}")
    public ChatOrderRequestPopUpWindow verifyMessageAppearedOnChatArea(String message) {
        if (messageArea.size() != 0) {
            Assert.assertEquals(messageArea.get(messageArea.size() - 1).getText(), message);
        }
        return this;
    }

    @Step("Verify if send button is disabled")
    public ChatOrderRequestPopUpWindow isSendButtonDisabled() {
        Assert.assertFalse(sendButton.isEnabled());
        return this;
    }

}
