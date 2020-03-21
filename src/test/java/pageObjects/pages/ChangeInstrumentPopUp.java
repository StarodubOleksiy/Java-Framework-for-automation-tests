package pageObjects.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.ExplicitWaiting;

import java.util.Arrays;
import java.util.List;

public class ChangeInstrumentPopUp extends PageFactoryInitializer {

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//h4[contains(text(),'Bid')]")
    private WebElement bidHeader;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//h4[contains(text(),'Spread')]")
    private WebElement spreadHeader;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//h4[contains(text(),'Ask')]")
    private WebElement askHeader;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//span[contains(text(),'Quote currency')]")
    private WebElement quoteCurrencyRow;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//span[contains(text(),'Base currency')]")
    private WebElement baseCurrencyRow;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//span[contains(text(),'Value date lag')]")
    private WebElement valueDateLagRow;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//span[contains(text(),'Pip size')]")
    private WebElement pipSizeRow;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//span[contains(text(),'Price Unit')]")
    private WebElement priceUnitRow;

    @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//div[contains(text(),'Main session')]")
    private WebElement mainSessionRow;

     @FindBy(xpath = "//div[contains(@class,'InstrumentCard')]//div[contains(text(),'Offline')]")
    private WebElement offlineRow;


    @Step("Verify instrument pop up card window")
    public ChangeInstrumentPopUp verifyInstrumentCard() {
        ExplicitWaiting.explicitWaitTextToBePresentInElement(bidHeader, 30, "Bid");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(spreadHeader, 30, "Spread");
        ExplicitWaiting.explicitWaitTextToBePresentInElement(askHeader, 30, "Ask");
        return this;
    }


    @Step("Verify valid instrument which need to work with current widget")
    public ChangeInstrumentPopUp verifyInstrument(String dataWindowName, String instrumentName) {
        // sleep(2000);
        WebElement element = getWebDriver().findElement(By.xpath(String.format("//div[@data-window-name='" + dataWindowName + "']//span[contains(text(),'%s')]", instrumentName)));
        String actualInstrumentName = String.valueOf(element.getText().toCharArray(), 0, instrumentName.length());
        Assert.assertEquals(instrumentName, actualInstrumentName);
        return this;
    }

    @Step("Click on instrument")
    public ChangeInstrumentPopUp selectInstrument(String pathToInstrument, String itemName) {
        List<String> instrumentLevels = Arrays.asList(pathToInstrument.split("/"));
        instrumentLevels.forEach(il -> {     //h4[@data-instrument-level-name='FX']"}
            WebElement instrumentLevel = getWebDriver().findElement(By.xpath(String.format("//h4[@data-instrument-level-name='%s']", il)));
            scrollIntoView(instrumentLevel);
            instrumentLevel.click();
        });
        if (!StringUtils.isEmpty(itemName)) {
            WebElement instrumentItem = getWebDriver().findElement(By.xpath(String.format("//h4[@data-instrument-item-name='%s']", itemName)));
            scrollIntoView(instrumentItem);
            instrumentItem.click();
        }
        return this;
    }

    @Step("Enter instrument {1} into widget {0}")
    public ChangeInstrumentPopUp changeInstrument(String dataWindowName, String instrumentName) {
        WebElement inputInstrumentElement = getWebDriver().findElement(By.xpath(String.format("//div[@data-window-name='" + dataWindowName + "']" +
                "//div[contains(@class,'app-containers-InstrumentsTree-___style__search-input')]//input")));
        inputInstrumentElement.sendKeys(instrumentName);
        WebElement instrumentDiv = getWebDriver().findElement(By.xpath(String.format("//div[span[contains(text(),'%s')]]"
                , instrumentName)));
        sleep(1000);
        //utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, instrumentDiv);
        instrumentDiv.click();
        return this;
    }

}
