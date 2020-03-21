package pageObjects.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;


public class AddWidgetPopUp extends ChangeInstrumentPopUp {

    @FindBy(xpath = "//div//span[contains(text(),'Ticket')]")
    private WebElement chooseTicketWidget;

    @FindBy(xpath = "//div//span[contains(text(),'Chart')]")
    private WebElement chooseChartWidget;

    @FindBy(xpath = "//div//span[contains(text(),'Market depth')]")
    private WebElement chooseMarketDepthWidget;

    @FindBy(xpath = "//div[contains(@class,'widgets-list')]//span[contains(text(),'News')]")
    private WebElement chooseNewsWidget;

    @FindBy(xpath = "//div//span[contains(text(),'Positions and orders')]")
    private WebElement choosePositionsAndOrdersWidget;

    @FindBy(xpath = "//div//span[contains(text(),'Watchlist')]")
    private WebElement chooseWatchWidget;

    @FindBy(xpath = "//div[contains(@class,'app-components-Popup')]//button[span[contains(text(),'Add widget')]]")
    private WebElement addWidgetPopUpButton;

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Click Ticket widget")
    public AddWidgetPopUp clickTicketWidgetButton() {
        chooseTicketWidget.click();
        return this;
    }

    @Step("Click Chart widget")
    public AddWidgetPopUp clickChartWidgetButton() {
        chooseChartWidget.click();
        return this;
    }

    @Step("Click Market depth widget")
    public AddWidgetPopUp clickMarketDepthWidgetButton() {
        chooseMarketDepthWidget.click();
        return this;
    }

    @Step("Click News widget")
    public AddWidgetPopUp clickNewsWidgetButton() {
        chooseNewsWidget.click();
        return this;
    }

    @Step("Click Positions And Orders widget")
    public AddWidgetPopUp clickPositionsAndOrdersWidgetButton() {
        choosePositionsAndOrdersWidget.click();
        return this;
    }

    @Step("Click Watchlist widget")
    public AddWidgetPopUp clickWatchlistWidgetButton() {
        chooseWatchWidget.click();
        return this;
    }

    @Step("Click Add widget on popup ")
    public AddWidgetPopUp clickAddWidgetPopUpButton() {
//makeElementVisible(positionsButton);

        scrollIntoView(addWidgetPopUpButton);
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500,  addWidgetPopUpButton);
        addWidgetPopUpButton.click();
        return this;
    }

//
//    @Step("Click on instrument")
//    public AddWidgetPopUp selectInstrument(String pathToInstrument, String itemName) {
//        List<String> instrumentLevels = Arrays.asList(pathToInstrument.split("/"));
//        instrumentLevels.forEach(il -> {
//            WebElement instrumentLevel = getWebDriver().findElement(By.xpath(String.format("//h4[@data-instrument-level-name='%s']", il)));
//            instrumentLevel.click();
//        });
//        if (!StringUtils.isEmpty(itemName)) {
//            WebElement instrumentItem = getWebDriver().findElement(By.xpath(String.format("//h4[@data-instrument-item-name='%s']", itemName)));
//            instrumentItem.click();
//        }
//        return this;
//    }


}
