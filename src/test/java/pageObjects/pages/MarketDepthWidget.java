package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.pages.registration.IndividualVerificationBase;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;
import utils.FluentWaiting;

public class MarketDepthWidget extends IndividualVerificationBase {

    @FindBy(xpath = "//div[@data-window-name='marketDepth']//div[contains(text(),'Market depth')]")
    private WebElement marketDepthWidgetTitle;

    @FindBy(xpath = "//div[@data-window-name='marketDepth']//span[contains(@class,'instrument-selector-instrument___AI0TA')]")
    private WebElement instrument;

    @FindBy(xpath = "//th[contains(text(),'Total amount')]")
    private WebElement totalAmountColumn;

    @FindBy(xpath = "//th[contains(text(),'Price')]")
    private WebElement priceColumn;

    @FindBy(xpath = "//td[contains(text(),'Spread')]")
    private WebElement spreadColumn;

    @FindBy(xpath = "//div[contains(text(),'pips')]")
    private WebElement pipsColumn;

    @FindBy(xpath = "//div[@data-window-name='marketDepth']//i[contains(@class,'icon-icon-search')]")
    private WebElement changeInstrumentButton;

    @FindBy(xpath = "//div[@data-window-name='marketDepth']//i[@class='icon-icon-cancel']")
    private WebElement closeButton;


    @Step("Verify if market depth widget is present")
    public MarketDepthWidget verifyMarketDepthWidgetPresent() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(marketDepthWidgetTitle, 30, "Market depth");
        return this;
    }

    @Step("Click market depth title")
    public MarketDepthWidget clickTitle() {
        marketDepthWidgetTitle.click();
        return this;
    }

    @Step("Verify market depth content")
    public MarketDepthWidget verifyMarketDepthContent() {
        Assert.assertTrue(totalAmountColumn.isDisplayed());
        Assert.assertTrue(priceColumn.isDisplayed());
        Assert.assertTrue(spreadColumn.isDisplayed());
        Assert.assertTrue(pipsColumn.isDisplayed());
        return this;
    }

    @Step("Click on change instrument tool")
    public MarketDepthWidget clickChangeInstruments() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, changeInstrumentButton);
        changeInstrumentButton.click();
        return this;
    }

    @Step("Click on instrument span")
    public MarketDepthWidget clickInstruments() {
        FluentWaiting.waitUntillElementToBeVisible(60, 500, instrument);
        instrument.click();
        return this;
    }

    public String getCurrentInstrument() {
        return instrument.getText();
    }

    @Step("Click market depth close button")
    public MarketDepthWidget clickCloseButton() {
        closeButton.click();
        return this;
    }
}
